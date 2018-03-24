package spring.cloud.games;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", "Bearer VALID_TOKEN");
    HttpEntity requestEntity = new HttpEntity(httpHeaders);
    ResponseEntity<String> response = restTemplate
        .exchange(this.gamesProperties.getLibraryUrl(), HttpMethod.GET, requestEntity,
            String.class);
    return response.getBody();
  }
}
