
public class Bike {

    protected String productName;
    protected double price;
    public Integer batteryCapacity;
    protected int maxSpeed;
    protected int rearGearsCount;
    protected int frontGearsCount;

    public String getProductName() {
        return this.productName;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getGearsCount() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public double getActionPrice(double price , int purchaseAmount) {
        return price;
    }
}
