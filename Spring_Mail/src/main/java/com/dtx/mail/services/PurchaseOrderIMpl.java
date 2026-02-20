package com.dtx.mail.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("purchaseOrder")
public class PurchaseOrderIMpl implements IPurchaseOrder {
	@Autowired
	private JavaMailSender sender;
	@Value("${spring.mail.username}")
	private String fromMail;

	@Override
	public String purchase(String[] items, double[] price, String[] emails) throws Exception {
		double billamount = 0.0;
		for (double p : price)
			billamount = billamount + p;
		String msg = Arrays.toString(items) + " value are  " + billamount;
		String status = sendMail(msg, emails);
		return msg + "Status send sucessfully" + status;
	}

	public String sendMail(String msg, String[] emails) throws Exception {
		MimeMessage mimeMsg = sender.createMimeMessage();
		MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMsg, true);
		mimeHelper.setFrom(fromMail);
		mimeHelper.setCc(emails);
		mimeHelper.setSubject("Open it for fun");
		mimeHelper.setSentDate(new Date());
		mimeHelper.setText(msg);
		sender.send(mimeMsg);

		return "mail Send";
	}

}
