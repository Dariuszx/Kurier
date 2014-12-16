package dane.orders;


public class CourierOrder {

    private Order order;
    private int czas;
    private int status;
    private int cityIndex;

    public CourierOrder( Order order ) {
        this.order = order;
        this.czas = czas;
        this.status = status;
        this.cityIndex = cityIndex;
    }

    public int getCzas() {
        return czas;
    }

    public Order getOrder() {
        return order;
    }

    public int getStatus() {
        return status;
    }

    public int getCityIndex() {
        return cityIndex;
    }
}
