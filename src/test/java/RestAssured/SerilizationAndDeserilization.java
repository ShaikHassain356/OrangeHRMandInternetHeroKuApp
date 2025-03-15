package RestAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerilizationAndDeserilization {


    //pojo ----serilize--json --- deserilize ---pojo

    @Test(priority = 1) // pojo to json
    public void serilize() throws JsonProcessingException {
        POJO_class pojoobj=new POJO_class();
        pojoobj.setName("Hassain");
        pojoobj.setLocation("Delhi");
        pojoobj.setPhone("987654321");

        String coursesarr[]={"java","python"};
        pojoobj.setCourses(coursesarr);

        ObjectMapper objmapper=new ObjectMapper();

        String jsondata= objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojoobj);
        System.out.println(jsondata);



    }

    @Test(priority = 2)    //json to pojo
    public void deserilize() throws JsonProcessingException {
        String jsondata="{\n" +
                "  \"name\" : \"Hassain\",\n" +
                "  \"location\" : \"Delhi\",\n" +
                "  \"phone\" : \"987654321\",\n" +
                "  \"courses\" : [ \"java\", \"python\" ]\n" +
                "}";

        ObjectMapper objmapper=new ObjectMapper();

        POJO_class pojoobj= objmapper.readValue(jsondata,POJO_class.class);
        System.out.println("name of the student is "+pojoobj.getName());
        System.out.println("location of the student is "+pojoobj.getLocation());
        System.out.println("phone of the student is "+pojoobj.getPhone());
        System.out.println("1st course of the student is "+pojoobj.getCourses()[0]);
        System.out.println("2nd course of the student is "+pojoobj.getCourses()[1]);
    }
}
