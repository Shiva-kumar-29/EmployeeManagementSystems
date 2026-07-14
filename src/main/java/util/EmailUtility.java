package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {
	public static void sendOTP(String toEmail, int otp) {
   
		final String fromEmail = "chityalashivakumar7@gmail.com";
		final String appPassword = "czud xnpo lhvy uxjc";
		
		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");

		properties.put("mail.smtp.port", "587");

		properties.put("mail.smtp.auth", "true");

		properties.put("mail.smtp.starttls.enable", "true");
		

	    Session session = Session.getInstance(properties, new Authenticator() {

	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {

	            return new PasswordAuthentication(fromEmail, appPassword);

	        }

	    });
	    
	    try {

	        Message message = new MimeMessage(session);

	        message.setFrom(new InternetAddress(fromEmail));

	        message.setRecipients(
	                Message.RecipientType.TO,
	                InternetAddress.parse(toEmail));

	        message.setSubject("Email Verification OTP");

	        message.setText(
	                "Dear User,\n\n"
	                + "Your OTP for Employee Management System registration is: "
	                + otp
	                + "\n\n"
	                + "This OTP is valid for 5 minutes."
	                + "\n\nRegards,\nEmployee Management System");

	        Transport.send(message);

	        System.out.println("OTP Email Sent Successfully!");

	    }
	    catch (MessagingException e) {

	        e.printStackTrace();

	    }
		
	}
}