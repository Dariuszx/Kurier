package dane;

public class City  {

    private String name;
    private int index;
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

    public void changeWeight( int priority ) {
        //TODO muszę wymyśleć jak przeskalować wagi czasów dojścia dla sąsiadów
        //TODO w zależności od priorytetu zlecenia, które jest zaadresowane na to miasto
    }

    public void setIndex( int i ) {
        index = i;
    }

    public int getIndex() {
        return index;
    }
}