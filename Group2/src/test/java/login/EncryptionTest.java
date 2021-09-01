//Author : Vamsi Krishna Utla

package login;

import org.junit.Test;
import static org.junit.Assert.*;

public class EncryptionTest
{
    @Test
    public void encryptPasswordTest()
    {
        Encryption encryption = new Encryption();
        String password = "Abcd@123";
        String result = encryption.encryptPassword(password);
        assertEquals("AcegD68:", result);
    }
}