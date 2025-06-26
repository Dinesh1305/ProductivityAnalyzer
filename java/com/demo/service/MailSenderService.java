package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.demo.model.CompleteTasks;
import com.demo.model.Task;
import com.demo.model.Tasks;

@Service
public class MailSenderService {

	
	@Autowired
	JavaMailSender send;
	
	public void send(List<Tasks> list)
	{
	
		SimpleMailMessage sender=new SimpleMailMessage();
		StringBuilder builder=new StringBuilder();
		for(Tasks h:list)
			builder.append(h.getWork()+"  "+h.getTotalDuration()+" \n");
		
		sender.setTo("71762305014@cit.edu.in");
		
		
		System.out.println(builder);
		sender.setText(new String(builder));
		send.send(sender);
		
	}
	
}
