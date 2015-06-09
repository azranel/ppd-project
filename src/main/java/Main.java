import jpl.*;
import jpl.Integer;

import java.util.Hashtable;

/**
 * Created by azranel on 07.06.15.
 */
public class Main {
    public static void main(String args[]) {
        if (!Query.hasSolution("consult('src/main/prolog/baza.pl').")) {
            System.out.println("Consult failed");
        } else {
//            test3a("85");
            find_by_city("torun");
        }
    }

    private static void find_by_city(String city) {
        System.out.println("Looking for city...");
        Variable KR = new Variable("KR");
        Variable R = new Variable("R");
        Variable A = new Variable("A");
        Variable K = new Variable("K");
        Variable D = new Variable("D");
        Variable T = new Variable("T");
        Variable W = new Variable("W");
        Variable Z = new Variable("Z");
        jpl.Atom qcity = new Atom(city);

        //wycieczka(KR, M, R, A, K, D, T, W, Z)
        Query query = new Query("wycieczka", new Term[]{KR, qcity, R, A, K, D, T, W, Z});

        System.out.println(query.toString());
        if (query.hasSolution()) {
            System.out.println("Wycieczki do " + city);
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

    private static void test3a(String sent) {
        System.out.println("Success!");
        // a variable which will get the output.
        Variable X = new Variable("X");
        jpl.Integer age = new Integer(Long.valueOf(sent));

        //creating query object to make a query to prolog code.
        Query q3 = new Query("wiek", new Term[]{X, age});
        System.out.println(q3.toString());
        if (q3.hasSolution()) {
            Hashtable[] solutions = q3.allSolutions();
            for (Hashtable solution : solutions) {
                String xValue = solution.get("X").toString();
                System.out.println("Ta osoba ma " + sent + " lat: " + xValue);//get the value stored in X
            }
        } else
            System.out.println("NIE MA");
    }
}
