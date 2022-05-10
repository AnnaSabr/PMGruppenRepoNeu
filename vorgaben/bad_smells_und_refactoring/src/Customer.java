import java.util.Date;

public class Customer {
    private String customerName;
    private String nickname;
    private Date birthday;
    private String email;

    public Customer(String customerName, String nickname, Date birthday, String email) {
        this.customerName = customerName;
        this.nickname = nickname;
        this.birthday = birthday;
        this.email = email;
    }
    
    /**
     * Gibt den Namen des Kunden zurück
     * @return Name des Kunden
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * Gibt den Benutzernamen des Kunden zurück
     * @return Benutzername des Kunden
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Gibt das Datum des Geburtstages des Kunden zurück
     * @return Datum des Geburtstages des Kunden
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * Gibt die Email Adresse des Kunden zurück
     * @return Email Adresse des Kunden
     */
    public String getEmail() {
        return this.email;
    }
}
