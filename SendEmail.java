package com.memorynotfound.mail;

import java.io.IOException;
import java.util.Properties;

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

public class SendEmail {

	public static void main(String[] args) throws IOException {
		//authentication info
		final String username = "harish.enagante@gmail.com";
		final String password = "infosys6";
		String fromEmail = "harish.enagante@gmail.com";
		String toEmail = "harish.enagante@gmail.com";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		//Start our mail message
		
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Subject Line");
			//msg.setText("This is test mail!");
			
			Multipart emailContent = new MimeMultipart();
			// Text body part
			MimeBodyPart textBodyPart= new MimeBodyPart();
			textBodyPart.setText("My Multipart textl!");
			
			//attachment file
			MimeBodyPart pdfAttachment=new MimeBodyPart();
			pdfAttachment.attachFile("D:/Harikishan Enaganti.pdf");
			
			MimeBodyPart pdfAttachment1=new MimeBodyPart();
			pdfAttachment1.attachFile("D:/AdvancePremium_9278019_lic.pdf");
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			emailContent.addBodyPart(pdfAttachment1);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			
			
			Transport.send(msg);
			System.out.println("Sent message Successfully!");
			
			/*
			 * Multipart emailContent = new MimeMultipart();
			 * 
			 * //Text body part MimeBodyPart textBodyPart = new MimeBodyPart();
			 * textBodyPart.setText("My multipart text");
			 * 
			 * //Attachment body part. MimeBodyPart pdfAttachment = new MimeBodyPart(); //
			 * pdfAttachment.attachFile("/home/parallels/Documents/docs/javamail.pdf");
			 * 
			 * //Attach body parts emailContent.addBodyPart(textBodyPart);
			 * emailContent.addBodyPart(pdfAttachment);
			 * 
			 * //Attach multipart to message msg.setContent(emailContent);
			 */
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
