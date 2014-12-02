package dane;


import dane.orders.Order;

public class CourierCar {

    private Data<Order> orders;
    private int maxOrders;


    public CourierCar( Data<Order> orders ) {

        this.orders = orders;
    }

    public void addOrder( Order order ) {
        orders.add( order );
    }

    public Data<Order> getOrders() {
        return orders;
    }

    public int getMaxOrders() {
        return maxOrders;
    }

    public void setMaxOrders(int maxOrders) {
        this.maxOrders = maxOrders;
    }

}
