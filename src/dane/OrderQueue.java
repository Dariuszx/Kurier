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

    public boolean isset( Order tmp ) {

         Queue<Order> h = head;

            while( h != null ) {

                Order orderTmp = h.getValue();
                if( tmp.getId() == orderTmp.getId() ) {
                    return true;
                }

                h = h.getNext();
            }
        return false;
    }

    public void delete( Order tmp ) {

        OrderQueue orderQueue = new OrderQueue();

        while( head != null ) {
            if( head.getValue().getId() != tmp.getId() )
                orderQueue.push( head.getValue() );
            head = head.getNext();
        }

        head = orderQueue.head;
        tail = orderQueue.tail;
    }

    public OrderQueue getQueueByPath( Map map, PathToCity path ) {

        OrderQueue queue = new OrderQueue();

        for( int i=0; i < path.getPath().size(); i++ ) {

            City tmp = path.getPath().get(i);
            int index = map.getCityIndex( tmp );
            Queue<Order> h = head;

            while( h != null ) {

                Order orderTmp = h.getValue();
                boolean flag = false;

                if( orderTmp.getIndexB() == index || orderTmp.getIndexA() == index ) {

                    for( int j=0; j < path.getPath().size(); j++ ) {
                        if (map.getCityIndex(path.getPath().get(i)) == orderTmp.getIndexA()) {
                            flag = true;
                            break;
                        }
                    }

                    if( flag ) {
                        queue.push(orderTmp);
                        delete(orderTmp);
                    }
                }

                h = h.getNext();
            }

        }

        return queue;

    }

}
