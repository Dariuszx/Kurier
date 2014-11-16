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

    public void setNeighbour( int indexA, int indexB ) {

        cityArrayList.get( indexA ).setNeighbour( cityArrayList.get( indexB ), indexB  );
        cityArrayList.get( indexB ).setNeighbour( cityArrayList.get( indexA ), indexA  );
    }

    public int getSize() {
        return cityArrayList.size();
    }

}
