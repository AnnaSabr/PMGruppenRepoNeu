
public class Bike {

    protected String productName;
    protected double price;
    protected Integer batteryCapacity;
    protected int maxSpeed;
    protected int rearGearsCount;
    protected int frontGearsCount;

    /**
     * Gibt den Produktnamen zurück
     * @return Produktname
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Gibt die Batteriekapazitaet zurück
     * @return Batteriekapazitaet
     */
    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    /**
     * Gibt die Maximalgeschwindichkeit zurück
     * @return Maximalgeschwindichkeit
     */
    public int getMaxSpeed() {
        return this.maxSpeed;
    }
    
    /**
     * Gibt die Anzahl der Gaenge zurück
     * @return Anzahl der Gaenge
     */
    public int getGearsCount() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    /**
     * Berechnet den Aktionspreis und gibt diesen zurück
     * @param purchaseAmount gibt die Anzahl an
     * @return Aktionspreis
     */
    public double getActionPrice(int purchaseAmount) {
        return purchaseAmount * this.price;
    }
}
