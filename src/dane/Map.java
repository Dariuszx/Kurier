package dane;


import java.util.ArrayList;

public class Map {

    private ArrayList<City> cityArrayList;

    public Map() {
        cityArrayList = new ArrayList<City>();
    }

    public void addCity( City city ) {
        cityArrayList.add( city );
    }

    public City getCity( int index ) {
        return cityArrayList.get( index );
    }

    public int getCityIndex( City city ) {

        for( int i=0; i < cityArrayList.size(); i++ ) {
            City tmp = cityArrayList.get(i);
            if( tmp != null )
                if( tmp.hashCode() == city.hashCode() )
                    return i;

        }

        return -1;
    }

    public void setNeighbour( int indexA, int indexB, int weight ) {

        cityArrayList.get( indexA ).setNeighbour( cityArrayList.get( indexB ), indexB, weight );
        cityArrayList.get( indexB ).setNeighbour( cityArrayList.get( indexA ), indexA, weight );
    }

    public int getSize() {
        return cityArrayList.size();
    }

}
