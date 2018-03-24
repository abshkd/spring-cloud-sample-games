package spring.cloud.games;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GamesApplication.class)
@AutoConfigureStubRunner(ids = {"spring.cloud:games:+:stubs:6565"}, workOffline = true)
@DirtiesContext
public class GamesApplicationTests {

  @Autowired
  GamesController gamesController;
  @Autowired
  GamesProperties gamesProperties;

  @Test
  public void contextLoads() {
  }

  @Test
  public void testGetGamesListFromMicroservice() {

    assertThat(this.gamesController.list()).isEqualTo("game1, game2, game3");
  }
}
