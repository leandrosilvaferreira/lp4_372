package com.myimage.utils;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Mail {

	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String from, String to, String subject, String content) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setFrom(from);
		msg.setSubject(subject);
		msg.setText(content);
		try {
			this.mailSender.send(msg);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
