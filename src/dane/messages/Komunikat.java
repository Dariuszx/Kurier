package dane.messages;


import dane.orders.Order;

public class Komunikat {

    private Order order;
    private String komunikat;
    private int czas;

    public Komunikat( Order o, String k, int t ) {

        order = o;
        komunikat = k;
        czas = t;
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
}
