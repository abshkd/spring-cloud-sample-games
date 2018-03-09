package spring.cloud.games;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/games")
public class GamesController {

  RestTemplate restTemplate;

  GamesProperties gamesProperties;

  public GamesController(RestTemplate restTemplate, GamesProperties gamesProperties) {
    this.restTemplate = restTemplate;
    this.gamesProperties = gamesProperties;
  }

  /*
    * Fetch a String of items from another microservice
     */
  @RequestMapping("/list")
  public String list() {
    ResponseEntity<String> response = restTemplate
        .exchange(this.gamesProperties.getLibraryUrl(), HttpMethod.GET, null, String.class);
    return response.getBody();
  }
}
