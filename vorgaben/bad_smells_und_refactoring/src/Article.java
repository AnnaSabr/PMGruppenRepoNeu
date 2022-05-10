public class Article {

    private Bike bike;
    private int purchaseAmount;

    public Article(Bike b, int pa) {
        bike = b;
        purchaseAmount = pa;
    }

    /**
     * Berechnet den Aktionspreis und gibt diesen zurück
     * @return Aktionspreis
     */
    public double getActionPrice() {
        double price = this.bike.getActionPrice(this.purchaseAmount);
        if (price > 1000f || price == 1000.0) {
            price = price * 0.8;
        }
        return price;
    }

    /**
     * Gibt einen String mit den Details des Produktes
     * @return Details
     */
    public String getDetails() {
        return "\t" + this.bike.getProductName() + "\tx\t" + this.purchaseAmount + "\t=\t" + String.valueOf(this.getActionPrice()) + "\n";
    }
}
