package dane.messages;


import algorytmy.Dijkstry;
import dane.*;
import dane.orders.Order;

public class CollectMessages {

    private Komunikaty komunikaty;

    public CollectMessages( Map map, Data<CourierCar> courierCars, Data<Dijkstry> dijkstry ) {

        komunikaty = new Komunikaty();

        //przeglądam smaochody
        for( int i=0; i < courierCars.size(); i++ ) {

            CourierCar courierCar = courierCars.get( i );


            Data<City> path = courierCar.getPath();

            //przeglądam zlecenia w samochodach do realizacji
            for( int j=0; j< courierCar.getOrders().size(); j++ ) {

                Order order = courierCar.getOrders().get( j );
                int czas = 0;
                boolean flag = false;


                //przechodzę przez ścieżkę
                for( int l=0; l < path.size(); l++ ) {

                    City cityA = path.get( l );
                    //City cityB = path.get( l );

                    int indexCityA = map.getCityIndex( cityA );
                    //int indexCityB = map.getCityIndex( cityB );



                    //sprawdzam czy odebrano przesyłkę
                    if( order.getIndexA() == indexCityA ) {
                        flag = true;
                        komunikaty.push( new Komunikat( order, courierCar, "Odebrano", czas ) );
                    }

                    if( flag && order.getIndexB() == indexCityA ) {

                        komunikaty.push( new Komunikat( order, courierCar, "Dostarczono", czas ) );
                        break;
                    }

                    if ( l < path.size() - 1 )
                        czas += cityA.getWeight( map.getCityIndex( path.get( l+1 ) ) );

                }
            }
        }
    }

    public Komunikaty getKomunikaty() {
        return komunikaty;
    }
}
