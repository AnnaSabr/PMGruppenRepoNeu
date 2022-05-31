
public abstract class Drucker {

    public void kopieren(){
        scannen();
        drucken();
    }

    public abstract void scannen();

    public abstract void drucken();
}
