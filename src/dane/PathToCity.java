package dane;

public class PathToCity {

    private Data<City> path;

    private boolean flag = false;

    public PathToCity( Data path ) {

        this.path = path;
    }

    public boolean issetOnPath( City cityB ) {

        for( int i=0; i < path.size(); i++ ) {

            if( path.get( i ).hashCode() == cityB.hashCode() ) {
                return true;
            }
        }
        return false;
    }

    public void begin() { flag = true; }

    public void addCity( City city ) {

        if( !flag ) return;
        path.add( city );
    }

    public void end() {

        flag = false;

        City tmp;

        for( int i=0; i < path.size() / 2; i++ ) {

            tmp = path.get( i );
            path.set( i, path.get( path.size() - i -1 ));
            path.set( path.size() -i - 1, tmp );
        }

    }

    public Data<City> getPath() {
        return path;
    }
}
