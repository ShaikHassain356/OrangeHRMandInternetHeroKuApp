package RestAssured.Chaining;
import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class updateuser {

    @Test
    public void UpdateUser(ITestContext context)
    {

        Faker faker=new Faker();

        JSONObject data=new JSONObject();
        data.put("name",faker.name().username());
        data.put("gender","female");
        data.put("email",faker.internet().emailAddress());
        data.put("status","active");

        String token="a779b853b6352dbd59dbc637379fc1560069d62826075236390e3b962b725e21";
        int id= (int) context.getAttribute("user_id"); //id we will be coming from createuser method
        //int id= (int) context.getSuite().getAttribute("user_id"); if we want to retrieve the value from suite level
        given()
                .headers("Authorization","Bearer "+token)
                .contentType("application/json")
                .body(data.toString())
                .pathParam("id",id)
                .when().put("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(200)
                .log()
                .all();

    }
}
