package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.CompleteTaskService;
import com.demo.service.MailSenderService;

@RestController
public class MailController {

	@Autowired
	MailSenderService mail;

	@Autowired
	CompleteTaskService service;

	@GetMapping("send")
	public String send() {

		// mail.send(service.getWeek());
		mail.send(service.getWeek());

		return "success";
	}
}
