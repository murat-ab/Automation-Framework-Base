package me.abetayev.backEndTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BackEndApiTests {

    @Test
    public void basicBackEndTest() {
        RestAssured
                .given()
                .header("Accept", "application/json")
                .when()
                .get("https://abetayev.me")
                .then()
                .assertThat().statusCode(200);
    }
}
