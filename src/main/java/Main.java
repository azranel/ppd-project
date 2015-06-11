import gui.MainFrame;
import prolog.asker.PrologAsker;


/**
 * Created by azranel on 07.06.15.
 */
public class Main {
    private static String PROLOG_PATH = "src/main/prolog/baza.pl";

    public static void main(String args[]) {
        new MainFrame(new PrologAsker(PROLOG_PATH));
    }

}
