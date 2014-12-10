package dane;


import algorytmy.Dijkstry;
import dane.orders.ArrayOrders;
import dane.orders.Order;
import dane.orders.OrderQueue;
import exceptions.FileFormatException;

import java.io.*;

public class DataLoading {

    private String mapFileName = "";
    private String ordersFileName = "";
    private int numberOfCars = 2;
    private int numberOfMaxOrders = 10;
    private int startIndex;

    public DataLoading( String[] args ) throws Exception {

        if( args.length < 4 ) throw new Exception( "Wrong number of arguments" );
        parseArgs( args );
    }

    public void loadData( Map map, Data<CourierCar> courierCars, OrderQueue orderQueue, Data<Dijkstry> dijkstryData ) throws FileNotFoundException, FileFormatException, IOException {

        BufferedReader mapFile = new BufferedReader( new FileReader( mapFileName ) );
        BufferedReader ordersFile = new BufferedReader( new FileReader( ordersFileName ) );

        readMap( mapFile, map );
        readOrders( ordersFile, orderQueue );

        for( int i=0; i < numberOfCars; i++ )
            courierCars.add( new CourierCar( new ArrayOrders(), startIndex, i, numberOfMaxOrders ) );

        ((ArrayDijkstry)dijkstryData).generate( map );

    }

    private void readOrders( BufferedReader reader, OrderQueue orderQueue ) throws IOException, FileFormatException {

        String line = reader.readLine();

        try {
            startIndex = Integer.parseInt( line );
        } catch ( NumberFormatException e ) {
            throw new FileFormatException( "Wrong format of orders file" );
        }

        line = reader.readLine();

        while ( line != null && line.trim().length() != 0 ) {

            int id, indexA, indexB, prio;
            String name = "";

            String[] tmp = line.split( " " );

            if( tmp.length < 5 ) throw new FileFormatException( "Wrong format of orders file" );

            for( int i=3; i < tmp.length - 1; i++ )
                name = name + " " + tmp[i];

            try {
                id = Integer.parseInt( tmp[0] );
                indexA = Integer.parseInt( tmp[1] );
                indexB = Integer.parseInt( tmp[2] );
                prio = Integer.parseInt( tmp[ tmp.length -1 ] );
            } catch ( NumberFormatException e ) {
                throw new FileFormatException( "Wrong format of orders file." );
            }

            orderQueue.push( new Order( name, indexA, indexB, prio, id ) );
            line = reader.readLine();
        }
    }

    private void readMap( BufferedReader reader, Map map ) throws FileFormatException, IOException {

        String line = reader.readLine();

        while ( line != null ) {

            if( line.contains( "miasta" ) ) {
                loadCities(map, reader);
            }

            loadConnections(map, reader);

            line = reader.readLine();
        }
    }

    private void loadConnections( Map map, BufferedReader reader ) throws IOException, FileFormatException {

        String line = reader.readLine();

        while ( line != null && line.trim().length() != 0 ) {

            if( line.contains( "połączenia" ) ) line = reader.readLine();
            int A, B, prio;
            String[] tmp = line.split( " " );

            if( tmp.length < 3 ) throw new FileFormatException( "Wrong map file exception. Connections." );

            try {
                A = Integer.parseInt( tmp[0] );
                B = Integer.parseInt( tmp[1] );
                prio = Integer.parseInt( tmp[2] );

                if( A < 0 || B < 0 || prio <= 0 || prio > 100 || A >= map.getSize() || B >= map.getSize() )
                    throw new FileFormatException( "Wrong definied connection" );

                map.setNeighbour( A, B, prio );
                line = reader.readLine();

            } catch ( NumberFormatException e ) {
                throw new FileFormatException( "Wrong map file format. Connections." );
            }
        }
    }

    private void loadCities( Map map, BufferedReader reader ) throws IOException, FileFormatException {

        String line = reader.readLine();

        while ( line != null ) {

            int id;
            String nameOfCity = "";
            if ( line.contains( "połączenia") ) break;

            String[] tmp = line.split( " " );

            if ( tmp.length < 2 ) break;

            try {
                id = Integer.parseInt( tmp[0]);

                for( int i=1; i < tmp.length; i++ )
                    nameOfCity = nameOfCity + " " + tmp[i];

                if( id < 0 || nameOfCity.length() == 0 ) throw new FileFormatException( "Wrong format of map file" );

                map.addCity( new City( nameOfCity, id ) );

                line = reader.readLine();

            } catch (NumberFormatException e ) {
                throw new FileFormatException( "Wrong format of map file" );
            }
        }
    }

    private void parseArgs( String[] args ) throws Exception {

        for( int i=0; i < args.length; i++ ) {
            if( args[i].startsWith( "map" ) ) {
                mapFileName = returnValue( args[i] );
            }
            else if( args[i].startsWith( "orders" ) ) {
                ordersFileName = returnValue( args[i] );
            }
            else if ( args[i].startsWith( "ncars" ) ) {
                numberOfCars = Integer.parseInt( returnValue( args[i] ) );
                if ( numberOfCars <= 0 || numberOfCars > 99999 )
                    throw new Exception( "Wrong number od cars" );
            }
            else if( args[i].startsWith( "norders" ) ) {
                numberOfMaxOrders = Integer.parseInt( returnValue( args[i] ) );
                if ( numberOfMaxOrders <= 0 )
                    throw new Exception( "Wrong number od max orders value" );
            }
        }
        if( mapFileName.length() == 0 || ordersFileName.length() == 0 ) throw new Exception( "Map or orders file name not definied." );

    }

    private String returnValue( String arg ) throws Exception {

        String[] tmp = arg.split( "=" );
        if ( tmp.length != 2 ) throw new Exception( "Not allowed parameter" );
        return tmp[1];
    }

}
