package tests;


import dane.*;
import dane.orders.ArrayOrders;
import dane.orders.Order;
import dane.orders.OrderQueue;

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

    public static void wypiszSciezke( Data path ) {

        System.out.println();
        System.out.println();

        for( int i=0; i < path.size(); i++ ) {
            if ( path instanceof City )
                System.out.print( ((City)path.get(i)).getName() + " -> ");
            else if ( path instanceof ArrayOrders) {
                System.out.println(((Order) path.get(i)).getProductName() );

            }
        }

        System.out.println();
        System.out.println();
    }

    public static void wypiszKolejke( OrderQueue orderQueue ) {

        while( !orderQueue.empty() ) {
            System.out.println(orderQueue.front().getProductName() + " : " + orderQueue.front().getPriority() );
            orderQueue.pop();
        }
    }

}
