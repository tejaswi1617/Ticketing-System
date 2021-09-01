//Author : Vamsi Krishna Utla

package login;

import login.Interfaces.IForgotPassword;
import login.Interfaces.IForgotPasswordDao;
import login.abstractfactory.ILoginFactory;
import login.abstractfactory.ILoginFactoryTest;
import login.abstractfactory.LoginFactory;
import login.abstractfactory.LoginFactoryTest;
import mailservice.interfaces.IMail;
import org.junit.Test;
import static org.junit.Assert.*;

public class ForgotPasswordTest
{
    ILoginFactoryTest loginFactoryTest = LoginFactoryTest.instance();
    ILoginFactory loginFactory = LoginFactory.instance();
    IMail mail = loginFactoryTest.getMailMock();
    IForgotPasswordDao forgotPasswordOperations = loginFactoryTest.getPersistenceForgotPasswordOperationsMock();
    IForgotPassword forgotPassword = loginFactory.getForgotPassword(mail, forgotPasswordOperations);

    @Test
    public void sendOTPTest()
    {
        assertTrue("Forgot password mail - send OTP failed.", forgotPassword.sendOTP("EMP_123"));
    }

    @Test
    public void updatePasswordTest()
    {
        assertFalse("Update password failed for forgot password feature.", forgotPassword.updatePassword(3456, "dummy123"));
    }
}