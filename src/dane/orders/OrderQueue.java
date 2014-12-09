package dane.orders;

import dane.*;

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

    public static OrderQueue getOrdersByPath( OrderQueue orderQueue, Data<City> pathToCity, CourierCar courierCar, Map map ) {

        OrderQueue tmp = new OrderQueue();

        while ( !orderQueue.empty() ) {

            Order order = orderQueue.pop();

            //Sprawdzam czy mogę po drodze zabrać przesyłkę i ją dostarczyć gdzieś
            if( pathToCity.get( map.getCity( order.getIndexA() ) ) != null && pathToCity.get( map.getCity( order.getIndexB() )) != null )
            {
                courierCar.addOrder( order );
            }
            else
            {
                tmp.push( order );
            }
        }

        courierCar.addPath( pathToCity );

        return tmp;
    }

}
