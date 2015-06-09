package prolog.asker;

import jpl.Query;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

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
     * 
     * GUI needs something to communicate with logic.
     * 
     * @param data - map with parameters for Prolog where key is name of feature and value is just its value
     * 				 Example: "atrakcje" -> "jezioro", "kraj" -> "Polska"  
     * @return Collection of Strings to print on GUI
     */
	public Collection<String> getResults(Map<String, String> data) {
		// TODO Auto-generated method stub
		return null;
	}
    
    //wycieczka(KR, M, R, A, K, D, T, W, Z)
    public void findByCountry(String countryName) {
        System.out.println("Looking for country...");
        Query query = new QueryBuilder("wycieczka")
                .addNewAtom(countryName)
                .addNewVariables("M", "R", "A", "K", "D", "T", "W", "Z")
                .buildQuery();

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki do " + countryName);
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                String mValue = solution.get("M").toString();
                String rValue = solution.get("R").toString();
                String aValue = solution.get("A").toString();
                String kValue = solution.get("K").toString();
                String dValue = solution.get("D").toString();
                String tValue = solution.get("T").toString();
                String wValue = solution.get("W").toString();
                String zValue = solution.get("Z").toString();
                System.out.println("Wycieczka do " + mValue + ", rejon: " + rValue + ", atrakcje: " + aValue + ", koszt: " + kValue + ", na " + dValue + " dni, transport: " + tValue + ", wyzywienie: " + wValue + ", zakwaterowanie: " + zValue);
            }
        } else
            System.out.println(BRAK);
    }

    public void findByCity(String cityName) {
        System.out.println("Looking for city...");
        Query query = new QueryBuilder("wycieczka")
                .addNewVariable("KR")
                .addNewAtom(cityName)
                .addNewVariables("R", "A", "K", "D", "T", "W", "Z")
                .buildQuery();

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki do " + cityName);
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                String krValue = solution.get("KR").toString();
                String rValue = solution.get("R").toString();
                String aValue = solution.get("A").toString();
                String kValue = solution.get("K").toString();
                String dValue = solution.get("D").toString();
                String tValue = solution.get("T").toString();
                String wValue = solution.get("W").toString();
                String zValue = solution.get("Z").toString();
                System.out.println("Wycieczka do " + krValue + ", rejon: " + rValue + ", atrakcje: " + aValue + ", koszt: " + kValue + ", na " + dValue + " dni, transport: " + tValue + ", wyzywienie: " + wValue + ", zakwaterowanie: " + zValue);
            }
        } else
            System.out.println(BRAK);
    }

    public void findByRegion(String regionName) {
        System.out.println("Looking for region...");
        Query query = new QueryBuilder("wycieczka")
                .addNewVariables("KR", "M")
                .addNewAtom(regionName)
                .addNewVariables("A", "K", "D", "T", "W", "Z")
                .buildQuery();

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki w region: " + regionName);
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                String krValue = solution.get("KR").toString();
                String mValue = solution.get("M").toString();
                String aValue = solution.get("A").toString();
                String kValue = solution.get("K").toString();
                String dValue = solution.get("D").toString();
                String tValue = solution.get("T").toString();
                String wValue = solution.get("W").toString();
                String zValue = solution.get("Z").toString();
                System.out.println("Wycieczka do " + mValue + "(" + krValue + "), atrakcje: " + aValue + ", koszt: " + kValue + ", na " + dValue + " dni, transport: " + tValue + ", wyzywienie: " + wValue + ", zakwaterowanie: " + zValue);
            }
        } else
            System.out.println(BRAK);
    }

    public void findByAttraction(String attractionName) {
        System.out.println("Looking for attraction...");
        Query query = new QueryBuilder("wycieczka")
                .addNewVariables("KR", "M", "R")
                .addNewAtom(attractionName)
                .addNewVariables("K", "D", "T", "W", "Z")
                .buildQuery();

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki zawierajace atrakcje: " + attractionName);
            Hashtable[] solutions = query.allSolutions();
            for (Hashtable solution : solutions) {
                String krValue = solution.get("KR").toString();
                String mValue = solution.get("M").toString();
                String rValue = solution.get("R").toString();
                String kValue = solution.get("K").toString();
                String dValue = solution.get("D").toString();
                String tValue = solution.get("T").toString();
                String wValue = solution.get("W").toString();
                String zValue = solution.get("Z").toString();
                System.out.println("Wycieczka do " + mValue + "(" + krValue + "), rejon: " + rValue + ", koszt: " + kValue + ", na " + dValue + " dni, transport: " + tValue + ", wyzywienie: " + wValue + ", zakwaterowanie: " + zValue);
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
