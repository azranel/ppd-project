import jpl.*;
import jpl.Integer;

import java.util.Hashtable;

/**
 * Created by azranel on 07.06.15.
 */
public class Main {
    public static void main(String args[]) {
        if (!Query.hasSolution("consult('/home/azranel/Documents/PPD/dane.pl').")) {
            System.out.println("Consult failed");
        } else {
            test3a("85");
        }
    }

    private static void test3a(String sent) {
        System.out.println("Success!");
        // a variable which will get the output.
        Variable X = new Variable("X");
        jpl.Integer age = new Integer(Long.valueOf(sent));

        //creating query object to make a query to prolog code.
        Query q3 = new Query("wiek", new Term[] { X, age });
        System.out.println(q3.toString());
        if(q3.hasSolution()) {
            Hashtable[] solutions = q3.allSolutions();
            for(Hashtable solution : solutions) {
                String xValue = solution.get("X").toString();
                System.out.println("Ta osoba ma " + sent + " lat: " + xValue);//get the value stored in X
            }
        }
        else
            System.out.println("NIE MA");
    }
}
