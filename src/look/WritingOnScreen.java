package look;


import algorytmy.Dijkstry;
import dane.*;
import dane.messages.Komunikat;
import dane.messages.Komunikaty;
import dane.orders.Order;
import dane.orders.OrderQueue;

import java.util.ArrayList;

public class WritingOnScreen {

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

            System.out.println();
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

    public static void wypiszKomunikaty( Komunikaty komunikaty, Map map ) {

        System.out.println( "Statusy zleceń:" );

        while ( !komunikaty.empty() ) {

            System.out.println();
            Komunikat komunikat = komunikaty.pop();

            System.out.print( komunikat.getCzas() + " " + komunikat.getKomunikat() + " przesyłkę ");
            System.out.print( komunikat.getOrder().getId() + " (" + komunikat.getOrder().getProductName() + ") ");

            if( komunikat.getKomunikat().equals( "dostarczono" ) )
                System.out.print( "do miasta " + map.getCity(komunikat.getOrder().getIndexB()).getName() );
            else
                System.out.print( "z miasta " + map.getCity(komunikat.getOrder().getIndexA()).getName() );

        }

    }

    public static void wypiszWKolejnsciZamowienia( ArrayList<KolejkaZamowien> zamowienia ) {

        for( int i=0; i < zamowienia.size(); i++ ) {

            KolejkaZamowien zamowienie = zamowienia.get(i);

            System.out.println( "Miasto: " + zamowienie.getCity().getName() + " zamowienie " + zamowienie.getOrder().getProductName() + " | " + zamowienie.getOrder().getIndexA() + " [[czas (" + zamowienie.getTimeGet() + ")]] -> " + zamowienie.getOrder().getIndexB() + " [[czas (" + zamowienie.getTimeDelivered() + ")]]" );

        }
    }
}
