package prolog.asker;

import jpl.Query;
import jpl.Variable;

import java.util.Hashtable;

/**
 * Created by azranel on 09.06.15.
 */
public class PrologAsker {
    public PrologAsker(String filePath) {
        if(!Query.hasSolution("consult('" + filePath + "').")) {
            throw new IllegalArgumentException("filePath is not a valid path. Check if it's good.");
        }
    }

    //wycieczka(KR, M, R, A, K, D, T, W, Z)
    public void find_by_city(String cityName) {
        System.out.println("Looking for city...");
        Query query = new QueryBuilder("wycieczka")
                .addNewVariable("KR").addNewAtom(cityName)
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
                System.out.println("Wycieczka do " + krValue + " rejon: " + rValue + ", atrakcje: " + aValue + ", koszt: " + kValue + ", na " + dValue + " dni, transport: " + tValue + ", wyzywienie: " + wValue + ", zakwaterowanie: " + zValue);
            }
        } else
            System.out.println("BRAK");
    }
}
