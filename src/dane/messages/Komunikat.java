package dane.messages;


import dane.CourierCar;
import dane.orders.Order;

public class Komunikat {

    private Order order;
    private String komunikat;
    private int czas;
    private CourierCar courierCar;

    public Komunikat( Order o, CourierCar courierCar, String k, int t ) {

        order = o;
        komunikat = k;
        czas = t;
        this.courierCar = courierCar;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getKomunikat() {
        return komunikat;
    }

    public void setKomunikat(String komunikat) {
        this.komunikat = komunikat;
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }

    public CourierCar getCourierCar() {
        return courierCar;
    }
}
