import algorytmy.Dijkstry;
import dane.City;

import dane.Map;
import tests.WypisywanieSasiedztwa;


public class Main {

    public static void main( String[] args ) {

        Map test = new Map();
        test.addCity( new City( "0" ) );
        test.addCity( new City( "1" ) );
        test.addCity( new City( "2" ) );
        test.addCity( new City( "3" ) );
        test.addCity( new City( "4" ) );
        test.addCity( new City( "5" ) );

        test.setNeighbour( 0, 1, 30 );
        test.setNeighbour( 0, 4, 30 );
        test.setNeighbour( 0, 5, 60 );
        test.setNeighbour( 1, 2, 10 );
        test.setNeighbour( 1, 3, 30 );
        test.setNeighbour( 2, 5, 10 );
        test.setNeighbour( 2, 3, 30 );
        test.setNeighbour( 3, 5, 10 );
        test.setNeighbour( 4, 5, 20 );


        WypisywanieSasiedztwa.wypisz( test );

        Dijkstry d =  new Dijkstry( test, test.getCity(0) );

    }
}
