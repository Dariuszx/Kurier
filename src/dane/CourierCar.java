package dane;

import dane.orders.Order;

public class CourierCar {

    private Data<Order> orders;
    private int maxOrders;
    private int id;

    private int indexOfLastCity = -1;
    private int indexOfStartPossition = -1;

    private Data<City> path;

    public CourierCar( Data<Order> orders, int indexOfStartPossition, int id, int maxOrders ) {

        this.orders = orders;
        this.maxOrders = maxOrders;
        this.indexOfStartPossition = indexOfStartPossition;
        this.id = id;
        this.path = new ArrayPath();
    }

    public void addOrder( Order order ) {

        orders.add( order );
    }

    public boolean isSpace() { return orders.size() < maxOrders; }

    public Data<Order> getOrders() {
        return orders;
    }

    public void setIndexOfLastCity(int indexOfLastCity) {
        this.indexOfLastCity = indexOfLastCity;
    }

    public int getIndexOfStartPossition() {
        return indexOfStartPossition;
    }

    public Data<City> getPath() {
        return path;
    }

    public void addPath( Data<City> path ) {

        for( int i=0; i < path.size(); i++ ) {
            this.path.add( path.get(i) );
        }

    }

    public void setAlghoritmPath( Data<City> path ) {
        this.path = path;
    }

    public int getId() {
        return id;
    }
}
