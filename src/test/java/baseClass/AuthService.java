package baseClass;

import io.restassured.response.Response;
import model_Pojo.request.LoginRequest;
import model_Pojo.request.SignupRequest;

import java.util.HashMap;
import java.util.Map;

public class AuthService extends BaseService{

    private static final String BASE_PATH="api/auth/";

    public Response login(String payload)
    {
        String endPoint=BASE_PATH+"login";
        return postRequest(payload,endPoint);

    }

    public Response loginUpgrade(LoginRequest payload)
    {
        String endPoint=BASE_PATH+"login";
        return postRequestUpgrade(payload,endPoint);

    }

    public Response signUp(SignupRequest payload)
    {
        String endPoint=BASE_PATH+"signup";
        return postRequestUpgrade(payload,endPoint);

    }

    public Response forgot(String payload)
    {
        Map<String,String> value= new HashMap<>();
        value.put("email",payload);
        String endPoint=BASE_PATH+"forgot-password";
        return postRequestUpgrade(value,endPoint);

    }


}
