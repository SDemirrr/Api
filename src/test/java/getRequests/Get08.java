package getRequests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {
    //De-Serialization: Json datayı Java objesine çevirme
    //Serialization: Java objesini Json formatına çevirme.
    //De-Serialization: Iki türlü yapacağız.
    //Gson: Google tarafından üretilmiştir.
    //Object Mapper: Daha popüler...

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }

    // Set the URL
    // Set The Expected Data ( put,post,patch)
    // Send The Request And Get The Response
    // Do Assertion
     */

    @Test
    public void get08(){
        // Set the URL
        spec.pathParams("first","todos","second",2);

        // Set The Expected Data ( put,post,patch)  ==>Payload
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println("expected Data : "+expectedData);

        // Send The Request And Get The Response
       Response response=given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

        // Do Assertion
       Map<String,Object> actualData=response.as(HashMap.class);//De-serialization
        System.out.println("actual Data : "+actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));
        assertEquals(200,response.statusCode());


    }

     //***Dinamik Yontem***
    @Test
    public void get08b(){
        // Set the URL
        spec.pathParams("first","todos","second",2);

        // Set The Expected Data ( put,post,patch)  ==>Payload
        JsonPlaceHolderTestData objJsonPlaceHolder=new JsonPlaceHolderTestData();
      Map<String,Object>expectedData=objJsonPlaceHolder
               .expectedDataMethod(1,"quis ut nam facilis et officia qui",false);
        System.out.println("expected Data : "+expectedData);

        // Send The Request And Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        Map<String,Object> actualData=response.as(HashMap.class);//De-serialization
        System.out.println("actual Data : "+actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));
        assertEquals(200,response.statusCode());


    }





}
