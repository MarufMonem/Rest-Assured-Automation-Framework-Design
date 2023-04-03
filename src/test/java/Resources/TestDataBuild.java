package Resources;

import POJO.AddPlace;
import POJO.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayLoad(){
        AddPlace ap = new AddPlace();
        ap.setAccuracy(50);
        ap.setAddress("Dhaka");
        ap.setLanguage("Bangla");
        ap.setName("Maruf");
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
}
