package endpoints;

import io.restassured.response.Response;
import reports.CustomLoggingFilter;

import static io.restassured.RestAssured.*;

public class UserAPI {

    public Response createUser(String body){
        return given().header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .body(body)
                .when().post("/users/add");
    }
}
