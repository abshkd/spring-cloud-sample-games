package spring.cloud.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/games")
public class GamesController {

  @Autowired
  RestTemplate restTemplate;

  /*
  * Fetch a String of items from another microservice
   */
  @RequestMapping("/list")
  public String list() {
    ResponseEntity<String> response =  restTemplate
        .exchange("http://library-service/gameslist", HttpMethod.GET, null, String.class);
    return response.getBody();
  }
}
