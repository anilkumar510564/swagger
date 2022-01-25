package com.example.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Vaman Deshmukh
 * @category Learning project
 *
 */
@EnableSwagger2
@SpringBootApplication
public class SampleApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SampleApplication.class);

	public static void main(String[] args) {
//		System.out.println("Start");
		LOG.info("Start");
		SpringApplication.run(SampleApplication.class, args);
		LOG.info("End");
	}
}
