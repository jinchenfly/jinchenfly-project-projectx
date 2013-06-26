package com.iptest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	 public static Properties getProperties(){    
	      Properties p = new Properties();    
	      p.put("mail.smtp.host", "smtp.163.com");    
	      p.put("mail.smtp.port", "25");    
	      p.put("mail.smtp.auth", "true");    
	      return p;    
	    }
	 public static boolean sendHtmlMail(String str){
	      // 判断是否需要身份认证    
	      MyAuthenticator authenticator = null;   
	      Properties pro = getProperties();   
	      //如果需要身份认证，则创建一个密码验证器     
	         
	      authenticator = new MyAuthenticator("jinchenfly", "06rjgcjcq");   
	      
	      // 根据邮件会话属性和密码验证器构造一个发送邮件的session    
	      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);  
	      sendMailSession.setDebug(true);
	      try {    
	      // 根据session创建一个邮件消息    
	      Message mailMessage = new MimeMessage(sendMailSession);    
	      // 创建邮件发送者地址    
	      Address from = new InternetAddress("jinchenfly@163.com");    
	      // 设置邮件消息的发送者    
	      mailMessage.setFrom(from);    
	      // 创建邮件的接收者地址，并设置到邮件消息中    
	      Address to = new InternetAddress("jinchenfly@163.com");    
	      // Message.RecipientType.TO属性表示接收者的类型为TO    
	      mailMessage.setRecipient(Message.RecipientType.TO,to);    
	      // 设置邮件消息的主题    
	      mailMessage.setSubject("IP地址通知");    
	      // 设置邮件消息发送的时间    
	      mailMessage.setSentDate(new Date());    
	      // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象    
	      Multipart mainPart = new MimeMultipart();    
	      // 创建一个包含HTML内容的MimeBodyPart    
	      BodyPart html = new MimeBodyPart();    
	      // 设置HTML内容    
	      html.setContent(str, "text/html; charset=utf-8");    
	      mainPart.addBodyPart(html);    
	      // 将MiniMultipart对象设置为邮件内容    
	      mailMessage.setContent(mainPart);    
	      // 发送邮件    
	      Transport.send(mailMessage);    
	      return true;    
	      } catch (MessagingException ex) {    
	          ex.printStackTrace();    
	      }    
	      return false;    
	    }   
	

	 public static void main(String[] args){
		 String emailTemplate = null;
		 try {
			 	InputStream in = new FileInputStream("D:/resetPasswordMail.html");
			 	byte[] styleSheetBytes = new byte[10240];
			 	in.read(styleSheetBytes,0,styleSheetBytes.length);
			 	in.close();
				emailTemplate = new String(styleSheetBytes,"utf8");
				emailTemplate = emailTemplate.replaceAll("@PASSWORD\\$", "123");
				emailTemplate = emailTemplate.replaceAll("@ACCOUNT\\$", "321");
				emailTemplate = emailTemplate.replaceAll("@CITY\\$", "21");
				System.out.println(emailTemplate);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Mail.sendHtmlMail(emailTemplate);
	 }
}
class MyAuthenticator extends Authenticator{ 
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }
}
