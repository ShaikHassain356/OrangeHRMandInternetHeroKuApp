package RestAssured.Authentications;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class APIKeyAuth {

    //@Test
    public void apikeyauth()
    {
        given().queryParam("appid","dd5e430fd0668078a6a026da74ff631b") // here appid is API key from weather application

                .when().get("https://api.openweathermap.org/data/2.5/weather?lat=16.50745000&lon=80.64660000")

                .then()
                .statusCode(200)

                .body("name",equalTo("Mogalrājapuram"))
                .log()
                .all();
    }

    // method2

    @Test(priority = 1)
    public void apikeyqueryandpathparam()
    {

        given().queryParam("appid","dd5e430fd0668078a6a026da74ff631b")
                .pathParam("mypath","data/2.5/weather")
                .queryParam("lat","16.50745000")
                .queryParam("lon","80.64660000")


                .when().get("https://api.openweathermap.org/{mypath}")


                .then().statusCode(200)
                .body("name",equalTo("Mogalrājapuram"));
    }
}
