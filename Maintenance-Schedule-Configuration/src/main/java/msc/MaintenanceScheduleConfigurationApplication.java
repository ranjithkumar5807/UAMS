package msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MaintenanceScheduleConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceScheduleConfigurationApplication.class, args);
	}

}
