package dane;

public class City  {

    private String name;
    private NeighbourList neighbourList;

    public City( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public NeighbourList getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbour( City city, int index, int weight ) {

        NeighbourList n = new NeighbourList( city, index, weight );
        if( neighbourList == null ) neighbourList = n;
        else neighbourList.setNext( n );
    }

}