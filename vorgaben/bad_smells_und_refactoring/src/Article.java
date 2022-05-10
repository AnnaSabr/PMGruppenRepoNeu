public class Article {

    private Bike bike;
    private int purchaseAmount;

    public Article(Bike b, int pa) {
        bike = b;
        purchaseAmount = pa;
    }

    /**
     * Gibt die Produktanzahl zurück
     * @return Produktanzahl
     */
    public int getPurchaseAmount() {
        return this.purchaseAmount;
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
     * Gibt den Pruduktnamen zurück
     * @return Produktname
     */
    public String getProductName() {
        return this.bike.getProductName();
    }

}
