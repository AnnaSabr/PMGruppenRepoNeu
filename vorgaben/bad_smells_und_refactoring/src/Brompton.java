
public class Brompton extends Bike {

    public Brompton(String productName, double price, int maxSpeed, int rearGearsCount, int frontGearsCount) {
        super.productName = productName;
        super.price = price;
        super.maxSpeed = maxSpeed;
        super.rearGearsCount = rearGearsCount;
        super.frontGearsCount = frontGearsCount;
    }

    @Override
    public Integer getBatteryCapacity() {
        return null;
    }

    @Override
    public int getGearsCount() {
        return rearGearsCount * frontGearsCount;
    }

    @Override
    public double getActionPrice(int purchaseAmount) {
        double price = 0.0;
        if (purchaseAmount > 1) {
            price = (purchaseAmount - 1) * super.price / 2;
        }
        price += purchaseAmount * super.price;
        return price;
    }
}
