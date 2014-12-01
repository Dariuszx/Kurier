package dane;


public class OrderQueue {

    private Queue<Order> head;
    private Queue<Order> tail;


    public OrderQueue() {
        head = tail = null;
    }

    public void push( Order o ) {

        Queue order = new Queue<Order>( o );

        if( head == null ) {
            head = tail = order;
        }
        else if ( head.getPriority() < order.getPriority() ) {
            order.setNext( head );
            head = order;
        }
        else {
            Queue tmp = head;

            while( (tmp.getNext() != null) && (tmp.getNext().getPriority() >= order.getPriority() ) ) {
                tmp = tmp.getNext();
            }

            order.setNext( tmp.getNext() );
            tmp.setNext( order );

            if( order.getNext() == null ) tail = order;
        }
    }

    public Order pop() {

        if( head != null ) {
            Queue<Order> tmp = head;
            head = head.getNext();

            if( head == null ) tail = null;
            return tmp.getValue();
        }
        return null;
    }

    public boolean empty() {
        return head == null;
    }

    public Order front() {

        if( head != null ) return head.getValue();
        else return null;
        
    }


}
