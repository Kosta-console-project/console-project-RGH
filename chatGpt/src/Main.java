import project.Menu;
import project.config.db.Sequence;
import project.config.db.Table;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();

        Table table = new Table();
        Sequence sequence = new Sequence();

<<<<<<< HEAD
//        table.dropAll();
//        table.createAll();
//
//	      sequence.dropAll();
//        sequence.createAll();
=======
        table.dropAll();
        table.createAll();
//
        sequence.dropAll();
        sequence.createAll();
>>>>>>> b34e40c30285d1d3ec3f50448007e20c9e0a152b

        menu.run(sc);

        sc.close();
    }
}