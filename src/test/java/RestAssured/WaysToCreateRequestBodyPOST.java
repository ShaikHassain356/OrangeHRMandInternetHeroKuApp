package RestAssured;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class WaysToCreateRequestBodyPOST {

    /*

    1.HashMpa
    2.Using org.json
    3.using POJO library
    4.external json file
    */
    String id;

    //@Test(priority = 1)
    public void usinghashmap()
    {
        HashMap hm=new HashMap();
        hm.put("name","Shaik");
        hm.put("location","hyd");
        hm.put("phone","987654321");

        String course[] ={"c","c++"};

        hm.put("courses",course);

        id= given().contentType("application/json").body(hm)

                .when().post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Hassain"))
                .body("phone",equalTo("123456789"))
                .body("courses[0]",equalTo("c"))
                .log()
                .all().extract().jsonPath().getString("id");



    }

    //@Test(priority = 1)
    public void usingorgjson()
    {
        JSONObject data=new JSONObject();
        data.put("name","shaik");
        data.put("location","hyd");
        data.put("phone","987654321");


        String course[] ={"c","c++"};

        data.put("courses",course);



        id= given().contentType("application/json").body(data.toString())

                .when().post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("shaik"))
                .body("phone",equalTo("987654321"))
                .body("courses[0]",equalTo("c"))
                .log()
                .all().extract().jsonPath().getString("id");



    }

    //@Test(priority = 1)
    public void usingpojoclass()
    {
        POJO_class pc=new POJO_class();

        pc.setName("Hassain");
        pc.setLocation("Delhi");
        pc.setPhone("987654321");

        String coursesarr[]={"java","python"};
        pc.setCourses(coursesarr);



        id= given().contentType("application/json").body(pc)

                .when().post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Hassain"))
                .body("phone",equalTo("987654321"))
                .body("courses[0]",equalTo("java"))
                .log()
                .all().extract().jsonPath().getString("id");



    }

    @Test(priority = 1)
    public void usingexternaljsonfile() throws FileNotFoundException {
        File f=new File("C:\\Users\\Hassain\\IdeaProjects\\OrangeHRM\\body.json");

        FileReader fr=new FileReader(f);

        JSONTokener jt=new JSONTokener(fr);

        JSONObject data=new JSONObject(jt);




        id= given().contentType("application/json").body(data.toString())

                .when().post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("Hassain"))
                .body("phone",equalTo("1234567890"))
                .body("courses[0]",equalTo("Java"))
                .log()
                .all().extract().jsonPath().getString("id");



    }

    @Test(priority = 2,dependsOnMethods = "usingexternaljsonfile")
    public void deletehashmapuser()
    {
        given()

                .when().delete("http://localhost:3000/students/"+id)


                .then().statusCode(200)
                .log()
                .all();
    }
}
