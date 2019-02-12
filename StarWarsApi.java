package RestAssuredTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;

public class StarWarsApi {

    public static String baseURI = "https://swapi.co/api/";

    public static void main(String args[])
    {

        RestAssured.baseURI = baseURI;
        given()
                //.param("films")
                .when().log().all()
                .get("films")
                .then().assertThat().statusCode(200).and()
                .contentType(ContentType.JSON).log().all();
        System.out.println("Request is executed successfully");
        System.out.println("\nStarting test 2 \n");

        given()
                .when()
                .get("films/1/")
                .then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("title", equalTo("A New Hope"))
                .body("producer", equalTo("Gary Kurtz, Rick McCallum"))
                .header("Server", equalTo("cloudflare"))
                .log().all();
        System.out.println("Test completed");
    }

}

