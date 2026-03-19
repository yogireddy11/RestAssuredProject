package apiTest;

import base.BaseTest;
import endpoints.AuthAPI;
import endpoints.CartAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import validations.ResponseValidations;

public class DummyJsonAuth extends BaseTest {

    AuthAPI authAPI = new AuthAPI();
    String accessToken;
    String refreshToken;
    Response response;

    @Test(priority = 1)
    public void loginAuth() {
        String body = """
                {
                   "username": "emilys",
                   "password": "emilyspass"
                }
                """;
       response = authAPI.loginUserGetToken(body);
        response.then().log().all();
        accessToken = response.jsonPath().getString("accessToken");
        refreshToken = response.jsonPath().getString("refreshToken");
        System.out.println("AccessToken| " + accessToken);
        System.out.println("RefreshToken | " + refreshToken);
        ResponseValidations.validateStatusCode(response, 200);
        ResponseValidations.validateResponseTime(response, 4000);
    }

    @Test(priority = 2)
    public void getCurrentUser() {
        response = authAPI.getCurrentUser(accessToken);
        response.then().log().all();
        ResponseValidations.validateStatusCode(response, 200);
        ResponseValidations.validateResponseTime(response, 4000);
    }

    @Test(priority = 3)
    public void getRefreshToken(){
        String body = """
                {
                    "refreshToken" : "%s"
                }
                """.formatted(refreshToken);
        response = authAPI.refreshSession(body);
        response.then().log().all();
        ResponseValidations.validateStatusCode(response, 200);
        ResponseValidations.validateResponseTime(response, 4000);
    }
}
