
public class EBike extends Bike {

    public EBike(String productName, double price, int maxSpeed, int rearGearsCount, int frontGearsCount, int batteryCapacity) {
        super.productName = productName;
        super.price = price;
        super.maxSpeed = maxSpeed;
        super.rearGearsCount = rearGearsCount;
        super.frontGearsCount = frontGearsCount;
        super.batteryCapacity = batteryCapacity;
    }

    @Override
    public int getGearsCount() {
        return rearGearsCount * frontGearsCount;
    }

    @Override
    public double getActionPrice(double price , int purchaseAmount) {
        price += purchaseAmount * super.price; 
        return price;
    }
}
