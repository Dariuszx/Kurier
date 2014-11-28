package dane;


import java.util.ArrayList;

public class Map {

    private ArrayList<City> cityArrayList;

    public Map() {
        cityArrayList = new ArrayList<City>();
    }

    public void addCity( City city ) {
        city.setIndex( cityArrayList.size() );
        cityArrayList.add( city );
    }

    public City getCity( int index ) {
        return cityArrayList.get( index );
    }

    public void setNeighbour( int indexA, int indexB, int weight ) {

        cityArrayList.get( indexA ).setNeighbour( cityArrayList.get( indexB ), indexB, weight );
        cityArrayList.get( indexB ).setNeighbour( cityArrayList.get( indexA ), indexA, weight );
    }

    public int getSize() {
        return cityArrayList.size();
    }

    public int getCityIndex( City city ) {


    }

}
