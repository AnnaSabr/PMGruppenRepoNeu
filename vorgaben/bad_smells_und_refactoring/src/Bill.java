import java.util.ArrayList;
import java.util.Date;

public class Bill {

    private Customer customer;
    private String street;
    private String streetNumber;
    private int postalCode;
    private String city;
    private ArrayList<Article> articles;

    /**
     * Ezeigt ein Oject vom Typ Bill welches eine Rechnung representiert
     * @param customer gibt den Kunden an
     * @param street gibt die Strasse in der Anschrift an
     * @param streetNumber gibt die Hausnummer in der Aschrift an
     * @param postalCode gibt die Postleitzahl in der Anschrift an
     * @param city gibt die Stadt in der Anschrift an
     */
    public Bill(Customer customer, String street, String streetNumber, int postalCode, String city) {
        this.customer = customer;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.articles = new ArrayList<Article>();
    }

    /**
     * Gibt den Namen des Kunden zurück
     * @return Name des Kunden
     */
    public String getCustomerName() {
        return this.customer.getCustomerName();
    }

    /**
     * Gibt den Benutzernamen des Kunden zurück
     * @return Benutzername des Kunden
     */
    public String getNickname() {
        return this.customer.getNickname();
    }

    /**
     * Gibt den Strassennamen der Anschrift des Kunden zurück
     * @return Strassenname der Anschrift des Kunden
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * Gibt die Hausnummer der Anschrift des Kunden zurück
     * @return Hausnummer der Anschrift des Kunden
     */
    public String getStreetNumber() {
        return this.streetNumber;
    }

    /**
     * Gibt die Postleitzahl der Anschrift des Kunden zurück
     * @return Postleitzahl der Anschrift des Kunden
     */
    public int getPostalCode() {
        return this.postalCode;
    }

    /**
     * Gibt das Datum des Geburtstages des Kunden zurück
     * @return Datum des Geburtstages des Kunden
     */
    public Date getBirthday() {
        return this.customer.getBirthday();
    }

    /**
     * Gibt die Email Adresse des Kunden zurück
     * @return Email Adresse des Kunden
     */
    public String getEmail() {
        return this.customer.getEmail();
    }

    /**
     * Gibt den Namen der Stadt der Anschrift zurück
     * @return Namen der Stadt der Anschrift
     */
    public String getCity() {
        return this.city;
    }

    public boolean addArticle(Article a) {
        return this.articles.add(a);
    }

    private String getCustomerDetails() {
        String result = "Details for \"" + this.getCustomerName() + "\"\n";
        result += street + " " + streetNumber + "\n";
        result += postalCode + " " + city + "\n";
        result += "Geburtstag: " + this.getBirthday() + "\n";
        result += "Email: " + this.getEmail() + "\n\n";
        return result;
    }

    
    /**
     * Gibt den Gesammtpreis zurück
     * @return Gesammtpreis
     */
    public double getTotalPrice() {
        double total = 0.0;
        for(Article article : this.articles) {
            total += article.getActionPrice();
        }
        return total;
    }

    public String getDetails() {
        String result = getCustomerDetails();
        result += "Article: \n";
        for (Article article : this.articles) {
            result += article.getDetails();
        }
        result += "\nTotal price:\t" + String.valueOf(this.getTotalPrice()) + "\n";
        return result;
    }
}
