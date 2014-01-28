/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SendMailApp;
import java.util.Date;    
import java.util.Properties;   
import javax.mail.Address;    
import javax.mail.BodyPart;    
import javax.mail.Message;    
import javax.mail.MessagingException;    
import javax.mail.Multipart;    
import javax.mail.Session;    
import javax.mail.Transport;    
import javax.mail.internet.InternetAddress;    
import javax.mail.internet.MimeBodyPart;    
import javax.mail.internet.MimeMessage;    
import javax.mail.internet.MimeMultipart;    
/**
 *
 * @author lu
 */
public class MailSetter {
    //文本文件方式发送
    public boolean sendTextMail(MailSenderInfo mailInfo)
    {
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if(mailInfo.isValidate())
        {
            authenticator= new MyAuthenticator(mailInfo.getUserName(),mailInfo.getPassWord());
        }
        Session sendMailSession = Session.getDefaultInstance(pro,authenticator);
        try
        {
            Message mailMessage = new MimeMessage(sendMailSession);
            Address from = new InternetAddress(mailInfo.getFromAddress());
            mailMessage.setFrom(from);
            Address to = new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            mailMessage.setSubject(mailInfo.getMailSubject());
            mailMessage.setSentDate(new Date());
            mailMessage.setText(mailInfo.getMailContent());
            Transport.send(mailMessage);
            return true;
        }
        catch(MessagingException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean sendHTMLMail(MailSenderInfo mailInfo)
    {
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if(mailInfo.isValidate())
        {
            authenticator = new MyAuthenticator(mailInfo.getUserName(),mailInfo.getPassWord());
        }
        Session sendMailSession = Session.getDefaultInstance(pro,authenticator);
        try
        {
            Message mailMessage = new MimeMessage(sendMailSession);
            Address from = new InternetAddress(mailInfo.getFromAddress());
            mailMessage.setFrom(from);
            Address to = new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            mailMessage.setSubject(mailInfo.getMailSubject());
            mailMessage.setSentDate(new Date());
            Multipart mainPart = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(mailInfo.getMailContent(),"text/html;charset=utf-8");
            mainPart.addBodyPart(html);
            mailMessage.setContent(mainPart);
            Transport.send(mailMessage);
            return true;
        }
        catch(MessagingException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
