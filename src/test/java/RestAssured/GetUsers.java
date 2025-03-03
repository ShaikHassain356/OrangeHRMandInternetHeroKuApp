package RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUsers {

    String id;
    @Test(priority = 2)
    public void getusers()
    {
     given()

             .when().get("https://reqres.in/api/users?page=2")


             .then()
             .statusCode(200)
             .body("page",equalTo(2))
             .log().all();
    }

    //creating a user
    @Test(priority = 1)
    public void createuser()
    {
        HashMap data=new HashMap();
        data.put("name","Hassain");
        data.put("job","Automation QA");

        id= given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")


                .then()
                .statusCode(201)
                .log().all()
                .extract().jsonPath().getString("id");

        System.out.println("actual id created is :"+id);

    }

    @Test(priority = 3, dependsOnMethods = "createuser")
    public void updateuser()
    {

        HashMap data=new HashMap();
        data.put("name","Hassain2");
        data.put("job","Automation");

        given().contentType("application/json").body(data)

                .when().put("https://reqres.in/api/users/"+id)


                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4,dependsOnMethods = "createuser")
    public void deleteuser()
    {
        given()

                .when().delete("https://reqres.in/api/users/"+id)


                .then()
                .statusCode(204)
                .log()
                .all();
    }
}
