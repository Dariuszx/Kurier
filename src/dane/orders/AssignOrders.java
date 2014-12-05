package dane.orders;

import algorytmy.Dijkstry;
import dane.CourierCar;
import dane.Data;
import dane.Map;
import dane.PathToCity;

public class AssignOrders {

    public void assignOrders( Data<Dijkstry> dijkstryData, Data<CourierCar> courierCars, Map map, OrderQueue orderQueue ) {


        while ( !orderQueue.empty() ) {

            //Przechodzę przez samochody kurierskie
            for( int i=0; i < courierCars.size(); i++ ) {

                CourierCar courierCar = courierCars.get( i );
                Order order = orderQueue.front();

                //Ustawiam index miasto ostatniego do którego pojadę
                courierCar.setIndexOfLastCity(order.getIndexB());


                //Jeżeli zlecenie nie jest w mieście gdzie startuje samochód
                //Zapisuje ścieżke gdzie ma pojechać
                //Paczka jest zaadresowana z B->C
                if( order.getIndexA() != courierCar.getIndexOfStartPossition() ) {
                    //Ścieżka z A -> B
                    PathToCity pathToCityB = dijkstryData.get( courierCar.getIndexOfStartPossition() ).returnPath( map.getCity( order.getIndexA() ) );
                    //Ścieżka B -> C
                    PathToCity pathToCityC = dijkstryData.get( order.getIndexA() ).returnPath( map.getCity( order.getIndexB() ) );

                    orderQueue.getQueueByPath( map, pathToCityB, courierCar.getOrders() );
                    orderQueue.getQueueByPath( map, pathToCityC, courierCar.getOrders() );

                } else {
                    PathToCity pathToCityB = dijkstryData.get( order.getIndexA() ).returnPath( map.getCity( order.getIndexB() ) );
                    orderQueue.getQueueByPath( map, pathToCityB, courierCar.getOrders() );
                }

               //System.out.println( "Wrzucam do samochodu id=" + courierCar.getId() + " paczke " + order.getProductName() );


                //Wrzucam paczkę do samochodu
                courierCar.addOrder(orderQueue.pop());
            }

        }

    }

}
