import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman, manuel API testleri icin kullandik
    2) Otomasyon testleri icin de Rest Assured Library kullanacagiz
    3) Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz;
        a) Gereksinimleri anlamak,
        b) Test Case yaziyoruz
            i) Test Case yaziminda "Gherkin" dilini kullanacagiz. Bizler yazilim diline hakim olsak da, karsimizdaki
            kisiler hakim olmayabilir ama Gherkin ile yazilan testleri anlamakta zorluk cekmeyeceklerdir.
            Gherkin dilinde kullanacagimiz keywordler;

            - Given : On kosullar,
            - When  : Yapilacak aksiyonlar icin (get(), put(), post(), patch() ve delete() )
            - Then  : Istek yaptiktan (request gonderdikten sonra) dogrulama
            - And   : Coklu isimlerde kullanacagiz

         c) Test Kodlarimizi Yazmaya Baslayacagiz

            i)   Set the URL,
            ii) Set the expected Data (beklenen datanin olusturulmasi, post, put, patch)
            iii) Type code to send request (Talep gondermek icin kod yazimi)
            iv) Do Assertion ()dogrulama yapmak


     */
    /*
    Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void tet01(){
        //  i)   Set the URL,
        String url="https://restful-booker.herokuapp.com/booking/3";

        //ii) Set the expected Data(Post-Put-Patch)

        //iii) Type code to send request
        Response response=given().when().get(url);
        response.prettyPrint();
        //iv) Do Assertion

    }
}
