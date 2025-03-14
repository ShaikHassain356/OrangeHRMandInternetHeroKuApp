package RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JsonSchemaValidation {
    @Test
    public void jsonschemavalidation()
    {

        given()

                .when().get("http://localhost:3000/store")

                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("bookjsonschema.json"));
    }
}
