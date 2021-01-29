package com.mmt.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.stream.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	MessageChannel output;
	
	@PostMapping("/publish")
	public Employee publishEvent(@RequestBody Employee employee) {
		output.send(MessageBuilder.withPayload(employee).build());
		return employee;
	}

}
