package RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {

    @Test
    public void fetchinguserdetailsusingid()
    {

        given()
                .pathParams("mypath","users")
                .queryParam("page",2)
                .queryParam("id",5)

                .when().get("https://reqres.in/api/{mypath}")

                .then()
                .log()
                .all();
    }
}
