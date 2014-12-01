package dane;


import java.util.ArrayList;

public class ArrayPath implements Data<City> {

    private ArrayList<City> path = new ArrayList<City>();

    @Override
    public void add(City city) {
        path.add( city );
    }

    @Override
    public int size() {
        return path.size();
    }

    @Override
    public City get(int index) {
        return path.get( index );
    }

    @Override
    public City get(City city) {

        for( int i=0; i < path.size(); i++ ) {
            if( path.get(i).equals( city ) ) return path.get(i);
        }
        return null;

    }

    @Override
    public void set( int index, City city ) {
        path.set( index, city );
    }
}
