package dane.orders;


import dane.Data;

import java.util.ArrayList;

public class ArrayOrders implements Data<Order> {

    private ArrayList<Order> orders = new ArrayList<Order>();

    @Override
    public void add(Order data) {
        orders.add( data );
    }

    @Override
    public int size() {
        return orders.size();
    }

    @Override
    public Order get(int index) {
        return orders.get( index );
    }

    @Override
    public Order get(Order data) {
        return null;
    }

    @Override
    public void set(int index, Order city) {

    }
}
