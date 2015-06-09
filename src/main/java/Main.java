import gui.MainFrame;
import jpl.Query;
import prolog.asker.PrologAsker;


/**
 * Created by azranel on 07.06.15.
 */
public class Main {
    public static void main(String args[]) {
        new PrologAsker("src/main/prolog/baza.pl").find_by_city("torun");
        new MainFrame();
    }

}
