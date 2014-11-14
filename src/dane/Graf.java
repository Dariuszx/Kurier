package dane;


import exceptions.NotFoundException;
import java.util.HashMap;


public class Graf<T> {

    private HashMap<String, Node> listOfNeigbours;

    public Graf( ) {

        listOfNeigbours = new HashMap<String, Node>();
    }

    public void addNode( T value ) {

        listOfNeigbours.put( value.toString(), new Node( value ) );
    }

    public void addNeighbour( String source, String neighbour ) throws NotFoundException {

        addToNeighbourList( source, neighbour );
        addToNeighbourList( neighbour, source );

    }

    private void addToNeighbourList( String s, String n ) throws NotFoundException {

        Node tmp = getNode( s );

        while( tmp.hasNext() ) {

            tmp = tmp.getNext();
        }

        tmp.setNext( new Node( n ) );

    }

    public Node getNode( String id ) throws NotFoundException {

        Node tmp = listOfNeigbours.get( id );

        if( tmp == null ) throw new NotFoundException();

        return tmp;
    }

    public HashMap getHashOfNeighbours() { return listOfNeigbours; }

}
