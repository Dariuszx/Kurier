package algorytmy;

import dane.City;
import dane.Map;
import dane.Path;

public class Dijkstry {

    public static Path findPath( Map Q, City cityA, City cityB ) {

        Map S = new Map();

        int[] d = setArray( Q.getSize(), 999999 );
        int[] p = setArray( Q.getSize(), -1 );

        d[0] = 0;

        S.addCity( cityA );


        return null;
    }

    public static void setDistance( Map mapa, int[] d, int i, City city ) {



    }

    public static int[] setArray( int n, int value ) {

        int[] array = new int[n];

        for( int i=0; i<n; i++ )
            array[i] = value;

        return array;
    }

}
