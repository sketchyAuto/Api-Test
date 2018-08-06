import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequestTest {
    //BaseUrl
    public static String baseURI = "https://maps.googleapis.com";


    @Test
     public void testApi() throws Exception

    {

        RestAssured.baseURI = baseURI;

        given().
                param("location","-33.8670522,151.1957362").
                param("radius","500").
                param("type","restaurant").
                //param("keyword","cruise").
                param("key","AIzaSyBAXL6Lnokz9C-3EoTX_6C6Qem7GzToRFY").
                when().log().all().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200);
                System.out.println("Request is executed successfully");

    }

}
