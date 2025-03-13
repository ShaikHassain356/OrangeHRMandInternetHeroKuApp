package RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FileDownload {

    @Test
    public void filedownload()
    {
        given()
                .when().get("http://localhost:8080/api/download?filename=SFTP Test.xlsx&directory=uploads")

                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
