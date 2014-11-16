package dane;

public class NeighbourList {

    private City city;
    private NeighbourList next;
    private int index;

    public NeighbourList( City city, int index ) {
        this.city = city;
        this.index = index;
    }

    public boolean hasNext() {
        return next != null;
    }

    public City getCity() {
        return city;
    }

    public int getIndex() {
        return index;
    }

    public NeighbourList getNext() {
        return next;
    }

    public void setNext( NeighbourList n ) {

        if( next == null ) next = n;
        else {
            NeighbourList tmp = next;
            while ( tmp.hasNext() ) {
                tmp = tmp.getNext();
            }
            tmp.setNext( n );
        }
    }

}
