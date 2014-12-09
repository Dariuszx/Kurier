package dane.orders;

public class Order {

    private String productName;
    private int indexA;
    private int indexB;

    private int priority;
    private int id;

    public Order(String productName, int indexA, int indexB, int priority, int id ) {

        this.productName = productName;
        this.indexA = indexA;
        this.indexB = indexB;
        this.priority = priority;
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public int getIndexA() {
        return indexA;
    }

    public int getIndexB() {
        return indexB;
    }

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }
}
