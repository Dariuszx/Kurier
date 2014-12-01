package dane;

public interface Data<T> {

    public void add( T city );

    public int size();

    public T get( int index );

    public T get( T city );

    public void set( int index, T city );

}
