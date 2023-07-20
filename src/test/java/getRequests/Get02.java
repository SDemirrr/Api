package getRequests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get02 {

      /*
    Given
    https://restful-booker.herokuapp.com/booking/1001
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
  */



    @Test
    public void get01(){

        //i)Set the URL
        String url="https://restful-booker.herokuapp.com/booking/10006";

        //ii) Set the expected Data(Post put patch)

        //iii) Type code to send request
        Response response=given().when().get(url);
        response.prettyPrint();

        //iv) Do Assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Response body'de bulunan spesifik bir veri nasil assert edilir


          
    }
}
