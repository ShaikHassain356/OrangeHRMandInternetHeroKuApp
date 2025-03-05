package RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetCookieValuesFromResponse {

    @Test
    public void fetchcookievalue()
    {

        Response res= given()

                .when().get("https://www.google.co.in/");

        //fetch cookie value

        String cookie= res.getCookie("AEC");
        System.out.println("actual cookie value of AEC is "+cookie);
        // Fetch all cookies
        Map<String, String> cookies = res.getCookies();
        for ( String key : cookies.keySet())
        {
            String keyvalue= res.getCookie(key);
            System.out.println(key +" and the values is " +keyvalue);


        }
    }
}
