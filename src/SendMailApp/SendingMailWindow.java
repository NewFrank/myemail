/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SendMailApp;

import java.awt.Dialog;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;

/**
 *
 * @author lu
 */
public class SendingMailWindow extends javax.swing.JFrame {

    private static MailSenderInfo mailInfo = new MailSenderInfo();
    private static SetSenderInfoDialog ssid = new SetSenderInfoDialog(null,true,mailInfo);
    /**
     * Creates new form SendingMailWindow
     */
    public SendingMailWindow() {
        initComponents();
    }

    private boolean checkValidation()
    {
        String regexstr = "\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        Pattern pat = Pattern.compile(regexstr);
        Matcher mat = pat.matcher(this.jTextRecipient.getText());
        if(mat.matches() == false)
        {
            JOptionPane.showMessageDialog(null, "Please input correct Recipient address!", "Notify", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        mat = pat.matcher(this.jTextSender.getText());
        if(mat.matches() == false)
        {
            JOptionPane.showMessageDialog(null, "Please input correct Sender address!", "Notify", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(this.jTextSubject.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please input Subject!", "Notify", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(this.jTextContent.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please input Subject!", "Notify", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(mailInfo.getMailServerHost().isEmpty() || mailInfo.getMailServerPort().isEmpty() || mailInfo.getUserName().isEmpty() || mailInfo.getPassWord().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please fill in Sender Information!", "Notify", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void getInformationFromWindow()
    {
        mailInfo.setFromAddress(this.jTextSender.getText());
        mailInfo.setToAddress(this.jTextRecipient.getText());
        mailInfo.setMailSubject(this.jTextSubject.getText());
        mailInfo.setMailContent(this.jTextContent.getText());
    }
    
    private void setInformationToWindow()
    {
        this.jTextSender.setText(mailInfo.getFromAddress());
        this.jTextRecipient.setText(mailInfo.getToAddress());
        this.jTextSubject.setText(mailInfo.getMailSubject());
        this.jTextContent.setText(mailInfo.getMailContent());
    }
    
    private void sendThisMail()
    {
        MailSetter ms = new MailSetter();
        
        boolean result = ms.sendTextMail(mailInfo);
        if(result)
        {
            JOptionPane.showMessageDialog(null, "Success to send mail!", "Notify", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Fail to send mail!!", "Notify", JOptionPane.WARNING_MESSAGE);
        }
        
                //        public static void main(String[] args){   
//         //这个类主要是设置邮件   
//      MailSenderInfo mailInfo = new MailSenderInfo();    
//      mailInfo.setMailServerHost("smtp.163.com");    
//      mailInfo.setMailServerPort("25");    
//      mailInfo.setValidate(true);    
//      mailInfo.setUserName("han2000lei@163.com");    
//      mailInfo.setPassword("**********");//您的邮箱密码    
//      mailInfo.setFromAddress("han2000lei@163.com");    
//      mailInfo.setToAddress("han2000lei@163.com");    
//      mailInfo.setSubject("设置邮箱标题 如http://www.guihua.org 中国桂花网");    
//      mailInfo.setContent("设置邮箱内容 如http://www.guihua.org 中国桂花网 是中国最大桂花网站==");    
//         //这个类主要来发送邮件   
//      SimpleMailSender sms = new SimpleMailSender();   
//          sms.sendTextMail(mailInfo);//发送文体格式    
//          sms.sendHtmlMail(mailInfo);//发送html格式   
//    }  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextRecipient = new javax.swing.JTextField();
        jTextSender = new javax.swing.JTextField();
        jTextSubject = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextContent = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Send Email");

        jButton1.setText("Change Sender Info");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setText("Recipient:");

        jLabel2.setText("Subject:");

        jLabel3.setText("Sender:");

        jLabel4.setText("Text:");

        jTextRecipient.setText("验证");

        jTextSender.setText("验证");

        jTextContent.setColumns(20);
        jTextContent.setRows(5);
        jScrollPane1.setViewportView(jTextContent);

        jButton2.setText("Send");
        jButton2.setToolTipText("");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextRecipient)
                            .addComponent(jTextSender)
                            .addComponent(jTextSubject)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextRecipient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        ssid.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "You want to cancel this and quit?", "Warning", JOptionPane.YES_NO_OPTION);
        if(result == 0)
        {
            System.exit(1);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "You sure you want to send this mail?", "Warning", JOptionPane.YES_NO_OPTION);
        if(result == 1)
        {
            return;
        }
        else
        {
            if(checkValidation() == false)
            {
                return;
            }
            else
            {
                getInformationFromWindow();
                sendThisMail();
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SendingMailWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendingMailWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendingMailWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendingMailWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendingMailWindow().setVisible(true);
            }
        });

        ssid.setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextContent;
    private javax.swing.JTextField jTextRecipient;
    private javax.swing.JTextField jTextSender;
    private javax.swing.JTextField jTextSubject;
    // End of variables declaration//GEN-END:variables
}