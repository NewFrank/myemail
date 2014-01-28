/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SendMailApp;
import java.util.Properties;

/**
 *
 * @author lu
 */
public class MailSenderInfo {
    private String mailServerHost;
    private String mailServerPort;
    private String fromAddress;
    private String toAddress;
    private String userName;
    private String passWord;
    private boolean validate = false;
    private String mailSubject;
    private String mailContent;
    private String[] attachFileNames;
    
    public Properties getProperties()
    {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.getMailServerHost());
        p.put("mail.smtp.port", this.getMailServerPort());
        p.put("mail.smtp.auth",this.isValidate()?"true":"false");
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.put("mail.smtp.socketFactory.fallback","false");
        p.put("mail.smtp.socketFactory.port",this.getMailServerPort());
        return p;
    }

    /**
     * @return the mailServerHost
     */
    public String getMailServerHost() {
        return mailServerHost;
    }

    /**
     * @param mailServerHost the mailServerHost to set
     */
    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    /**
     * @return the mailServerPort
     */
    public String getMailServerPort() {
        return mailServerPort;
    }

    /**
     * @param mailServerPort the mailServerPort to set
     */
    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    /**
     * @return the fromAddress
     */
    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * @param fromAddress the fromAddress to set
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    /**
     * @return the toAddress
     */
    public String getToAddress() {
        return toAddress;
    }

    /**
     * @param toAddress the toAddress to set
     */
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * @return the validate
     */
    public boolean isValidate() {
        return validate;
    }

    /**
     * @param validate the validate to set
     */
    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    /**
     * @return the mailSubject
     */
    public String getMailSubject() {
        return mailSubject;
    }

    /**
     * @param mailSubject the mailSubject to set
     */
    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    /**
     * @return the mailContent
     */
    public String getMailContent() {
        return mailContent;
    }

    /**
     * @param mailContent the mailContent to set
     */
    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    /**
     * @return the attachFileNames
     */
    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    /**
     * @param attachFileNames the attachFileNames to set
     */
    public void setAttachFileNames(String[] attachFileNames) {
        this.attachFileNames = attachFileNames;
    }
    
    
}
