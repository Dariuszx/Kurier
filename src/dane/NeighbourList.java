package dane;

public class NeighbourList {

    private City city; //Obiekt miasta
    private int weight;
    private NeighbourList next; //Wskaźnik na następnego sąsiada
    private int index; //Indeks miasta w tablicy wszystkich miast

    public NeighbourList( City city, int index, int weight ) {
        this.city = city;
        this.index = index;
        this.weight = weight;
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

    public int getWeight() {
        return weight;
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
