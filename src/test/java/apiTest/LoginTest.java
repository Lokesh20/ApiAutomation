package apiTest;

import baseClass.AuthService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model_Pojo.request.LoginRequest;
import model_Pojo.response.LoginResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {
    private static final Logger logger= LogManager.getLogger(LoginTest.class);
    @Test
    public void loginTest()
    {
        RestAssured.baseURI="http://64.227.160.186:8080/";

        given().log().all().header("Content-Type","application/json").
                body("{\n" +
                        "  \"username\": \"Lokesh@20\",\n" +
                        "  \"password\": \"Lokesh@20\"\n" +
                        "}").
                post("api/auth/login").
                then().log().all().assertThat().statusCode(200).extract().response();
    }


    @Test
    public void loginTestUpgraded()
    {
        LoginRequest loginRequest=new LoginRequest("Lokesh@20", "Lokesh@20");
        AuthService authService= new AuthService();
        Response reponse = authService.loginUpgrade(loginRequest);
        LoginResponse response=reponse.as(LoginResponse.class);
        Assert.assertEquals(response.getId(),3634);
        Assert.assertEquals(response.getUsername(),"Lokesh@20");
        Assert.assertNotNull(response.getToken());
        System.out.println(response.getToken());

    }


}
