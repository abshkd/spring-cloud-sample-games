package spring.cloud.games;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Java6Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
public class GamesApplicationTests {

	@Autowired GamesController gamesController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetGamesListFromMicroservice(){
		stubFor(get(urlEqualTo("http://library-service/gameslist"))
		.willReturn(aResponse().withHeader("Content-Type", "text/plain").withBody("game 1,game 2,game 3, etc")));

		assertThat(this.gamesController.list()).isEqualTo("game 1,game 2,game 3, etc");
	}
}
