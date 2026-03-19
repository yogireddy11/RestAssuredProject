package endpoints;

import io.restassured.response.Response;
import reports.CustomLoggingFilter;

import static io.restassured.RestAssured.given;

public class AuthAPI {

    public Response loginUserGetToken(String body) {
        return given().header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .body(body)
                .when()
                .post("/auth/login");

    }

    public Response getCurrentUser(String token) {

        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())
                .auth().oauth2(token)
                .when().get("/auth/me");
    }

    public Response refreshSession(String body) {
        return given().header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .body(body)
                .when()
                .post("/auth/refresh");
    }
}
