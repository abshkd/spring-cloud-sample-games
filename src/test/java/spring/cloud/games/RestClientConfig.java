package spring.cloud.games;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;

/*
* Disable the discovery client
*/
@Configuration
@Profile("test")
public class RestClientConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
