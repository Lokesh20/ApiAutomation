package apiTest;

import baseClass.AuthService;
import baseClass.UserManagementService;
import io.restassured.response.Response;
import model_Pojo.request.LoginRequest;
import model_Pojo.request.ProfileUpdateRequest;
import model_Pojo.response.LoginResponse;
import org.testng.annotations.Test;

public class ProfileDetail {

    @Test
    public void getProfile()
    {
        LoginRequest loginRequest=new LoginRequest("Lokesh@20", "Lokesh@20");
        AuthService authService= new AuthService();
        Response reponse = authService.loginUpgrade(loginRequest);
        LoginResponse response=reponse.as(LoginResponse.class);

        UserManagementService userManagementService = new UserManagementService();
        reponse=userManagementService.getProfileDetail(response.getToken());
        System.out.println(reponse.asPrettyString());
    }

    @Test
    public void updateProfile()
    {
        ProfileUpdateRequest profileUpdateRequest =new ProfileUpdateRequest.Builder().firstName("Lokesh")
               .lastName("User").
               email("lokeshk20892@gmail.com").
               mobileNumber("9769226509").build();
        LoginRequest loginRequest=new LoginRequest("Lokesh@20", "Lokesh@20");
        AuthService authService= new AuthService();
        Response reponse = authService.loginUpgrade(loginRequest);
        LoginResponse response=reponse.as(LoginResponse.class);

        UserManagementService userManagementService = new UserManagementService();
        reponse=userManagementService.putProfileDetail2(response.getToken(),profileUpdateRequest);
        System.out.println(reponse.asPrettyString());
    }
}
