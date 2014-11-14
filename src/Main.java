import dane.Graf;
import exceptions.NotFoundException;
import exceptions.OutOfRange;

public class Main {

    public static void main( String[] args ) {

        Graf graf = new Graf<String>( 3 );

        try {

            graf.addNode( "Warszawa" );
            graf.addNode( "Stalowa Wola" );
            graf.addNode( "Kraków" );

            graf.addNeighbour( "Warszawa", "Stalowa Wola" );

        } catch ( OutOfRange outOfRange ) {
            outOfRange.printStackTrace();
        } catch ( NotFoundException e ) {
            e.printStackTrace();
        }


    }

}
