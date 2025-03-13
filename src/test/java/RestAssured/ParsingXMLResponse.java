package RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingXMLResponse {


    //approach 1
    @Test
    public void parsingXML()
    {

        given()

                .when().get("http://192.168.0.5:8080/agents.xml")

                .then()
                .statusCode(200)
                .header("content-type","application/xml")
                .body("root.store.book[1].author",equalTo("Harper Lee"))
                .log()
                .all();
    }

    @Test
    public void resparsing()
    {


       Response res= given()

                .when().get("http://192.168.0.5:8080/agents.xml");


        Assert.assertEquals(res.header("content-type"),"application/xml");
        Assert.assertEquals(res.statusCode(),200);
        String authorname = res.xmlPath().getString("root.store.book[0].author.text()");
        System.out.println("name of the author is "+authorname);
        Assert.assertEquals(authorname,"George Orwell");


        //verifying whether specific author name is present or not in response
        for (int i=0;i<res.xmlPath().getList("root.store.book").size();i++)
        {
            String actualauthor= res.xmlPath().getString("root.store.book["+i+"].author.text()");
            if (actualauthor.equals("F. Scott Fitzgerald"))
            {
                System.out.println("Author name found"+ "at the position"+"book["+i+"]");
            }
        }

        //verifying whether specific author name is present or not in response using for each loop
        XmlPath obj=new XmlPath(res.asString());
        List<String> author_names=  obj.getList("root.store.book.author");
        int index=0;
        for (String author_name :author_names)
        {
            if (author_name.equals("F. Scott Fitzgerald"))
            {
                System.out.println("Author found at position: book[" + index + "]");
            }
            index++;
        }


    }

}
