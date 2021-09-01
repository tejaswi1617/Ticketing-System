//Author : Vamsi Krishna Utla

package login;

import login.Interfaces.IEncryption;
import login.Interfaces.IForgotPassword;
import login.Interfaces.IForgotPasswordDao;
import login.Interfaces.IPasswordValidations;
import login.abstractfactory.ILoginFactory;
import login.abstractfactory.LoginFactory;
import mailservice.abstractfactory.IMailFactory;
import mailservice.abstractfactory.MailFactory;
import mailservice.interfaces.IMail;
import mailservice.interfaces.IMailMessage;

public class ForgotPassword implements IForgotPassword
{
    private int otp;
    private String employeeID;
    private final IMailFactory factoryMethodMail = MailFactory.instance();
    private final IMail mail;
    private final IMailMessage mailMessage = factoryMethodMail.makeMailMessageObject();
    private final IForgotPasswordDao persistenceForgotPasswordOperations;

    public ForgotPassword(IMail mail, IForgotPasswordDao persistenceForgotPasswordOperations)
    {
        this.mail = mail;
        this.persistenceForgotPasswordOperations = persistenceForgotPasswordOperations;
    }

    public boolean sendOTP(String employeeID)
    {
        double otpDouble;
        final String mailConfiguration = "MailConfiguration.properties";
        final String userConfiguration = "MailUserConfiguration.properties";
        this.employeeID = employeeID;
        String email;
        String subject;
        String message;
        int minimum = 1000;
        otpDouble = Math.random();

        if(otpDouble == 0)
        {
            otp = minimum;
        }
        else
        {
            otpDouble = otpDouble * minimum;
            otp = (int)otpDouble;
        }

        email = persistenceForgotPasswordOperations.getEmail(employeeID);
        subject = "Mock Service Now: OTP Request";
        message = "Hello,\nThe OTP to update password is : "+otp+"\nThanks & Regards,\nMock Service Now Team";

        mailMessage.addRecipient(email);
        mailMessage.addSubject(subject);
        mailMessage.addBody(message);

        try
        {
            return mail.sendMail(mailConfiguration, userConfiguration, mailMessage);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean updatePassword(int otp, String newPassword)
    {
        ILoginFactory loginFactory = LoginFactory.instance();
        IEncryption encryption = loginFactory.getEncryption();
        IPasswordValidations passwordValidations = new PasswordValidations();
        if( passwordValidations.checkUpperCaseRule(newPassword) &&
            passwordValidations.checkLowerCaseRule(newPassword) &&
            passwordValidations.checkNumberRule(newPassword) &&
            passwordValidations.checkSpecialCharacterRule(newPassword) &&
            passwordValidations.checkLengthRule(newPassword) &&
            this.otp == otp)
        {
            newPassword = encryption.encryptPassword(newPassword);
            return persistenceForgotPasswordOperations.updatePassword(this.employeeID, newPassword);
        }
        return false;
    }
}
