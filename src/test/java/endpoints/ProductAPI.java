package endpoints;

import io.restassured.response.Response;
import reports.CustomLoggingFilter;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ProductAPI {

    public Response getAllProducts(){
        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())
                .when()
                .get("/products");
    }

    public Response getSingleProduct(int id){
        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())
                .when()
                .get("/products/"+id);
    }

    public Response searchProduct(){
        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())
                .queryParam("q","phone")
                .when()
                .get("products/search");
    }

    public Response limitSkipProducts(){
        Map<String,Object> params = new HashMap<>();
        params.put("limit",10);
        params.put("skip",10);
        params.put("select","title,price");
        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())

                .queryParams(params)
                .when()
                .get("/products");
    }

    public Response sortProducts(){
        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())
                .queryParam("sortBy", "title")
                .queryParam("order","asc")
                .when().get("/products");
    }
    public Response productCategories(){
        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())
                .when().get("/products/categories");
    }

    public Response productCategoriesList(){
        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())
                .when().get("/products/category-list");
    }

    public Response productCategoriesSmartphone(){
        return given().header("Content-Type","application/json")
                .filter(new CustomLoggingFilter())
                .when().get("/products/category/smartphones");
    }

    public Response createProduct(String body){
        return given().header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .body(body)
                .when().post("/products/add");
    }
    public Response updateProduct(String body){
        return given().header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .body(body)
                .when().put("/products/1");
    }
    public Response deleteProduct(int id){
        return given().header("Content-Type", "application/json")
                .filter(new CustomLoggingFilter())
                .when().delete("/products/"+id);
    }








}
