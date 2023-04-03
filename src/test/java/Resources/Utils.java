package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {
    RequestSpecification req;

    public RequestSpecification requestSpecifications() throws FileNotFoundException {
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        req = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();

        return req;
    }
}
