package pt.up.fe.ldts.example6;

import java.util.Date;

public class Location {
    public Date plantedAt;
    public String locationLatitude;
    public String locationLongitude;
    public String locationName;

    public Location(Date plantedAt, String locationLatitude, String locationLongitude, String locationName){
        this.plantedAt = plantedAt;
        this.setLocation(locationLatitude, locationLongitude, locationName);
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName){
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + this.locationLatitude + "," + this.locationLongitude + " (" + this.locationName + ")";
    }
}