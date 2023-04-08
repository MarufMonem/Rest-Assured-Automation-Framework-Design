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
    static RequestSpecification req;
    ResponseSpecification resSpec;
    RequestSpecification res;
    AddPlace ap;
    Response response;
    String responseBody;
    JsonPath js;
    static String placeID;
    static TestDataBuild td;


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
        } else if (method.equalsIgnoreCase("get")) {
            response = res.when()
                    .get(apiValue);
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
        Assert.assertEquals(getJsonPath(response, attributeName),expectedValue);
    }

    @Given("Add place payload with {string} {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) throws IOException {
        td = new TestDataBuild();
        ap=td.addPlacePayLoad(name, language, address);
        // Request specification
        req = requestSpecifications();
        res = given().spec(req).body(ap);
    }


    @And("Verify place_ID created  maps to {string} using {string}")
    public void verifyPlace_IDCreatedMapsToUsing(String placeName, String apiName) {
        placeID = getJsonPath(response, "place_id");
        res = given().spec(req).queryParam("place_id", placeID);

        userCallsWithPostHttpRequest(apiName, "GET");

        Assert.assertEquals(getJsonPath(response, "name"), placeName);

    }

    @Given("DeletePlace payload")
    public void deleteplacePayload() throws IOException {
//        req = requestSpecifications();
        res = given().log().all().spec(req).body(td.deletePayload(placeID));
//        userCallsWithPostHttpRequest("DeletePlaceAPI", "POST");
    }
}
