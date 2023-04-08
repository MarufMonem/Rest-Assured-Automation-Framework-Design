package stepDefinitions;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
//        Execute this if place id is null
        StepDefs sd = new StepDefs();
        if (StepDefs.placeID == null){
            sd.addPlacePayloadWith("Anik", "Bangla", "Dhaka");
            sd.userCallsWithPostHttpRequest("AddPlaceAPI", "Post");
            sd.verifyPlace_IDCreatedMapsToUsing("Anik", "getPlaceAPI");
        }
    }
}
