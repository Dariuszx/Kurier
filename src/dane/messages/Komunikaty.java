package dane.messages;

import dane.orders.*;


public class Komunikaty {

    private Queue<Komunikat> head;
    private Queue<Komunikat> tail;


    public Komunikaty() {
        head = tail = null;
    }

    public void push( Komunikat k ) {

        Queue komunikat = new Queue<Komunikat>( k );

        if( head == null ) {
            head = tail = komunikat;
        }
        else if ( head.getPriority() > komunikat.getPriority() ) {
            komunikat.setNext( head );
            head = komunikat;
        }
        else {
            Queue tmp = head;

            while( (tmp.getNext() != null) && (tmp.getNext().getPriority() <= komunikat.getPriority() ) ) {
                tmp = tmp.getNext();
            }

            komunikat.setNext( tmp.getNext() );
            tmp.setNext( komunikat );

            if( komunikat.getNext() == null ) tail = komunikat;
        }
    }

    public Komunikat pop() {

        if( head != null ) {
            Queue<Komunikat> tmp = head;
            head = head.getNext();

            if( head == null ) tail = null;
            return tmp.getValue();
        }
        return null;
    }

    public boolean empty() {
        return head == null;
    }

}
