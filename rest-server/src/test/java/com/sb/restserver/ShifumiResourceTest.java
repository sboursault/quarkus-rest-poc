package com.sb.restserver;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.either;

@QuarkusTest
public class ShifumiResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().post("/play")
          .then()
             .statusCode(200)
             .body(either(
                     is("ROCK")
             ).or(
                     is("SCISSORS")
             ).or(
                     is("PAPER")
             ));
    }

}