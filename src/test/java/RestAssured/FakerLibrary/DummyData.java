package RestAssured.FakerLibrary;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class DummyData {
    @Test
    public void generatedummydata()
    {

        //https://github.com/DiUS/java-faker
        Faker faker=new Faker();
        String username= faker.name().username();
        String firstname= faker.name().firstName();
        String subscribenumber= faker.phoneNumber().subscriberNumber(10);
        String password= faker.internet().password(2,10);
        System.out.println(firstname);
    }
}
