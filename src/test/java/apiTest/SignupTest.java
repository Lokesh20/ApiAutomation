package apiTest;


import baseClass.AuthService;
import io.restassured.response.Response;
import model_Pojo.request.SignupRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestListener.class)

public class SignupTest {
    private static final Logger logger= LogManager.getLogger(SignupTest.class);

    @Test(testName = "ABC")
    public void signupTest()
    {
        logger.info("TestCase");
       SignupRequest signupRequest=new SignupRequest.Builder().email("lorkeshkoli20892@gmail.com")
                .firstName("Lokesh")
                .lastName("Koli")
                .mobileNumber("9769226508")
                .password("Lokesh@20")
                .username("Lokesh@201")
                .build();
        AuthService authService= new AuthService();
        Response reponse= authService.signUp(signupRequest);
        System.out.println(reponse.asString());
        System.out.println(reponse.statusCode());

    }
}
