package getRequests;

public class Get06 {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/2325
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
        {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {   // outer json
        "checkin": "2022-10-27",  // inner json
        "checkout": "2022-11-07"
    },
    "additionalneeds": "None"
}
    */
    //i)Set the URL
    //ii) Set the expected Data
    //iii) Type code to send request
    //iv) Do Assertion
}
