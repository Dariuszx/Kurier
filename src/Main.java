import algorytmy.Dijkstry;
import dane.*;

import dane.messages.CollectMessages;
import dane.orders.AssignOrders;
import dane.orders.OrderQueue;
import exceptions.FileFormatException;
import look.WritingOnScreen;

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

        try {
            new DataLoading(args).loadData( test, courierCars, orderQueue, dijkstryData );

            int i=0;

            CollectMessages collectMessages = new CollectMessages();


            AssignOrders.assign(dijkstryData, courierCars, test, orderQueue);


            collectMessages.collect( test, courierCars, dijkstryData );


            //WritingOnScreen.wypiszKomunikaty(collectMessages.getKomunikaty(), test);

            //WritingOnScreen.wypiszSciezke(courierCars.get(2).getPath());

            //WritingOnScreen.wypiszKolejke( orderQueue );
            //WritingOnScreen.wypiszZamowieniaKurierow(courierCars);

                    // while ( ++i == 1 || AssignOrders.assign( dijkstryData, courierCars, test, orderQueue ) ) {

                    //System.out.println( i );
                    //WritingOnScreen.wypiszZamowieniaKurierow( courierCars );

                    //


                    //
                    //  }

                    //
            //WritingOnScreen.wypiszKolejke( orderQueue );

            //

            //

        } catch ( FileFormatException e) {
            System.out.println(e.message);
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
