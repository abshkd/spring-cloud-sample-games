package spring.cloud.games;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Redirect the remote requests to a local controller with expected responses
*/
@RestController
@RequestMapping("/mock")
public class MockController {

  @GetMapping("/gameslist")
  public ResponseEntity<String> should_returnListOfGames() {
    return ResponseEntity.ok("game1,game2,game3");
  }

}
