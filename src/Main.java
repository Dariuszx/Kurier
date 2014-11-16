import dane.City;

import dane.Map;
import tests.WypisywanieSasiedztwa;


public class Main {

    public static void main( String[] args ) {

        Map test = new Map();
        test.addCity( new City( "Warszawa" ) );
        test.addCity( new City( "Radom" ) );
        test.addCity( new City( "Kraków" ) );

        test.setNeighbour( 0, 1, 80 );
        test.setNeighbour( 0, 2, 50 );

        WypisywanieSasiedztwa.wypisz( test );
    }
}
