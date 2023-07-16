package com.common.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class MailController {

	@Autowired
	private EmailConfig conf;
    
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@PostMapping("/send")
	public void send(@RequestBody MailObject mail) {
//		final String username = "feng5241@gmail.com";
//        final String password = "2462205532";

		final String username = conf.getName();
        final String password = conf.getPassword();
        System.out.println("username:" + username);
        System.out.println("password:"+password);

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        
		try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(mail.getFrom()));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(mail.getTo())
        );
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
	}

    @PostMapping("/sendTeamLift")
    public void sendTeamLift(@RequestBody MailObject mail) {
//		final String username = "feng5241@gmail.com";
//        final String password = "2462205532";

        final String username = conf.getTeamLiftName();
        final String password = conf.getTeamLiftPassword();
        System.out.println("username:" + username);
        System.out.println("password:"+password);

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail.getFrom()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail.getTo())
            );
            message.setSubject(mail.getSubject());
            message.setText(mail.getContent());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
