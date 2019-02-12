package RestAssuredTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteRequest {
    public static String baseURI = "https://maps.googleapis.com/";

    public static void main(String[] args){
        RestAssured.baseURI = baseURI;

        Response response = (Response) given()
                .queryParam("key","AIzaSyBAXL6Lnokz9C-3EoTX_6C6Qem7GzToRFY")
                .body("{"+
                        "\"location\": { "+
                        "\"lat\": -33.866971123445,"+
                        "\"lng\": 151.19587970"+
                        "},"+
                        "\"accuracy\": 50,"+
                        "\"name\": \"Google Shoes!\","+
                        "\"phone_number\": \"(02) 9374 4000\","+
                        "\"address\": \"20 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
                        "\"types\": [\"shoe_store\"],"+
                        "\"website\": \"http://www.google.com.au/\","+
                        "\"language\": \"en-AU\""+
                        "}")
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .assertThat().statusCode(404).log().all()
                //.body("name", equalTo("Google Shoes!"))
                //.body("website",equalTo("http://www.google.com.au/"));
                .extract().response();
        String res = response.asString();
        System.out.println(res);
        //Converting the string to Json
        //JsonPath jsonResponse = new JsonPath(res);
        //String testjson = jsonResponse.get("place_id");
        //System.out.println(testjson);
        System.out.println("Test Passed");


        //Deleting Post
        given()
                .queryParam("key","AIzaSyBAXL6Lnokz9C-3EoTX_6C6Qem7GzToRFY")
                //.body("{"+"\"place_id\": \""+testjson+"\""+"}")
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .assertThat().statusCode(200)
                .body("status",equalTo("OK"));
    }
}
