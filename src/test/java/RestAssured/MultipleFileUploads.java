package RestAssured;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class MultipleFileUploads {

    @Test
    public void mutiplefilesupload()
    {
        File file1=new File("C:\\Users\\Hassain\\Downloads\\SFTP Test.xlsx");
        File file2=new File("C:\\Users\\Hassain\\Downloads\\SFTP Test 123.xlsx");
        given()
                .multiPart("files",file1)
                .multiPart("files",file2)
                .contentType("multipart/form-data")

                .when().post("http://localhost:8080/api/upload-multiple")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
