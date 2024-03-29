package in.stackroute.ust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = "in.stackroute.ust")

public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
    }
}