package getRequests;

import baseUrl.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.AssertJUnit.assertEquals;

public class Get06b extends ReqresBaseUrl {

    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
            (butun pantone_values ların hepsini ekrana yazdır )
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
              (3'den buyuk olan tum id leri yazdır,3'den buyuk olan id lerin 3 tane oldugunu assert et )
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
              (id si, 3 den kucuk olan tum id leri yazdır, 3 den kucuk olanların 2 tanesi oldugunu assert et)
    */

    @Test
    public void get6(){
        // Set the URL
        spec.pathParam("first","unknown");

        // Set The Expected Data ( put,post,patch)

        // Send The Request And Get The Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.then().body("data",hasSize(6));

        // Do Assertion
        // 1)Status code is 200
        assertEquals(200,response.statusCode());

        JsonPath jsonPath=response.jsonPath();
        //2)Print all pantone_values
        System.out.println(jsonPath.getList("data.pantone_value"));

        //3)Print all ids greater than 3 on the console
        //(3'den buyuk olan tum id leri yazdır,3'den buyuk olan id lerin 3 tane oldugunu assert et )
        System.out.println("tum id'ler : "+jsonPath.getList("data.id"));
        List<Integer> idList=jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("3'ten buyuk idList : "+idList );

        //Assert that there are 3 ids greater than 3
        assertEquals(3, idList.size());

        //4)Print all names whose ids are less than 3 on the console
        //(id si, 3 den kucuk olan tum id leri yazdır, 3 den kucuk olanların 2 tanesi oldugunu assert et)
        List<String> nameList=jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("3'ten kucuk nameList : "+nameList );

        //Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2, nameList.size());


        }



    }

