package stepDefinitions;

import POJO.AddPlace;
import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefs extends Utils{
    RequestSpecification req;
    ResponseSpecification resSpec;
    RequestSpecification res;
    AddPlace ap;
    Response response;
    String responseBody;
    JsonPath js;
    @Given("Add place payload")
//    public void addPlacePayload() throws IOException {
//        //payload
//        TestDataBuild td = new TestDataBuild();
//        ap=td.addPlacePayLoad();
//        // Request specification
//        req = requestSpecifications();
//
////        resSpec = new ResponseSpecBuilder()
////                .expectStatusCode(200)
////                .expectContentType(ContentType.JSON).build();
//
//        res = given().spec(req).body(ap);
//
//    }


    @When("User calls {string} with {string} http request")
    public void userCallsWithPostHttpRequest(String arg0, String method) {
        APIResources resourceObject = APIResources.valueOf(arg0);
        String apiValue = resourceObject.getResource();

        if (method.equalsIgnoreCase("post")){
            response = res.when()
                    .post(apiValue);
        } else if (method.equalsIgnoreCase("delete")) {
            response = res.when()
                    .delete(apiValue);
        }
    }

    @Then("The API call will get success with" +
            "" +
            "" +
            " status code {int}")
    public void theAPICallWillGetSuccessWithStatusCode(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(),expectedStatusCode);
    }

    @And("The {string} in response body is {string}")
    public void theInResponseBodyIs(String attributeName, String expectedValue) {
        responseBody = response.asString();
        System.out.println(responseBody);
        js = new JsonPath(responseBody);
        String attributeValue = js.get(attributeName);
        Assert.assertEquals(attributeValue,expectedValue);
    }

    @Given("Add place payload with {string} {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) throws IOException {
        TestDataBuild td = new TestDataBuild();
        ap=td.addPlacePayLoad(name, language, address);
        // Request specification
        req = requestSpecifications();
        res = given().spec(req).body(ap);
    }
}
