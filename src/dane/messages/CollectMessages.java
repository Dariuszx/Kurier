package dane.messages;


import algorytmy.Dijkstry;
import dane.*;

public class CollectMessages {

    private Komunikaty komunikaty;

    public CollectMessages( Map map, Data<CourierCar> courierCars, Data<Dijkstry> dijkstry ) {

        komunikaty = new Komunikaty();

        //przeglądam smaochody
        for( int i=0; i < courierCars.size(); i++ ) {

            CourierCar courierCar = courierCars.get( i );
            Data<City> path = courierCar.getPath();

            //przeglądam zlecenia w samochodach do realizacji
            for( int j=0; i < courierCar.getOrders().size(); i++ ) {



            }

        }
    }
}
