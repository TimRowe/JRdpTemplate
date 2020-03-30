package com.rdp.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 10011531
 */
@SpringBootApplication(scanBasePackages = {"com.rdp.*"})
@MapperScan("com.rdp.template.repository")
public class RdpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdpApplication.class, args);

	}

}
