//Author : Vamsi Krishna Utla

package login;

import login.Interfaces.IPasswordValidations;

public class PasswordValidations implements IPasswordValidations
{
    public boolean checkUpperCaseRule(String user_password)
    {
        boolean upperCaseResult = false;
        int lowerThreshold = 65;
        int higherThreshold = 90;
        for(int i=0;i<user_password.length();i++)
        {
            char c = user_password.charAt(i);
            if(c>=lowerThreshold && c<=higherThreshold)
            {
                upperCaseResult = true;
                return upperCaseResult;
            }
        }
        return upperCaseResult;
    }

    public boolean checkLowerCaseRule(String user_password)
    {
        boolean lowerCaseResult = false;
        int lowerThreshold = 97;
        int higherThreshold = 122;
        for(int i=0;i<user_password.length();i++)
        {
            char c = user_password.charAt(i);
            if(c>=lowerThreshold && c<=higherThreshold)
            {
                lowerCaseResult = true;
                return lowerCaseResult;
            }
        }
        return lowerCaseResult;
    }

    public boolean checkNumberRule(String user_password)
    {
        boolean checkNumberResult = false;
        int lowerThreshold = 48;
        int higherThreshold = 57;
        for(int i=0;i<user_password.length();i++)
        {
            char c = user_password.charAt(i);
            if(c>=lowerThreshold && c<=higherThreshold)
            {
                checkNumberResult = true;
                return checkNumberResult;
            }
        }
        return checkNumberResult;
    }

    public boolean checkSpecialCharacterRule(String user_password)
    {
        boolean checkSpecialCharacterResult = false;
        int lowerThreshold_first = 33;
        int higherThreshold_first = 47;
        int lowerThreshold_second = 58;
        int higherThreshold_second = 64;
        int lowerThreshold_third = 91;
        int higherThreshold_third = 96;
        int lowerThreshold_fourth = 123;
        int higherThreshold_fourth = 126;

        for(int i=0;i<user_password.length();i++)
        {
            char c = user_password.charAt(i);
            if((c>=lowerThreshold_first && c<=higherThreshold_first) ||
                    (c>=lowerThreshold_second && c<=higherThreshold_second) ||
                    (c>=lowerThreshold_third && c<=higherThreshold_third) ||
                    (c>=lowerThreshold_fourth && c<=higherThreshold_fourth))
            {
                checkSpecialCharacterResult = true;
                return checkSpecialCharacterResult;
            }
        }
        return checkSpecialCharacterResult;
    }

    public boolean checkLengthRule(String user_password)
    {
        boolean checkLengthResult = false;
        int minLength = 8;
        int maxLength = 100;

        if(user_password.length()>=minLength && user_password.length()<=maxLength)
        {
            checkLengthResult = true;
            return checkLengthResult;
        }
        return checkLengthResult;
    }
}
