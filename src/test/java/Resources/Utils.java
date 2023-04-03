package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
    RequestSpecification req;

    public RequestSpecification requestSpecifications(){
        req = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();

        return req;
    }
}
