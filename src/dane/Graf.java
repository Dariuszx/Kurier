package dane;


import exceptions.NotFoundException;
import exceptions.OutOfRange;

import java.util.ArrayList;



public class Graf<T> {

    private ArrayList<Node> listaSasiedztwa;
    private int lenght;

    public Graf( int n ) {

        listaSasiedztwa = new ArrayList<Node>( n );
        lenght = n;
    }

    public void addNode( T value ) throws OutOfRange {

        if( listaSasiedztwa.size() >= lenght ) throw new OutOfRange( "Poza zakres kolejki sąsiedztwa." );

        Node node =  new Node( value );

        listaSasiedztwa.add( node );
    }

    public void addNeighbour( String idWezla, String idSasiada ) throws NotFoundException {

        Node tmp = getNode( idWezla );

        while( tmp.hasNext() ) {

            tmp = tmp.getNext();
        }

        tmp = getNode( idSasiada );

    }

    public Node getNode( int i ) throws OutOfRange {

        if( i >= listaSasiedztwa.size() ) throw new OutOfRange();

        return listaSasiedztwa.get( i );
    }

    public Node getNode( String id ) throws NotFoundException {

        for( int i=0; i < listaSasiedztwa.size(); i++ ) {

            Node tmp = listaSasiedztwa.get( i );

            if( tmp.getValue().toString().equals( id ) )
                return tmp;
        }

        throw new NotFoundException();

    }

}
