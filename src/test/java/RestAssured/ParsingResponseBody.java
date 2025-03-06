package RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingResponseBody {

    //approach 1

    //@Test
    public void parsingresponse()
    {
        given().contentType(ContentType.JSON)

                .when().get("http://localhost:3000/store")

                .then()
                .statusCode(200)
                .header("Content-Type","application/json")
                .body("book[2].title",equalTo("The Great Gatsby"));
    }

    @Test
    public void parsingresponseusingassertions()
    {
        Response res= given().contentType(ContentType.JSON)

                .when().get("http://localhost:3000/store");

        Assert.assertEquals(res.header("Content-Type"),"application/json");
        Assert.assertEquals(res.statusCode(),200);

        String author= res.jsonPath().get("book[1].author").toString();
        Assert.assertEquals(author,"Harper Lee");

        String price= res.jsonPath().get("book[1].price").toString();
        float priceint= Float.parseFloat(price);;

        Assert.assertEquals(priceint,65.75);

        JSONObject jo=new JSONObject(res.asString());//converting response to JSON object

        for (int i=0;i<jo.getJSONArray("book").length();i++)
        {
            String title= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
            System.out.println(title);
            if (title.equals("The Great Gatsby"))
            {
                int index= jo.getJSONArray("book").length();
                System.out.println(index);
            }
        }

        //to find price of all books

        double actualbookprice = 0;
        for (int i = 0; i < jo.getJSONArray("book").length(); i++)
        {
            String bookprice = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
            actualbookprice=actualbookprice+ Double.parseDouble(bookprice);
        }
        System.out.println("Total price of all books is: " + actualbookprice);

        Assert.assertEquals(actualbookprice,196.74);




    }
}
