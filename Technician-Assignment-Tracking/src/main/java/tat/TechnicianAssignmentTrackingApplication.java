package tat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TechnicianAssignmentTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicianAssignmentTrackingApplication.class, args);
	}

}
