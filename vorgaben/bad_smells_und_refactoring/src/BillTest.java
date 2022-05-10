import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;

public class BillTest {
    
    private String customerName;
    private String nickname;
    private Date birthday;
    private String email;
    private String street;
    private String streetNumber;
    private int postalCode;
    private String city;
    private Customer customer;
    private Bill bill;

    @Before
    public void init() {
        this.customerName = "George";
        this.nickname = "George from the Jungle";
        this.birthday = new Date(0);
        this.email = "George@Jungle.com";
        this.street = "Big Tree";
        this.streetNumber = "1";
        this.postalCode = 111111;
        this.city = "BigCity";
        this.customer = new Customer(this.customerName, this.nickname, this.birthday, this.email);
        this.bill = new Bill(this.customer, this.street, this.streetNumber, this.postalCode, this.city);
    }
    
    /**
     * Test der Übergabeparameter im Konstruktor
     */
    @Test
    public void testKonstrictor() {
        assertTrue(this.bill.getCustomerName().equals(this.customerName) &&
                    this.bill.getNickname().equals(this.nickname) &&
                    this.bill.getBirthday().equals(this.birthday) &&
                    this.bill.getEmail().equals(this.email) &&
                    this.bill.getStreet().equals(this.street) &&
                    this.bill.getStreetNumber().equals(this.streetNumber) &&
                    this.bill.getPostalCode() == this.postalCode &&
                    this.bill.getCity().equals(this.city));
    }

    /**
     * Test des Ausgabe in ein String mit keinen Artikeln
     */
    @Test
    public void testGetDetailsEmpty() {
        double price = 0.0;
        String result = "Details for \"" + this.customerName + "\"\n";
        result += this.street + " " + this.streetNumber + "\n";
        result += this.postalCode + " " + this.city + "\n";
        result += "Geburtstag: " + this.birthday + "\n";
        result += "Email: " + this.email + "\n\n";
        result += "Article: \n";
        result += "\nTotal price:\t" + String.valueOf(price) + "\n";
        assertTrue(this.bill.getDetails().equals(result));
    }

    /**
     * Testet die Berechnung des Gesamtpreises
     */
    @Test
    public void testGetTotalPrice() {
        
    }
}
