package dane.messages;


import algorytmy.Dijkstry;
import dane.*;
import dane.orders.Order;

public class CollectMessages {

    private Komunikaty komunikaty;

    public CollectMessages() {
        komunikaty = new Komunikaty();
    }

    public void collect( Map map, Data<CourierCar> courierCars, Data<Dijkstry> dijkstry ) {

        //przeglądam samochody
        for( int i=0; i < courierCars.size(); i++ ) {

            CourierCar courierCar = courierCars.get( i );
            int czas = 0;

            Data<City> path = courierCar.getPath();

            for( int j=0; j < path.size(); j++ ) {

                City city = path.get(j);

                Data<Order> orders = courierCar.getOrders();

                for( int k=0; k < orders.size(); k++ ) {

                    int cityIndex = map.getCityIndex( city );
                    Order order = orders.get( k );

                    if( cityIndex == order.getIndexA() ) {
                        komunikaty.push( new Komunikat( order, courierCar, "Odebrano", czas ) );
                    } else if( cityIndex == order.getIndexB() ) {
                        komunikaty.push( new Komunikat( order, courierCar, "Dostarczono", czas ) );
                    }
                }

            }

            /*
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

                        //System.out.println( "Samochod=" + courierCar.getId() + " zdejmuje z listy " + order.getId() + " wielkosc Orders=" + courierCar.getOrders().size() );

                        komunikaty.push( new Komunikat( courierCar.getOrders().get(j), courierCar, "Dostarczono", czas ) );
                        break;
                    }

                    if ( l < path.size() - 1 )
                        czas += cityA.getWeight( map.getCityIndex( path.get( l+1 ) ) );
                }

                //courierCar.setCzas( czas );
            }

        */
        }
    }

    public Komunikaty getKomunikaty() {
        return komunikaty;
    }
}
