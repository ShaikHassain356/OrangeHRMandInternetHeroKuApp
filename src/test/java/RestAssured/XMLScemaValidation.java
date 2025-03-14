package RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLScemaValidation {

    @Test
    public void xmlschemavalidation()
    {

        given()

                .when().get("http://localhost:3000/agents.xml")

                .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("schema.xsd"));
    }
}
