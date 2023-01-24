package apiHardcodeExample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class apiExamples {

     //    initialise the Base URI
     String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
     String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQ1MjE3NjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDU2NDk2NCwidXNlcklkIjoiNDk4NyJ9.KV9ZCeahpWR_Un_b_NSiiAJlX32Dc1l4GIdA1qZw8cQ";

     @Test
     public void createEmployee() {
          //prepare the request
          RequestSpecification request = given().headers("Content-Type", "application/json").headers("Authorization", token)
                  .body("{\n" +
                          "  \"emp_firstname\": \"MR\",\n" +
                          "  \"emp_lastname\": \"Jaay\",\n" +
                          "  \"emp_middle_name\": \"BEEE\",\n" +
                          "  \"emp_gender\": \"M\",\n" +
                          "  \"emp_birthday\": \"2023-01-20\",\n" +
                          "  \"emp_status\": \"Unemploy\",\n" +
                          "  \"emp_job_title\": \"noEmployee\"\n" +
                          "}");
//         send the request and get response
          Response resp = request.when().post("/createEmployee.php");
//         print the response
          resp.prettyPrint();
//extract the first name from the response

          String empFname = resp.jsonPath().getString("Employee.emp_firstname");
          System.out.println(empFname);

//         assert that the first name is MR
          Assert.assertEquals(empFname, "MR");
     }

     //     write the request to get all the employeess and print the data on console
     @Test
     public void getAllEmployees() {
          RequestSpecification request = given().headers("Content-Type", "application/json").headers("Authorization", token);

          Response resp = request.when().get("/getAllEmployees.php");

          System.out.println(resp.asString());
     }

     @Test
     public void getJobTitle() {

          RequestSpecification request = given().headers("Content-Type", "application/json").headers("Authorization", token);

          Response resp = request.when().get("/jobTitle.php");

          String res = resp.jsonPath().getString("Jobs[0].id");

//          resp.prettyPrint();
//          print all the job titles only from the response
//          check the size of array
          String array = resp.jsonPath().getString("Jobs");
//         homework
//          find the size of the json array

          for (int i = 0; i < 50; i++) {
               String x = resp.jsonPath().getString("Jobs[" + i + "].job");
               System.out.println(x);

          }
     }
}



