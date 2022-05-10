import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Ergänzen Sie UtilityTest so, dass alle Testmethoden grün werden.
// Die vorgegebenen Klassen dürfen nicht geändert werden.
// Die Testaufrufe müssen auch erhalten bleiben.
public class UtilityTest {
    private Utility utilityClass ;
    // Initialisieren Sie die Attribute entsprechend vor jedem Test.


    Evil evil;

    Utility utility;

    @Before
    public  void setUp(){
        evil= Mockito.spy(new Evil());
        utility= Mockito.spy(new Utility(evil));
        utilityClass= new Utility(new Evil());}

    @Test
    public void test_nonEvilAdd() {
        assertEquals(10, utility.nonEvilAdd(9, 1));
    }

    @Test
    public void test_evilAdd() {
        doNothing().when(evil).evilMethod();
        assertEquals(10, utility.evilAdd(9, 1));
    }

    @Test
    public void test_veryEvilAdd() {
        doNothing().when(utility).evilMethod();
        doNothing().when(evil).evilMethod();
        utility.veryEvilAdd(9, 1);
        assertEquals(10, utility.getIntResult());
    }
}
/*
1.projekt zu gradle projekt gemacht
2. build anhaengigkeiten in buildgradle fuer junit 4 und mockito geaendert(dependencies)
3. assertion rausgenommne und oben stadtessen importiert (vor asserEquals)
4. Test Methoden public gemacht
5. verhalten von evillMethod in beiden klassen mocken da die noch nicht fertig implemtiert sind und exptions werfen
6.-> deshlab mocks in zeile 17 erstellt
 */
