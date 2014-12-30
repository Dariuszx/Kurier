package dane.orders;

import algorytmy.Dijkstry;
import dane.*;

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
                if( order.getIndexA() != courierCar.getIndexOfLastCity() ) {
                    //Ścieżka z A -> B
                    PathToCity pathToCityB = dijkstryData.get( courierCar.getIndexOfLastCity() ).returnPath( map.getCity( order.getIndexA() ) );

                    //Ścieżka B -> C
                    PathToCity pathToCityC = dijkstryData.get( order.getIndexA() ).returnPath( map.getCity( order.getIndexB() ) );


                    courierCar.addOrderToQueue( order, map.getCity( order.getIndexA() ) );
                    courierCar.addOrder( orderQueue.pop() );
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

    public static void allocateTime( Data<CourierCar> courersCars, Map map ) {


        for( int i=0; i < courersCars.size(); i++ ) {

            CourierCar courierCar = courersCars.get(i);
            Data<City> path = courierCar.getPath();
            int czas_bezwzgledny = 0;
            int pojemnosc = courierCar.getMaxOrders();
            int i_pojemnosc = 0;

            for( int j=0; j < path.size(); j++ ) {

                City city = path.get(j);
                int index = map.getCityIndex( city );

                if( j + 1 != path.size() && city.equals( path.get( j+1) ) ) continue;




                for( int k=0; k < courierCar.getKolejkaZamowien().size(); k++ ) {

                    KolejkaZamowien zamowienie = courierCar.getKolejkaZamowien().get(k);

                    if( i_pojemnosc < pojemnosc && zamowienie.getOrder().getIndexA() == index && zamowienie.czyOdebrano == 0 ) {
                        i_pojemnosc++;
                        if( i == 1 ) System.out.println( "++" + zamowienie.getOrder().getProductName() + " city=" + city.getName() );
                        zamowienie.czyOdebrano = 1;
                        zamowienie.setTimeGet( czas_bezwzgledny );
                    } else if ( zamowienie.getOrder().getIndexB() == index && zamowienie.czyOdebrano == 1 ) {
                        i_pojemnosc--;
                        if( i == 1 ) System.out.println( "--" + zamowienie.getOrder().getProductName() + " city=" + city.getName() );
                        zamowienie.czyOdebrano = 2;
                        zamowienie.setTimeDelivered( czas_bezwzgledny );
                    }
                }

                if( j + 1 < path.size() ) {
                    czas_bezwzgledny += city.getWeight( map.getCityIndex( path.get( j+1) ) );
                }

            }

        }

    }
}
