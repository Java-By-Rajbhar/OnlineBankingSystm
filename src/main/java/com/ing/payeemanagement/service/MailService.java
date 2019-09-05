package com.ing.payeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.ing.payeemanagement.dto.EmailDto;

@Component
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendOTPEmail(String emailId, String message) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailId);
		mail.setSubject("INGTMRW Model Bank");

		mail.setText("The OTP for Making Transfer" + " " + message);
		javaMailSender.send(mail);
	}

	public void sendEmail(EmailDto emailDto) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailDto.getEmailId());
		mail.setSubject(emailDto.getSubject());

		mail.setText(emailDto.getTextBody());
		javaMailSender.send(mail);
	}

}