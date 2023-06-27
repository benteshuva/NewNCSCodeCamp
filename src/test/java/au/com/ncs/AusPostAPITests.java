package au.com.ncs;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class AusPostAPITests {

    @Test
    public void tascottStatusTest(){
        given().header("auth-key", "1bed992c-e425-44f6-9551-090cd99f99ed").and()
                .param("q", "Tasscot").and()
                .param("state","NSW")
        .when().get("https://digitalapi.auspost.com.au/postcode/search.json").
                then().
                assertThat().statusCode(is(200));

    }

    @Test
    public void tascottPostCodeTest(){
        given().header("auth-key", "1bed992c-e425-44f6-9551-090cd99f99ed").and()
                .param("q", "Tasscot").and()
                .param("state","NSW")
        .when().get("https://digitalapi.auspost.com.au/postcode/search.json").
                then().
                assertThat().body("localities.locality.postcode".equalsTo(2250));
    }
}
