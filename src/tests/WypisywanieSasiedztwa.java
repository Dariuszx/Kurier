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

    public static void wypiszZamowieniaKurierow( Data<CourierCar> courierCars ) {

        for ( int i=0; i < courierCars.size(); i++ ) {

            CourierCar car = courierCars.get( i );
            System.out.println( "Samochod id=" + car.getId() );

            Data<Order> orders = car.getOrders();

            for( int j=0; j < orders.size(); j++ ) {
                System.out.print( " " + orders.get(j).getProductName() );
            }
            System.out.println();
        }
    }

}
