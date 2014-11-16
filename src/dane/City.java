package dane;

public class City  {

    private String name;
    private int weight;
    private NeighbourList neighbourList;

    public City( String name, int weight ) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public NeighbourList getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbour( City city, int index ) {

        NeighbourList n = new NeighbourList( city, index );
        if( neighbourList == null ) neighbourList = n;
        else neighbourList.setNext( n );
    }

}