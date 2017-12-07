package springcloud.servicediscovereurekaha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceDiscoverEurekaHaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoverEurekaHaApplication.class, args);
	}
}
