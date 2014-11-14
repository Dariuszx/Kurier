package testy;


import dane.Graf;
import dane.Node;
import exceptions.NotFoundException;

import java.util.Iterator;
import java.util.Map;

public class TGraf {

    Graf graf;

    public TGraf( Graf graf ) {

        this.graf = graf;
    }

    public void wypisz() throws NotFoundException {

        System.out.println( "Rozpoczynam wypisywanie grafu" );

        Map listaKrawedzi = graf.getHashOfNeighbours();

        Iterator iterator = listaKrawedzi.entrySet().iterator();
        int index = 0;

        while( iterator.hasNext() ) {

            Map.Entry lista = (Map.Entry)iterator.next();

            lista.getValue();

            Node node = graf.getNode( lista.getKey().toString() );
            System.out.print( index++ + " " + node.getValue() + ": " );

            while ( node.hasNext() ) {
                node = node.getNext();
                System.out.print( node.getValue() + " " );
            }
            System.out.println();

            iterator.remove();
        }

    }

}
