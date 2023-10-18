package getRequests;

import baseUrl.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get09 extends RestfulBaseUrl {
    /*

         Given
             https://restful-booker.herokuapp.com/booking/111
         When
             I send GET Request to the url
         Then
             Response body should be like that;
     {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "midnight snack"
}
          */

    //i)Set the URL
    //ii) Set the expected Data
    //iii) Type code to send request
    //iv) Do Assertion

    @Test
    public void get09(){
        //i)Set the URL
        spec.pathParams("first","booking","second",91);

        //ii) Set the expected Data
        Map<String,String>bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        Map<String, Object>expectedData=new HashMap<>();
        expectedData.put("firstname","Josh");
        expectedData.put("lastname","Allen");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingDatesMap);
        expectedData.put("additionalneeds","midnight snack");
        System.out.println("expected Data : "+expectedData);

        //iii) Type code to send request
        Response response=given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //iv) Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println("actual data : "+actualData);

        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingDatesMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        assertEquals(bookingDatesMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        //Key-Value ikilileri String-Object seklinde oldugundan
        //Bookingdate value kismini CASTING ile MAP ile yaptik
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }
}
