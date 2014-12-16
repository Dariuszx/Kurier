package dane.orders;


import dane.Data;

import java.util.ArrayList;

public class CourierOrderQueue implements Data<CourierOrder> {

    private ArrayList<CourierOrder> orders = new ArrayList<CourierOrder>();


    public CourierOrder getLast() {
        if ( orders.size() == 0 ) return null;
        else return orders.get(orders.size() - 1);
    }

    @Override
    public void add(CourierOrder data) {
        orders.add(data);
    }

    @Override
    public int size() {
        return orders.size();
    }

    @Override
    public CourierOrder get(int index) {
        return orders.get(index);
    }

    @Override
    public CourierOrder get(CourierOrder data) {
        return null;
    }

    @Override
    public void set(int index, CourierOrder city) {

    }

    @Override
    public CourierOrder pop(int index) {
        return null;
    }
}
