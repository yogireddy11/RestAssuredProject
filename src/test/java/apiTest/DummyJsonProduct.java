package apiTest;

import base.BaseTest;
import endpoints.ProductAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import validations.ResponseValidations;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class DummyJsonProduct extends BaseTest {

    ProductAPI productAPI = new ProductAPI();
    Response res;

    @Test(priority = 1)
    public void getAllProducts() {
        res = productAPI.getAllProducts();
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "products");
    }

    @Test(priority = 2)
    public void getSingleProducts() {
        res = productAPI.getSingleProduct(2);
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "products");
    }

    @Test(priority = 3)
    public void getSearchProducts() {
        res = productAPI.searchProduct();
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "products");
    }

    @Test(priority = 4)
    public void skipProducts() {
        res = productAPI.limitSkipProducts();
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "products");
    }

    @Test(priority = 5)
    public void getSortProduct() {
        res = productAPI.sortProducts();
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "products");
    }

    @Test(priority = 6)
    public void getProductCategories() {
        res = productAPI.productCategories();
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "products");
    }

    @Test(priority = 7)
    public void getProductCategoriesList() {
        res = productAPI.productCategoriesList();
        res.then().log().all();
        ResponseValidations.validateStatusCode(res, 200);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "products");
    }

    @Test(priority = 8)
    public void getProductCategoriesSmartphone() {
        res = productAPI.productCategoriesSmartphone();
        res.then().log().all();
        ResponseValidations.responseCodeAnyOneOf(res, 200,201);
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateNotEmpty(res, "products");
    }

    @Test(priority = 9)
    public void getCreateProduct() {
        String body = """
                {
                  "title" : "Asus vivo book",
                  "description" : "Asus is a gaming laptop. Can play well of games!",
                  "category" : "Electronics",
                  "price" : "56,550",
                  "rating" : "3.55",
                  "stock" : "12"
                }
                """;
        res = productAPI.createProduct(body);
        res.then().log().all();
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.responseCodeAnyOneOf(res, 200, 201);
    }

    @Test(priority = 10)
    public void getUpdateProduct() {
        String body = """
                {
                "title" : "Asus vivo book",
                  "description" : "Asus is a gaming laptop. Can play well of games!",
                  "category" : "Electronics",
                  "price" : "56,550",
                  "rating" : "3.55",
                  "stock" : "12"
                }
                """;
        res = productAPI.updateProduct(body);
        res.then().log().all();
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateStatusCode(res,200);

    }

    @Test(priority = 11)
    public void getDeleteProduct(){
        res = productAPI.deleteProduct();
        res.then().log().all();
        ResponseValidations.validateResponseTime(res, 2000);
        ResponseValidations.validateStatusCode(res,200);
    }

}
