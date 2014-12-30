package dane;


import dane.orders.Order;

public class KolejkaZamowien {

    private Order order;
    private City city;
    private int timeGet=0;
    private int timeDelivered=0;
    public int czyOdebrano = 0;

    public KolejkaZamowien( Order order, City city ) {
        this.order = order;
        this.city = city;
    }

    public Order getOrder() {
        return order;
    }

    public City getCity() {
        return city;
    }

    public int getTimeGet() {
        return timeGet;
    }

    public void setTimeGet(int timeGet) {
        this.timeGet = timeGet;
    }

    public int getTimeDelivered() {
        return timeDelivered;
    }

    public void setTimeDelivered(int timeDelivered) {
        this.timeDelivered = timeDelivered;
    }
}
