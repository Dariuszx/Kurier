package tests;


import algorytmy.Dijkstry;
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

    public static void wypiszSciezke( Data<City> path ) {

        System.out.println();

        for( int i=0; i < path.size(); i++ ) {
            System.out.print( path.get(i).getName() + " -> ");
        }

    }

    public static void wypiszKolejke( OrderQueue orderQueue ) {

        int i=0;
        while( !orderQueue.empty() ) {
            System.out.println( "i=" + i++ + " " + orderQueue.front().getProductName() + " : " + orderQueue.front().getPriority() );
            orderQueue.pop();
        }
    }

    public static void wypiszSamochody( Data<CourierCar> courierCars ) {

        for( int i=0; i < courierCars.size(); i++ ) {

            CourierCar courierCar = courierCars.get(i);
            System.out.println( "i=" + i + " Samochod id=" + courierCar.getId() );
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

    public static void wypiszCzasyDojscia( Data<Dijkstry> czasyDojscia, Map map ) {

        for( int i=0; i < czasyDojscia.size(); i++ ) {

            Dijkstry dijkstry = czasyDojscia.get(i);

            for( int j=0; j < dijkstry.d.length; j++ ) {

                if( dijkstry.p[j] >= 0 ) {
                    PathToCity path = dijkstry.returnPath( map.getCity( j ) );
                    wypiszSciezke(path.getPath());
                    System.out.print( " - czas dojścia = " + dijkstry.d[j]);
                }

            }


        }

    }

}
