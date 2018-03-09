package spring.cloud.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(GamesProperties.class)
@EnableDiscoveryClient
public class GamesApplication {


  public static void main(String[] args) {
    SpringApplication.run(GamesApplication.class, args);
  }
}
