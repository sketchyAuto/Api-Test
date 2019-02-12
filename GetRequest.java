package RestAssuredTest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

class GetRequest {
        //BaseUrl
        public static String baseURI = "https://maps.googleapis.com/";

        public static void main(String args[])
        {

            RestAssured.baseURI = baseURI;

            given()
                    .param("location","-33.8670522,151.1957362")
                    .param("radius","500")
                    .param("type","restaurant")
                    //.param("keyword","cruise")
                    .param("key","AIzaSyBAXL6Lnokz9C-3EoTX_6C6Qem7GzToRFY")
                    .when().log().all()
                    .get("/maps/api/place/nearbysearch/json")
                    .then().assertThat().statusCode(200).and()
                    .contentType(ContentType.JSON).log().all();
            System.out.println("Request is executed successfully");

        }

    }