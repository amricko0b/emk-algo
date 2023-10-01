package xyz.amricko0b.tablegames.restapi;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GameResourceTests {

  @Test
  void test_put() {

    RestAssured.given().put("/api/game/Dungeons%20And%20Dragons").then().statusCode(200);
  }
}
