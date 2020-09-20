package com.thoughtworks.capability.gtb.demospringconfig;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class DemoSpringConfigApplication implements ApplicationRunner {

	private final MailConfig mailConfig;

	public DemoSpringConfigApplication(MailConfig mailConfig) {
		this.mailConfig = mailConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringConfigApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(mailConfig);
	}
}
