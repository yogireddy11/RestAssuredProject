package apiTest;

import base.BaseTest;
import endpoints.CartAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;
import validations.ResponseValidations;

public class DummyJsonCarts extends BaseTest {
    Response res;
    CartAPI cartAPI = new CartAPI();


    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void getAllCartsTest() {

        res = cartAPI.getAllCarts();
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "carts");
    }

    @Test(priority = 2)
    public void getCartByIdTest() {

        res = cartAPI.getCartById(1);
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 1500);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 3)
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
        res = cartAPI.addCart(body);
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 201);
        ResponseValidations.validateResponseTime(res, 2000);
    }

    @Test(priority = 4)
    public void updateCartTest() {

        String body = """
                {
                "merge": true,
                "products":[{"id":1,"quantity":2}]
                }
                """;

        res = cartAPI.updateCart(1, body);
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
    }

    @Test(priority = 5)
    public void deleteCartTest() {

        res = cartAPI.deleteCart(1);
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 1500);
    }

    @Test(priority = 6)
    public void getCartByUserTest() {

        res = cartAPI.getCartByUser(1);
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 1500);
    }
}
