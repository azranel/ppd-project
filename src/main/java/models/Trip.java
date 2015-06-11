package models;

import com.google.common.base.Strings;
import com.sun.deploy.util.StringUtils;
import gui.MainFrame;
import jpl.Query;
import prolog.asker.QueryBuilder;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by azranel on 10.06.15.
 */
public class Trip {
    public Trip() {

    }

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

    public String getCostMin() {
        return costMin;
    }

    public void setCostMin(String cost) {
        this.costMin = cost;
    }

    public String getCostMax() {
        return costMax;
    }

    public void setCostMax(String cost) {
        this.costMax = cost;
    }

    public String getHowMuchDays() {
        return howMuchDays;
    }

    public void setHowMuchDays(String howMuchDays) {
        this.howMuchDays = howMuchDays;
    }

    public String getHowMuchDaysMin() {
        return howMuchDaysMin;
    }

    public void setHowMuchDaysMin(String howMuchDays) {
        this.howMuchDaysMin = howMuchDays;
    }

    public String getHowMuchDaysMax() {
        return howMuchDaysMax;
    }

    public void setHowMuchDaysMax(String howMuchDays) {
        this.howMuchDaysMax = howMuchDays;
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
    private String costMin;
    private String costMax;
    private String howMuchDays;
    private String howMuchDaysMin;
    private String howMuchDaysMax;
    private String transport;
    private String feeding;
    private String accomodation;

    public void copyValuesOf(Trip trip) {
        if (!Strings.isNullOrEmpty(trip.country))
            country = trip.country;
        if (!Strings.isNullOrEmpty(trip.city))
            city = trip.city;
        if (!Strings.isNullOrEmpty(trip.region))
            region = trip.region;
        if (!Strings.isNullOrEmpty(trip.attraction))
            attraction = trip.attraction;
        if (!Strings.isNullOrEmpty(trip.cost))
            cost = trip.cost;

        if (!Strings.isNullOrEmpty(trip.costMin))
            costMin = trip.costMin;
        else
            costMin = "0";

        if (!Strings.isNullOrEmpty(trip.costMax))
            costMax = trip.costMax;
        else
            costMax = Integer.toString(Integer.MAX_VALUE);

        if (!Strings.isNullOrEmpty(trip.howMuchDays))
            howMuchDays = trip.howMuchDays;

        if (!Strings.isNullOrEmpty(trip.howMuchDaysMin))
            howMuchDaysMin = trip.howMuchDaysMin;
        else
            howMuchDaysMin = "1";

        if (!Strings.isNullOrEmpty(trip.howMuchDaysMax))
            howMuchDaysMax = trip.howMuchDaysMax;
        else
            howMuchDaysMax = Integer.toString(Integer.MAX_VALUE);

        if (!Strings.isNullOrEmpty(trip.transport))
            transport = trip.transport;
        if (!Strings.isNullOrEmpty(trip.feeding))
            feeding = trip.feeding;
        if (!Strings.isNullOrEmpty(trip.accomodation))
            accomodation = trip.accomodation;
    }

    public enum KEYS {
        COUNTRY,
        CITY,
        REGION,
        ATTRACTION,
        COST,
        COST_MIN,
        COST_MAX,
        DAYS_LONG,
        DAYS_LONG_MIN,
        DAYS_LONG_MAX,
        TRANSPORT,
        FEEDING,
        ACCOMODATION;


        public static KEYS[] getRangeOfKeys(int from, int to) {
            final KEYS[] allKeys = values();
            if (from < 0 || to > allKeys.length)
                throw new IllegalArgumentException("from or to are out of range");
            return Arrays.copyOfRange(allKeys, from, to);
        }
    }

    public Trip(Hashtable tripData) {
        country = tripData.getOrDefault(KEYS.COUNTRY.toString(), "").toString();
        city = tripData.getOrDefault(KEYS.CITY.toString(), "").toString();
        region = tripData.getOrDefault(KEYS.REGION.toString(), "").toString();
        attraction = tripData.getOrDefault(KEYS.ATTRACTION.toString(), "").toString();
        cost = tripData.getOrDefault(KEYS.COST.toString(), "").toString();
        costMin = tripData.getOrDefault(KEYS.COST_MIN.toString(), "0").toString();
        costMax = tripData.getOrDefault(KEYS.COST_MAX.toString(), Integer.toString(Integer.MAX_VALUE)).toString();
        howMuchDays = tripData.getOrDefault(KEYS.DAYS_LONG.toString(), "").toString();
        howMuchDaysMin = tripData.getOrDefault(KEYS.DAYS_LONG_MIN.toString(), "1").toString();
        howMuchDaysMax = tripData.getOrDefault(KEYS.DAYS_LONG_MAX.toString(), Integer.toString(Integer.MAX_VALUE)).toString();
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

    public Query toQuery() {
        QueryBuilder builder = new QueryBuilder("znajdz_wycieczke");
        String[] values = new String[]{country, city, region, attraction, cost, costMin, costMax,
                howMuchDays, howMuchDaysMin, howMuchDaysMax, transport, feeding, accomodation};
        KEYS[] keys = KEYS.values();
        for (int i = 0; i < values.length; i++) {
            if (Strings.isNullOrEmpty(values[i]))
                builder.addNewVariable(keys[i].toString());
            else {
                if (values[i].equals(cost) || values[i].equals(costMin) || values[i].equals(costMax) || values[i].equals(howMuchDays) || values[i].equals(howMuchDaysMin) || values[i].equals(howMuchDaysMax))
                    builder.addNewInteger(Integer.valueOf(values[i]));
                else {
                    String value = values[i].replace(' ', '_');
                    builder.addNewAtom(value);
                }
            }
        }
        return builder.buildQuery();
    }

    public static Trip fromMap(Map<String, String> data) {
        Trip trip = new Trip();
        for (String feature : data.keySet()) {
            String featureValue = data.get(feature);
            if (!featureValue.equals(MainFrame.DOESNT_MATTER)) {
                switch (feature) {
                    case "kraj":
                        trip.setCountry(featureValue);
                        break;
                    case "miasto":
                        trip.setCity(featureValue);
                        break;
                    case "atrakcje":
                        trip.setAttraction(featureValue);
                        break;
                    case "cenaMin":
                        trip.setCostMin(featureValue);
                        break;
                    case "cenaMax":
                        trip.setCostMax(featureValue);
                        break;
                    case "dniMin":
                        trip.setHowMuchDaysMin(featureValue);
                        break;
                    case "dniMax":
                        trip.setHowMuchDaysMax(featureValue);
                        break;
                    case "dojazd":
                        trip.setTransport(featureValue);
                        break;
                    case "zakwaterowanie":
                        trip.setAccomodation(featureValue);
                        break;
                    case "wyzywienie":
                        trip.setFeeding(featureValue);
                        break;
                }
            }
        }
        return trip;
    }
}
