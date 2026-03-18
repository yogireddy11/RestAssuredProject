package apiTest;

import base.BaseTest;
import endpoints.CartAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import validations.ResponseValidations;

public class DummyJson extends BaseTest {

    @Test
    public void getAllCartsTest() {

        Response res = CartAPI.getAllCarts();

        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 1500);
        ResponseValidations.validateNotEmpty(res, "carts");

        res.then().log().all();
    }

    @Test
    public void getCartByIdTest() {

        Response res = CartAPI.getCartById(1);

        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 1500);

        res.then().log().all();
    }

    @Test
    public void addCartTest() {
        String body = """ 
                { 
                    "userId": 9, 
                    "products": [
                     {  "id": 99, "quantity": 4 },
                      { "id": 98, "quantity": 2 }, 
                      {"id": 100, "quantity": 5 } 
                      ]
                } 
                """;
        Response res = CartAPI.addCart(body);

        ResponseValidations.validateStatusCode(res, 201);
        ResponseValidations.validateResponseTime(res, 2000);

        res.then().log().all();
    }

    @Test
    public void updateCartTest() {

        String body = """
                {
                "merge": true,
                "products":[{"id":1,"quantity":2}]
                }
                """;

        Response res = CartAPI.updateCart(1, body);

        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);

        res.then().log().all();
    }

    @Test
    public void deleteCartTest() {

        Response res = CartAPI.deleteCart(1);

        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 1500);

        res.then().log().all();
    }
}
