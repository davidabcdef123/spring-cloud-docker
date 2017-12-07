package springcloud.servicediscovereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoverEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoverEurekaApplication.class, args);
	}
}
