package provider.endPoint;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseURI {
    public static RequestSpecification baseURL() {
        RequestSpecification baseURL = new RequestSpecBuilder().setBaseUri("https://www.eurowings.com").setContentType(ContentType.JSON).build();
        return baseURL;
    }
}
