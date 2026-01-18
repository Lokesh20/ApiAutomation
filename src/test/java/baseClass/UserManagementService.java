package baseClass;

import io.restassured.response.Response;

public class UserManagementService extends  BaseService {

    private static final String BASE_PATH="api/users/";

    public Response getProfileDetail(String token)
    {
        setAuth(token);
        return getRequest(BASE_PATH+"profile");
    }

    public Response putProfileDetail2(String token,Object payload)
    {
        setAuth(token);
        return putRequestUpgrade(payload,BASE_PATH+"profile");
    }
}
