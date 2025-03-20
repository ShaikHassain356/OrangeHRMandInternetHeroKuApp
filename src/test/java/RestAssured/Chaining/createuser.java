package RestAssured.Chaining;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class createuser {

    @Test
    public void createuser(ITestContext context)
    {
        Faker faker=new Faker();

        JSONObject data=new JSONObject();
        data.put("name",faker.name().username());
        data.put("gender","male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","inactive");

        String token="a779b853b6352dbd59dbc637379fc1560069d62826075236390e3b962b725e21";

       //this id we will pass across different API requests using ITestContext interface
       int id= given().
                header("Authorization","Bearer "+token)
                .contentType("application/json")
                .body(data.toString())

                .when().post("https://gorest.co.in/public/v2/users")
               .jsonPath().getInt("id");

        System.out.println("id generated for the created user is "+id);
        context.setAttribute("user_id",id);
        //context.getSuite().setAttribute("user_id"); if we want to use this variable accross the suite level, then we declare like this, and this will be used in all test in suite


    }
}
