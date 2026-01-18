package apiTest;

import baseClass.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test
    public void forgotPassword()
    {
        AuthService authService= new AuthService();
        Response response = authService.forgot("lorkeshkoli20892@gmail.com");
        System.out.println(response.asPrettyString());
    }

    @Test
    public void forgotPasswordLinkAlreadySend()
    {
        AuthService authService= new AuthService();
        Response response = authService.forgot("lorkeshkoli20892@gmail.com");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),500);
    }
}
