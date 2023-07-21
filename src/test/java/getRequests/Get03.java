package getRequests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get03 {

       /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
       And
           "completed" is false
       And
       "userId" is 2
   */



    @Test
    public void get01(){
        //i)Set the URL
        String url="https://jsonplaceholder.typicode.com/todos/23";

        //ii) Set the expected Data
        Response response=given().when().get(url);
        response.prettyPrint();

        //iii) Type code to send request

        //iv) Do Assertion



    }
}
