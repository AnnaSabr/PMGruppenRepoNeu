
public class Mountainbike extends Bike {

    public Mountainbike(String productName, double price, int maxSpeed, int rearGearsCount, int frontGearsCount) {
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
        return super.rearGearsCount * super.frontGearsCount;
    }

    @Override
    public double getActionPrice(double price , int purchaseAmount) {
        if (purchaseAmount > 2) {
            price += purchaseAmount * super.price * 9 / 10;
        } else {
            price += purchaseAmount * super.price;
        }
        return price;
    }
}
