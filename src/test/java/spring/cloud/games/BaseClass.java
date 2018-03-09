package spring.cloud.games;

//import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class BaseClass {

  @Autowired
  GamesProperties gamesProperties;

  @Autowired
  private RestTemplate restTemplate;

  @Before
  public void setup() {
    //RestAssuredMockMvc.standaloneSetup(new GamesController(restTemplate,gamesProperties));
  }
}
