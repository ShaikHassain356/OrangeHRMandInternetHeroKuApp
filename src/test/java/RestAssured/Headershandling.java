package RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Headershandling {

    @Test
    public void fetchingheader()
    {
        Response res= given()

                .when().get("https://www.google.co.in/");

        //fetching one header

        String headervalue= res.getHeader("Content-Type");
        System.out.println("Value of the header Content-Type is: "+headervalue);

        // Fetch all headers
       Headers headervalues =res.getHeaders();

        // Print all headers
        for (Header header : headervalues.asList()) {
            System.out.println("Header Name: " + header.getName() + " | Value: " + header.getValue());
        }




    }
}
