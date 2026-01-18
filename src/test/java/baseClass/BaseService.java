package baseClass;

import filter.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {

    private static final String BASE_URI="http://64.227.160.186:8080/";
    private RequestSpecification requestSpecification;

    public BaseService(){
        requestSpecification=given().baseUri(BASE_URI);
    }

    static
    {
        RestAssured.filters(new LoggingFilter());
    }

    protected Response postRequest(String payload, String endpoint)
    {
        return requestSpecification.log().all().contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response postRequestUpgrade(Object payload, String endpoint)
    {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response putRequestUpgrade(Object payload, String endpoint)
    {
        return requestSpecification.log().all().contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    protected Response getRequest(String endPoint)
    {
        return requestSpecification.get(endPoint);
    }
    protected void setAuth(String token)
    {
        requestSpecification.header("Authorization", "Bearer "+token);
    }
}
