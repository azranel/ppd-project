package prolog.asker;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import gui.MainFrame;
import jpl.Query;
import models.Trip;

import java.util.*;

/**
 * Created by azranel on 09.06.15.
 */
public class PrologAsker {
    private String BRAK = "BRAK";

    public PrologAsker(String filePath) {
        if (!Query.hasSolution("consult('" + filePath + "').")) {
            throw new IllegalArgumentException("filePath is not a valid path. Check if it's good.");
        }
    }

    /**
     * GUI needs something to communicate with logic.
     *
     * @param data - map with parameters for Prolog where key is name of feature and value is just its value
     *             Example: "atrakcje" -> "jezioro", "kraj" -> "Polska"
     * @return Collection of Strings to print on GUI
     */
    public Collection<String> getResults(Map<String, String> data) {
        Collection<String> results = new ArrayList<>();

        Trip trip = new Trip();
        // TODO Get informations from Prolog. This is only example.
        for (String feature : data.keySet()) {
            String featureValue = data.get(feature);
            if (!featureValue.equals(MainFrame.DOESNT_MATTER)) {
                switch (feature) {
                    case "kraj":
                        trip.setCountry(featureValue);
                        break;
                    case "atrakcje":
                        trip.setAttraction(featureValue);
                        break;
                    case "dojazd":
                        trip.setTransport(featureValue);
                        break;
                }
            }
        }
        Query query = trip.toQuery();
        System.out.println(query.toString());
        if (query.hasSolution()) {
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                Trip solut = new Trip(solution);
                solut.copyValuesOf(trip);
                results.add(solut.toString());
                results.add("\n");
            }
        }

        return results;
    }

    private String[] mapKeysToStrings(Trip.KEYS[] input) {
        final Collection<Trip.KEYS> keys = Arrays.asList(input);
        String[] stringKeys = Collections2.transform(keys, new Function<Trip.KEYS, String>() {
            @Override
            public String apply(Trip.KEYS input) {
                return input.toString();
            }
        }).toArray(new String[keys.size()]);
        return stringKeys;
    }

    //wycieczka(KR, M, R, A, K, D, T, W, Z)
    public void findByCountry(String countryName) {
        System.out.println("Looking for country...");

        String[] allKeys = mapKeysToStrings(Trip.KEYS.values());
        String[] keys = Arrays.copyOfRange(allKeys, 1, allKeys.length);

        Query query = new QueryBuilder("wycieczka")
                .addNewAtom(countryName)
                .addNewVariables(keys)
                .buildQuery();

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki do " + countryName);
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                Trip trip = new Trip(solution);
                trip.setCountry(countryName);
                System.out.println(trip.toString());
            }
        } else
            System.out.println(BRAK);
    }

    public void findByCity(String cityName) {
        System.out.println("Looking for city...");
        String[] allKeys = mapKeysToStrings(Trip.KEYS.values());

        Query query = new QueryBuilder("wycieczka").addNewVariable(allKeys[0]).addNewAtom(cityName)
                .addNewVariables(Arrays.copyOfRange(allKeys, 2, allKeys.length)).buildQuery();

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki do " + cityName);
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                Trip trip = new Trip(solution);
                trip.setCity(cityName);
                System.out.println(trip.toString());
            }
        } else
            System.out.println(BRAK);
    }

    public void findByRegion(String regionName) {
        System.out.println("Looking for region...");
        String[] beforeKeys = mapKeysToStrings(Trip.KEYS.getRangeOfKeys(0, 2));
        String[] afterKeys = mapKeysToStrings(Trip.KEYS.getRangeOfKeys(3, Trip.KEYS.values().length));
        Query query = new QueryBuilder("wycieczka").addNewVariables(beforeKeys)
                .addNewAtom(regionName).addNewVariables(afterKeys).buildQuery();


        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki w region: " + regionName);
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                Trip trip = new Trip(solution);
                trip.setRegion(regionName);
                System.out.println(trip.toString());
            }
        } else
            System.out.println(BRAK);
    }

    public void findByAttraction(String attractionName) {
        System.out.println("Looking for attraction...");

        String[] beforeKeys = mapKeysToStrings(Trip.KEYS.getRangeOfKeys(0, 3));
        String[] afterKeys = mapKeysToStrings(Trip.KEYS.getRangeOfKeys(4, Trip.KEYS.values().length));

        Query query = new QueryBuilder("wycieczka").addNewVariables(beforeKeys).addNewAtom(attractionName)
                .addNewVariables(afterKeys).buildQuery();

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki zawierajace atrakcje: " + attractionName);
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                Trip trip = new Trip(solution);
                trip.setAttraction(attractionName);
                System.out.println(trip.toString());
            }
        } else
            System.out.println(BRAK);
    }

    public void findByMaxPrice(int price) {
        System.out.println("Looking for attraction...");
        Query query = new QueryBuilder("cena_max")
                .addNewInteger(price)
                .addNewVariables("KR", "M", "R", "A", "K", "D", "T", "W", "Z")
                .buildQuery();


        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki za max " + price + "zl");
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                String krValue = solution.get("KR").toString();
                String mValue = solution.get("M").toString();
                String rValue = solution.get("R").toString();
                String aValue = solution.get("A").toString();
                String kValue = solution.get("K").toString();
                String dValue = solution.get("D").toString();
                String tValue = solution.get("T").toString();
                String wValue = solution.get("W").toString();
                String zValue = solution.get("Z").toString();
                System.out.println("Wycieczka do " + mValue + "(" + krValue + "), rejon: " + rValue + ", atrakcje: " + aValue + ", koszt: " + kValue + ", na " + dValue + " dni, transport: " + tValue + ", wyzywienie: " + wValue + ", zakwaterowanie: " + zValue);
            }
        } else
            System.out.println(BRAK);
    }

    public void findByMaxPriceForPeople(int price, int people) {
        System.out.println("Looking for attraction...");
        Query query = new QueryBuilder("cena_max")
                .addNewInteger(price)
                .addNewInteger(people)
                .addNewVariables("KR", "M", "R", "A", "K", "D", "T", "W", "Z")
                .buildQuery();

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki za max " + price + "zl");
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                String krValue = solution.get("KR").toString();
                String mValue = solution.get("M").toString();
                String rValue = solution.get("R").toString();
                String aValue = solution.get("A").toString();
                String kValue = solution.get("K").toString();
                String dValue = solution.get("D").toString();
                String tValue = solution.get("T").toString();
                String wValue = solution.get("W").toString();
                String zValue = solution.get("Z").toString();
                System.out.println("Wycieczka do " + mValue + "(" + krValue + "), rejon: " + rValue + ", atrakcje: " + aValue + ", koszt: " + kValue + ", na " + dValue + " dni, transport: " + tValue + ", wyzywienie: " + wValue + ", zakwaterowanie: " + zValue);
            }
        } else
            System.out.println(BRAK);
    }

}
