package reports;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class CustomLoggingFilter implements Filter {


    @Override
    public Response filter(FilterableRequestSpecification req,
                           FilterableResponseSpecification res,
                           FilterContext filterContext) {

        System.out.println("Request URI: " + req.getURI());
        System.out.println("Request Body: " + req.getBody());

        Response response = filterContext.next(req, res);

        System.out.println("Response Status: " + response.getStatusCode());
        return response;
    }
}
