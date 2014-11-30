package tests;


import dane.City;
import dane.Map;
import dane.NeighbourList;

public class WypisywanieSasiedztwa {

    public static void wypisz( Map mapa ) {

        for( int i=0; i < mapa.getSize(); i++ ) {

            City tmp = mapa.getCity( i );
            System.out.println();
            System.out.print( tmp.getName() + ": " );

            NeighbourList neighbourList = tmp.getNeighbourList();

            while ( neighbourList != null ) {
                System.out.print( neighbourList.getCity().getName() + " (" + neighbourList.getWeight() + ") " );
                neighbourList = neighbourList.getNext();
            }


        }
    }

    public static void wypiszTablice( int[] tablica ) {

        System.out.println();
        System.out.println();
        for( int i=0; i < tablica.length; i++ ) {
            System.out.println( tablica[i] );
        }
    }

}
