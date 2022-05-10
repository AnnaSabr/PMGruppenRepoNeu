import org.junit.Test;
import static org.junit.Assert.*;

public class BromptonTest {

    /**
    * Test der Rückgabe von MaxSpeed
    */
    @Test
    public void testGetMaxSpeed() {
        String productName = "EBike";
        int price = 100;
        int maxSpeed = 30;
        int rearGearsCount = 1;
        int frontGearsCount = 1;
        Brompton bike = new Brompton(productName, price, maxSpeed, rearGearsCount, frontGearsCount);
        assertTrue(bike.getMaxSpeed() == maxSpeed);
    }

    /**
     * Test der Rückgabe der Schaltung
     */
    @Test
    public void testGetGearsCount() {
        String productName = "EBike";
        int price = 100;
        int maxSpeed = 30;
        int rearGearsCount = 1;
        int frontGearsCount = 1;
        Brompton bike = new Brompton(productName, price, maxSpeed, rearGearsCount, frontGearsCount);
        assertTrue(bike.getGearsCount() == rearGearsCount * frontGearsCount);
    }
    
}
