import gui.MainFrame;
import prolog.asker.PrologAsker;


/**
 * Created by azranel on 07.06.15.
 */
public class Main {
    private static String PROLOG_PATH = "src/main/prolog/baza.pl";

    public static void main(String args[]) {
//        new PrologAsker(PROLOG_PATH).findByCountry("polska");
//        new PrologAsker(PROLOG_PATH).findByCity("torun");
//        new PrologAsker(PROLOG_PATH).findByRegion("miasto");
//        new PrologAsker(PROLOG_PATH).findByAttraction("zamek");
//        new PrologAsker(PROLOG_PATH).findByMaxPrice(1000);
//        new PrologAsker(PROLOG_PATH).findByMaxPriceForPeople(1000, 2);
        new MainFrame(new PrologAsker(PROLOG_PATH));
    }

}
