package RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class LoggingMethods {

    @Test
    public void loggingmethods()
    {
        given()

                .when().get("https://reqres.in/api/users?page=2")

                .then()
                //.log().ifError()
                //.log().headers()
                //.log().body()
                //.log().everything()
                //.log().cookies()
                //.log().status()
                .log().all();



    }
}
