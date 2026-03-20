package validations;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class ResponseValidations {
    public static void validateStatusCode(Response res, int code) {
        res.then().statusCode(code);
    }

    public static void validateResponseTime(Response res, long time) {
        res.then().time(lessThan(time));
    }

    public static void validateNotEmpty(Response res, String key) {
        res.then().body(key, not(empty()));
    }

    public static void responseCodeAnyOneOf(Response res, int code1,int code2){
        res.then().statusCode(anyOf(is(code1),is(code2)));

    }
}
