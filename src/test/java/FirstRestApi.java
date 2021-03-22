
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class FirstRestApi {

    public static void main(String[] args){
       // getResPonseBody();
        getResponseStatus();
    }

    public  static void getResPonseBody(){
        String url = "http://demo.guru99.com/V4/sinkministatement.php";
        //With out Query parameters
    given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
    .then().log().all();
        // With query parameters
    given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
        }
    public static void getResponseStatus(){
        String url = "http://demo.guru99.com/V4/sinkministatement.php";
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get(url).getStatusCode();

        System.out.println("The response status is "+statusCode);
       given().when().get(url).then().assertThat().statusCode(200);
        int code= 200;
    //Using testNG assertion to validate the response.
        Assert.assertEquals(statusCode,code);


    }
    }


