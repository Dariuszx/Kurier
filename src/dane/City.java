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

    public int getWeight( int index) {

        NeighbourList tmp = neighbourList;

        while ( tmp != null ) {
            if ( tmp.getIndex() == index ) {
                return tmp.getWeight();
            }
            tmp = tmp.getNext();
        }

        return 0;
    }

    @Override
    public int hashCode() {

        String hash = name;
        NeighbourList tmp = neighbourList;

        while( tmp != null ) {
            hash += "" + tmp.getCity().getName();
            tmp = tmp.getNext();
        }

        return hash.hashCode();
    }

    @Override
    public boolean equals( Object obj ) {

        if( obj instanceof City && obj.hashCode() == this.hashCode() ) {
            return true;
        }
        return false;
    }

}