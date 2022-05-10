public class Article {

    private Bike bike;
    private int purchaseAmount;

    public Article(Bike b, int pa) {
        bike = b;
        purchaseAmount = pa;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public double getActionPrice(double price) {
        price = this.bike.getActionPrice(price, this.purchaseAmount);
        if (price > 1000f || price == 1000.0) {
            price = price * 0.8;
        }
        return price;
    }

    public String getProductName() {
        return this.bike.getProductName();
    }

}
