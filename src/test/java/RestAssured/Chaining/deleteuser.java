package RestAssured.Chaining;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class deleteuser {

    @Test
    public void DeleteUser(ITestContext context)
    {
        String token="a779b853b6352dbd59dbc637379fc1560069d62826075236390e3b962b725e21";
        int id=(int) context.getAttribute("user_id"); //id we will be coming from createuser method
        //int id= (int) context.getSuite().getAttribute("user_id"); if we want to retrieve the value from suite level

        given()
                .headers("Authorization","Bearer "+token)
                .pathParam("id",id)

                .when().delete("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .log()
                .all();
    }
}
