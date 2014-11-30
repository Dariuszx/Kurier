package algorytmy;

import dane.City;
import dane.Map;
import dane.NeighbourList;
import dane.Path;

public class Dijkstry {

    private int[] d, p;
    private boolean[] QS;

    private City cityA;

    private Map Q, S;

    public Dijkstry( Map Q, City cityA ) {

        this.S = new Map();
        this.Q = Q;
        this.cityA = cityA;


        d = setArray( Q.getSize(), 99999999 );
        p = setArray( Q.getSize(), -1 );
        QS = setQSArray( Q.getSize(), false );

        d[ Q.getCityIndex(cityA) ] = 0;


        for( int i=0; i < Q.getSize(); i++ ) {

            City tmp = returnSmallestWeight();
            browseNeighbours( tmp );


        }
    }

    public void browseNeighbours( City city ) {

        NeighbourList list = city.getNeighbourList();

        while ( list != null ) {
            if( d[list.getIndex()] > d[ Q.getCityIndex( city ) ] + list.getWeight() ) {
                d[list.getIndex()] = d[ Q.getCityIndex( city ) ] + list.getWeight();
                p[list.getIndex()] = Q.getCityIndex( city );
            }
            list = list.getNext();
        }

    }

    public City returnSmallestWeight() {

        City tmp = cityA;

        int distance = 999999999;

        for( int i=0; i < Q.getSize(); i++ ) {

            if( d[i] < distance && QS[ i ] != true ) {
                distance = d[i];
                tmp = Q.getCity( i );
            }
        }

        S.addCity( tmp );

        QS[ Q.getCityIndex( tmp ) ] = true;

        return tmp;

    }

    public void moveCityFromQToS( City city ) {

        S.addCity( city );
        QS[ Q.getCityIndex( city ) ] = true;
    }

    public static void setNeighboursDistance( Map mapa, int[] d, NeighbourList neighbourList) {

        if( neighbourList == null ) return;

        NeighbourList tmp = neighbourList;

        while( tmp != null ) {

            d[ tmp.getIndex() ] = tmp.getWeight();
            tmp = tmp.getNext();

        }

    }

    public static int[] setArray( int n, int value ) {

        int[] array = new int[n];

        for( int i=0; i<n; i++ )
            array[i] = value;

        return array;
    }

    public static boolean[] setQSArray( int n, boolean value ) {

        boolean[] array = new boolean[n];

        for( int i=0; i < n; i++ )
            array[i] = value;

        return array;
    }

}
