package spring.cloud.games;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class GamesApplicationTests {

  @Autowired
  GamesController gamesController;
  @Autowired
  GamesProperties gamesProperties;

  @Autowired
  private RestTemplate restTemplate;

  @Test
  public void contextLoads() {
  }

  @Test
  public void testGetGamesListFromMicroservice() {

    assertThat(this.gamesController.list()).isEqualTo("game1,game2,game3");
  }
}
