package getRequests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUrl {

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
        spec.pathParams("first","todos","second",23);

        //ii) Set the expected Data


        //iii) Type code to send request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //iv) Do Assertion
        //1.yol
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false))
                .body("userId",equalTo(2));

        //2.Yol
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")
                        ,"completed",equalTo(false)
                        ,"userId",equalTo(2));






    }
}
