package br.com.guilhermesantana.sprintbootcommysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.guilhermesantana.sprintbootcommysql")
@EntityScan(basePackages = "br.com.guilhermesantana.sprintbootcommysql.model")
public class SprintBootComMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootComMysqlApplication.class, args);
	}

}
