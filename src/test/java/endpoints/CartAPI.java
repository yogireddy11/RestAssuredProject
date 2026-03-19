package endpoints;

import io.restassured.response.Response;
import reports.CustomLoggingFilter;

import static io.restassured.RestAssured.*;

public class CartAPI {
    public Response getAllCarts() {
        return given()
                .header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .when()
                .get("/carts");
    }

    public Response getCartById(int id) {
        return given()
                .header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .when()
                .get("/carts/" + id);
    }

    public Response getCartByUser(int userId) {
        return given()
                .header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .when()
                .get("/carts/user/" + userId);
    }

    public Response addCart(Object body) {
        return given()
                .header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .body(body)
                .when()
                .post("/carts/add");
    }

    public Response updateCart(int id, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .body(body)
                .when()
                .put("/carts/" + id);
    }

    public Response deleteCart(int id) {
        return given()
                .header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .when()
                .delete("/carts/" + id);
    }
}
