import algorytmy.Dijkstry;
import dane.*;

import dane.orders.ArrayOrders;
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



        test.addCity( new City( "0" ) );
        test.addCity( new City( "1" ) );
        test.addCity( new City( "2" ) );
        test.addCity( new City( "3" ) );
        test.addCity( new City( "4" ) );
        test.addCity( new City( "5" ) );
        test.addCity( new City( "6" ) );

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


        //Generuję wszystkie czasy dojścia do wierzchołków
        ((ArrayDijkstry)dijkstryData).generate( test );
    }
}
