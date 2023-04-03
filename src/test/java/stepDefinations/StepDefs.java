package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
    @Given("Add place payload")
    public void addPlacePayload() {
    }

    @When("User calls {string} with Post http request")
    public void userCallsWithPostHttpRequest(String arg0) {
    }

    @Then("The API call will get scuccess with status code")
    public void theAPICallWillGetScuccessWithStatusCode() {
    }

    @And("The {string} in response body is {string}")
    public void theInResponseBodyIs(String arg0, String arg1) {
    }

    @io.cucumber.java.en.And("{string} in response body is {string}")
    public void inResponseBodyIs(String arg0, String arg1) {
    }
}
