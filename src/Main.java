import algorytmy.Dijkstry;
import dane.*;

import dane.messages.CollectMessages;
import dane.orders.ArrayOrders;
import dane.orders.AssignOrders;
import dane.orders.Order;
import dane.orders.OrderQueue;
import tests.WypisywanieSasiedztwa;

public class Main {

    public static void main( String[] args ) {

        //Tablica samochodów kurierskich
        Data<CourierCar> courierCars = new ArrayCourierCars();

        //Graf
        Map test = new Map();

        //Kolejka priorytetowa zleceń
        OrderQueue orderQueue = new OrderQueue();

        //Tablica kosztów dojść do wszystkich wierzchołków grafu
        Data<Dijkstry> dijkstryData = new ArrayDijkstry();


        test.addCity( new City( "Warszawa" ) );
        test.addCity( new City( "Radom" ) );
        test.addCity( new City( "Sosnowiec" ) );
        test.addCity( new City( "Stalowa Wola" ) );
        test.addCity( new City( "Karków" ) );
        test.addCity( new City( "Lipa" ) );
        test.addCity( new City( "Poznań" ) );

        test.setNeighbour( 0, 1, 30 );
        test.setNeighbour( 0, 4, 30 );
        test.setNeighbour( 0, 5, 60 );
        test.setNeighbour( 1, 2, 10 );
        test.setNeighbour( 1, 3, 30 );
        test.setNeighbour( 2, 5, 10 );
        test.setNeighbour( 2, 3, 30 );
        test.setNeighbour( 3, 5, 10 );
        test.setNeighbour( 4, 5, 20 );
        test.setNeighbour( 6, 3, 40 );


        orderQueue.push( new Order( "rower", 0, 1, 70, 001 ) );
        orderQueue.push( new Order( "krzesło", 0, 5, 18, 002 ) );
        orderQueue.push( new Order( "Kolumny", 2, 6, 18, 003 ) );
        orderQueue.push( new Order( "Stół", 4, 0, 58, 004 ) );
        orderQueue.push( new Order( "Prata C", 0, 3, 82, 005 ) );
        orderQueue.push( new Order( "Coś fajnego", 0, 5, 45, 006 ) );


        courierCars.add(new CourierCar(new ArrayOrders(), 2, 1, 10));
        courierCars.add( new CourierCar( new ArrayOrders(), 4, 2, 10 ) );
        courierCars.add( new CourierCar( new ArrayOrders(), 0, 3, 10 ) );

        //Generuję wszystkie czasy dojścia do wierzchołków
        ((ArrayDijkstry)dijkstryData).generate(test);


        //WypisywanieSasiedztwa.wypiszCzasyDojscia( dijkstryData, test );


        AssignOrders.assign(dijkstryData, courierCars, test, orderQueue);

        CollectMessages collectMessages = new CollectMessages( test, courierCars, dijkstryData );

        //ystem.out.println( collectMessages.getKomunikaty().pop().getKomunikat() );


        WypisywanieSasiedztwa.wypiszKomunikaty( collectMessages.getKomunikaty(), test );

        //WypisywanieSasiedztwa.wypiszKolejke( orderQueue );


        //WypisywanieSasiedztwa.wypiszSciezke( dijkstryData.get(0).returnPath( test.getCity(6)).getPath() );


        //System.out.println( courierCars.get(1).getOrders().size() );
        //WypisywanieSasiedztwa.wypiszZamowieniaKurierow( courierCars );


        //WypisywanieSasiedztwa.wypiszSciezke(courierCars.get(0).getPath());
        //WypisywanieSasiedztwa.wypiszSciezke( courierCars.get(1).getPath() );
        //WypisywanieSasiedztwa.wypiszSciezke( courierCars.get(2).getPath() );
    }
}
