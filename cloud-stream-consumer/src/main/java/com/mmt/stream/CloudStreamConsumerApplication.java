package com.mmt.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.mmt.stream.model.Employee;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class CloudStreamConsumerApplication {
	
	@StreamListener("input")
	public void consumeMessage(Employee employee) {
		log.info("Consuming from Kafka topic"+employee);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamConsumerApplication.class, args);
	}

}
