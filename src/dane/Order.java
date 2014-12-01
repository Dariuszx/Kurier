package dane;

public class Order {

    private String productName;
    private int indexA;
    private int indexB;

    private int priority;

    public Order(String productName, int indexA, int indexB, int priority) {

        this.productName = productName;
        this.indexA = indexA;
        this.indexB = indexB;
        this.priority = priority;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getIndexA() {
        return indexA;
    }

    public void setIndexA(int indexA) {
        this.indexA = indexA;
    }

    public int getIndexB() {
        return indexB;
    }

    public void setIndexB(int indexB) {
        this.indexB = indexB;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
