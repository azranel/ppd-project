package models;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

/**
 * Created by azranel on 10.06.15.
 */
public class Trip {
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getHowMuchDays() {
        return howMuchDays;
    }

    public void setHowMuchDays(String howMuchDays) {
        this.howMuchDays = howMuchDays;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getFeeding() {
        return feeding;
    }

    public void setFeeding(String feeding) {
        this.feeding = feeding;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    private String country;
    private String city;
    private String region;
    private String attraction;
    private String cost;
    private String howMuchDays;
    private String transport;
    private String feeding;
    private String accomodation;

    public enum KEYS {
        COUNTRY,
        CITY,
        REGION,
        ATTRACTION,
        COST,
        DAYSLONG,
        TRANSPORT,
        FEEDING,
        ACCOMODATION;


        public static KEYS[] getRangeOfKeys(int from, int to) {
            final KEYS[] allKeys = values();
            if(from < 0 || to > allKeys.length)
                throw new IllegalArgumentException("from or to are out of range");
            return Arrays.copyOfRange(allKeys, from, to);
        }
    }

    public Trip(Hashtable tripData) {
        country = tripData.getOrDefault(KEYS.COUNTRY.toString(), "").toString();
        city = tripData.getOrDefault(KEYS.CITY.toString(), "").toString();
        region = tripData.getOrDefault(KEYS.REGION.toString(), "").toString();
        attraction = tripData.getOrDefault(KEYS.ATTRACTION.toString(), "").toString();
        cost = tripData.getOrDefault(KEYS.COST.toString(), "0").toString();
        howMuchDays = tripData.getOrDefault(KEYS.DAYSLONG.toString(), "0").toString();
        transport = tripData.getOrDefault(KEYS.TRANSPORT.toString(), "").toString();
        feeding = tripData.getOrDefault(KEYS.FEEDING.toString(), "").toString();
        accomodation = tripData.getOrDefault(KEYS.ACCOMODATION.toString(), "").toString();
    }

    @Override
    public String toString() {
        return "Wycieczka do " + city + " w " + country +
                ", rejon " + region + ", atrakcje: " + attraction +
                ", koszt: " + cost + ", na " + howMuchDays +
                " dni, transport: " + transport + ", wyzywienie: " +
                feeding + ", zakwaterowanie: " + accomodation;
    }
}
