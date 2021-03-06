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

            //WritingOnScreen.wypiszCzasyDojscia( dijkstryData, test );
            AssignOrders.assign( dijkstryData, courierCars, test, orderQueue );
            AssignOrders.allocateTime( courierCars, test );


            WritingOnScreen.wypiszWKolejnsciZamowienia( courierCars.get(1).getKolejkaZamowien() );

            WritingOnScreen.wypiszSciezke(courierCars.get(1).getPath());

            //CollectMessages collectMessages = new CollectMessages( test, courierCars, dijkstryData );
            //WritingOnScreen.wypiszKomunikaty(collectMessages.getKomunikaty(), test);
            //WritingOnScreen.wypiszZamowieniaKurierow( courierCars );

        } catch ( FileFormatException e) {
            System.out.println(e.message);
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
