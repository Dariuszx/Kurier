import dane.Graf;
import exceptions.NotFoundException;
import exceptions.OutOfRange;
import testy.TGraf;

public class Main {

    public static void main( String[] args ) {

        Graf graf = new Graf<String>();

        try {

            graf.addNode( "Warszawa" );
            graf.addNode( "Stalowa Wola" );
            graf.addNode( "Kraków" );
            graf.addNode( "Poznań" );

            graf.addNeighbour( "Warszawa", "Stalowa Wola" );
            graf.addNeighbour( "Warszawa", "Kraków" );
            graf.addNeighbour( "Warszawa", "Poznań" );
            graf.addNeighbour( "Stalowa Wola", "Kraków" );


            new TGraf( graf ).wypisz();


        } catch ( NotFoundException e ) {
            e.printStackTrace();
        }


    }

}
