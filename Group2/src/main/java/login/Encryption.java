//Author : Vamsi Krishna Utla

package login;

import login.Interfaces.*;

public class Encryption implements IEncryption
{
    public String encryptPassword(String user_password)
    {
        int maxKey = 126;
        int minKey = 33;
        String result;
        char[] duplicatePassword = user_password.toCharArray();
        for(int i=0;i<user_password.length();i++)
        {
            int encryptKey = i+user_password.charAt(i);
            if(encryptKey > maxKey)
            {
                encryptKey = minKey;
            }
            else if(encryptKey < minKey)
            {
                encryptKey = maxKey;
            }
            duplicatePassword[i]=(char)encryptKey;
        }
        result=String.valueOf(duplicatePassword);
        return result;
    }
}
