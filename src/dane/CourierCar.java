package dane;


import dane.orders.Order;



public class CourierCar {

    private Data<Order> orders;
    private int maxOrders;
    private int id;

    private int indexOfLastCity;
    private int indexOfStartPossition;

    private Data<City> path;

    public CourierCar( Data<Order> orders, int indexOfStartPossition, int id ) {

        this.orders = orders;
        this.indexOfStartPossition = indexOfStartPossition;
        this.id = id;
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

    public int getIndexOfLastCity() {
        return indexOfLastCity;
    }

    public void setIndexOfLastCity(int indexOfLastCity) {
        this.indexOfLastCity = indexOfLastCity;
    }

    public int getIndexOfStartPossition() {
        return indexOfStartPossition;
    }

    public void setIndexOfStartPossition(int indexOfStartPossition) {
        this.indexOfStartPossition = indexOfStartPossition;
    }

    public Data<City> getPath() {
        return path;
    }

    public void setAlghoritmPath( Data<City> path ) {
        this.path = path;
    }

    public int getId() {
        return id;
    }
}
