package apiHardcodeExample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
public class Example2 {
//     baseURI
    String baseURI=RestAssured.baseURI="https://reqres.in/api";

    @Test
    public  void updateInfo(){
//        prepare the request

        RequestSpecification request = given().headers("Content-Type", "application/json").body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}");

//        send
        Response resp = request.when().patch("/api/users/2");

        resp.prettyPrint();

//        extract data
        String name = resp.jsonPath().getString("name");

        Assert.assertEquals(name,"morpheus");
    }
}
