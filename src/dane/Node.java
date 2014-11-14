package dane;

public class Node<T> {

    private T value;
    private Node<T> next;


    public Node( T value ) {
        this.value = value;
    }

    public Node( T value, Node next ) {
        this.value = value;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext( Node next ) {
        this.next = next;
    }

    public void setValue( T value ) {
        this.value = value;
    }

    public boolean hasNext() {
        if( next == null ) return false;
        else return true;
    }
}