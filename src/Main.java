import dane.City;

import dane.Map;
import tests.WypisywanieSasiedztwa;


public class Main {

    public static void main( String[] args ) {

        Map test = new Map();
        test.addCity( new City( "Warszawa", 100 ) );
        test.addCity( new City( "Radom", 100 ) );
        test.addCity( new City( "Kraków", 100 ) );

        test.setNeighbour( 0, 1 );
        test.setNeighbour( 0, 2 );

        WypisywanieSasiedztwa.wypisz( test );
    }
}
