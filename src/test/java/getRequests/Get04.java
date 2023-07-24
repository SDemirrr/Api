package getRequests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get04 extends JsonPlaceHolderBaseUrl {
        /*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
        I send a GET request to the Url
    And
        Accept type is "application/json"
    Then
        HTTP Status Code should be 200
    And
        Response format should be "application/json"
    And
        There should be 200 todos
    And
        "quis eius est sint explicabo" should be one of the todos title
    And
        2, 7, and 9 should be among the userIds
 */



    @Test
    public void get04(){
        //i)Set the URL
        spec.pathParams("first","todos");
        //ii) Set the expected Data
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //iii) Type code to send request

        //iv) Do Assertion
        response.then().assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("title",equalTo("quis eius est sint explicabo"));

    }
}
