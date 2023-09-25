package getRequests;

import baseUrl.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get04b extends RestfulBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "John" and lastname is "Smith"
     */

    @Test
    public void get04(){
        // Set the URL
        spec.pathParam("first","booking")
                .queryParams("firstname","John","lastname","Smith");

        // Set The Expected Data ( put,post,patch)

        // Send The Request And Get The Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // Do Assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));

    }

}
