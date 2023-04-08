package Resources;

import POJO.AddPlace;
import POJO.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayLoad(String name, String language, String address){
        AddPlace ap = new AddPlace();
        ap.setAccuracy(50);
        ap.setAddress(address);
        ap.setLanguage(language);
        ap.setName(name);
        ap.setPhone_number("12345");
        ap.setWebsite("www.google.com");
        List<String> type = new ArrayList<String>();
        type.add("Phone");
        type.add("laptop");
        ap.setTypes(type);

        Location l = new Location();
        l.setLat(-38.3834);
        l.setLng(33.4273);
        ap.setLocation(l);

        return ap;
    }

    public String deletePayload(String placeID){
        return "{\n" +
                "    \"place_id\": \""+placeID+"\"\n" +
                "}";
    }
}
