package RestAssured;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SingleFileUpload {

    @Test
    public void singlefileupload()
    {
        File filepath =new File("C:\\Users\\Hassain\\Downloads\\ajay_mar11.xlsx");
        given()
                .multiPart("file",filepath)
                .contentType("multipart/form-data")

                .when().post("http://localhost:8080/api/upload-single")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
