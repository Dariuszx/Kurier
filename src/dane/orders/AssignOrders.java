package dane.orders;

import algorytmy.Dijkstry;
import dane.CourierCar;
import dane.Data;
import dane.Map;
import dane.PathToCity;

public class AssignOrders {

    //metoda przydziela zlecenia do kolejnych samochodów kurierskich
    public static void assign( Data<Dijkstry> dijkstryData, Data<CourierCar> courierCars, Map map, OrderQueue orderQueue ) {

        //Jeżeli zlecenia nieprzydzielone != 0
        while ( !orderQueue.empty() ) {

            //Przechodzę przez samochody kurierskie
            for( int i=0; i < courierCars.size(); i++ ) {

                CourierCar courierCar = courierCars.get( i ); //samochód kurierski
                Order order = orderQueue.front(); //pobieram pierwsze zlecenie z góry

                if ( order == null ) break;

                //Jeżeli zlecenie nie jest w mieście gdzie startuje samochód
                //Zapisuje ścieżke gdzie ma pojechać
                //Paczka jest zaadresowana z B->C
                if( order.getIndexA() != courierCar.getIndexOfStartPossition() ) {
                    //Ścieżka z A -> B
                    PathToCity pathToCityB = dijkstryData.get( courierCar.getIndexOfStartPossition() ).returnPath( map.getCity( order.getIndexA() ) );

                    //Ścieżka B -> C
                    PathToCity pathToCityC = dijkstryData.get( order.getIndexA() ).returnPath( map.getCity( order.getIndexB() ) );

                    orderQueue = OrderQueue.getOrdersByPath( orderQueue, pathToCityB.getPath(), courierCar, map );
                    orderQueue = OrderQueue.getOrdersByPath( orderQueue, pathToCityC.getPath(), courierCar, map );

                } else {
                    PathToCity pathToCityB = dijkstryData.get( order.getIndexA() ).returnPath( map.getCity( order.getIndexB() ) );
                    orderQueue = OrderQueue.getOrdersByPath( orderQueue, pathToCityB.getPath(), courierCar, map );
                }

                //Ustawiam index miasto ostatniego do którego pojadę
                courierCar.setIndexOfLastCity( order.getIndexB() );

            }

        }

    }

}
