package RestAssured.Authentications;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DigestAuth {

    @Test
    public void digestauth()
    {
        given().auth().digest("postman","password")
                .when().get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .log().all().body("authenticated",equalTo(true));
    }
}
