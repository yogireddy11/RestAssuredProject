package apiTest;

import base.BaseTest;
import endpoints.UserAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import validations.ResponseValidations;

public class DummyJsonUser extends BaseTest {
    UserAPI userAPI = new UserAPI();
    Response res;

    @Test
    public void getCreateUser() {
        String body = """
                {
                    "firstName": "Ojas",
                        "lastName": "Ghambeera",
                        "age": "30"
                }
                """;
        res = userAPI.createUser(body);
        res.then().log().all();
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.responseCodeAnyOneOf(res, 200, 201);
    }
}
