package getRequests;

import baseUrl.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get10 extends GoRestBaseUrl {

      /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
            {
        "meta": null,
        "data": {
                "message": "Resource not found"
              }
         }
     */

    @Test
    public void get10(){
        // Set the URL
        spec.pathParams("first","users","second",2986);

        // Set The Expected Data ( put,post,patch)
        GoRestTestData obj=new GoRestTestData();
       Map<String,String> dataKeyMap=obj.dataKeyMap("Resource not found");

        Map<String,Object>expectedData=obj.expectedData(null,dataKeyMap);
        System.out.println("Expected Data : "+expectedData);

        // Send The Request And Get The Response
        Response response=given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println("actual data : "+actualData);

        assertEquals(expectedData.get("meta"),actualData.get("meta"));
        assertEquals(dataKeyMap.get("message"),((Map)(actualData.get("data"))).get("message"));

    }
}
