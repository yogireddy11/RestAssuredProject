package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CartAPI {
    public static Response getAllCarts() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("/carts");
    }

    public static Response getCartById(int id) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("/carts/" + id);
    }

    public static Response getCartByUser(int userId) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("/carts/user/" + userId);
    }

    public static Response addCart(Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/carts/add");
    }

    public static Response updateCart(int id, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("/carts/" + id);
    }

    public static Response deleteCart(int id) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/carts/" + id);
    }
}
