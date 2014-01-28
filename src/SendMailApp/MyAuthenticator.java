/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SendMailApp;
import javax.mail.*;
/**
 *
 * @author lu
 */
public class MyAuthenticator extends Authenticator{
    String userName=null;
    String passWord=null;
    public MyAuthenticator(String username, String password)
    {
        this.userName = username;
        this.passWord = password;
    }
    
    protected PasswordAuthentication getPassworAuthentication()
    {
        return new PasswordAuthentication(this.userName,this.passWord);
    }
}
