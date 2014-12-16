package dane;

import java.util.ArrayList;


public class ArrayCourierCars implements Data<CourierCar> {

    private ArrayList<CourierCar> courierCars = new ArrayList<CourierCar>();

    @Override
    public void add(CourierCar data) {

        data.setAlghoritmPath( new ArrayPath() );
        courierCars.add( data );
    }

    @Override
    public int size() {
        return courierCars.size();
    }

    @Override
    public CourierCar get(int index) {
        return courierCars.get( index );
    }

    @Override
    public CourierCar get(CourierCar data) {
        return null;
    }

    @Override
    public void set(int index, CourierCar city) {

    }

    @Override
    public CourierCar pop(int index) {
        return null;
    }
}
