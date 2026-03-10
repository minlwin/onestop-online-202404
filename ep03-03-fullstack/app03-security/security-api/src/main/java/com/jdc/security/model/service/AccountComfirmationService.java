package com.jdc.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class AccountComfirmationService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	private String senderMail;
	
	
	private static final String TEMPLATE = """
			<h1>Account Comfirmation</h1>	
			<p>Please activate your account.</p>
			<p>Your OTP : <b>%s</b></p>
			""";

	public void sendComfirmMail(String email, String otpCode) {
		
		try {
			var message = mailSender.createMimeMessage();
			var helper = new MimeMessageHelper(message, "utf-8");
			
			helper.addTo(email);
			helper.setFrom(senderMail);
			helper.setSubject("Account Activation");
			
			helper.setText(TEMPLATE.formatted(otpCode), true);
			
			mailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
