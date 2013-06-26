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
	      // �ж��Ƿ���Ҫ�����֤    
	      MyAuthenticator authenticator = null;   
	      Properties pro = getProperties();   
	      //�����Ҫ�����֤���򴴽�һ��������֤��     
	         
	      authenticator = new MyAuthenticator("jinchenfly", "06rjgcjcq");   
	      
	      // �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session    
	      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);  
	      sendMailSession.setDebug(true);
	      try {    
	      // ����session����һ���ʼ���Ϣ    
	      Message mailMessage = new MimeMessage(sendMailSession);    
	      // �����ʼ������ߵ�ַ    
	      Address from = new InternetAddress("jinchenfly@163.com");    
	      // �����ʼ���Ϣ�ķ�����    
	      mailMessage.setFrom(from);    
	      // �����ʼ��Ľ����ߵ�ַ�������õ��ʼ���Ϣ��    
	      Address to = new InternetAddress("jinchenfly@163.com");    
	      // Message.RecipientType.TO���Ա�ʾ�����ߵ�����ΪTO    
	      mailMessage.setRecipient(Message.RecipientType.TO,to);    
	      // �����ʼ���Ϣ������    
	      mailMessage.setSubject("IP��ַ֪ͨ");    
	      // �����ʼ���Ϣ���͵�ʱ��    
	      mailMessage.setSentDate(new Date());    
	      // MiniMultipart����һ�������࣬����MimeBodyPart���͵Ķ���    
	      Multipart mainPart = new MimeMultipart();    
	      // ����һ������HTML���ݵ�MimeBodyPart    
	      BodyPart html = new MimeBodyPart();    
	      // ����HTML����    
	      html.setContent(str, "text/html; charset=utf-8");    
	      mainPart.addBodyPart(html);    
	      // ��MiniMultipart��������Ϊ�ʼ�����    
	      mailMessage.setContent(mainPart);    
	      // �����ʼ�    
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
