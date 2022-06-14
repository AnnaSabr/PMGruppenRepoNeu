import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankTestParameterized {

    private Kunde kunde;
    private float ergebnis;
    private float genauigkeit;

    public BankTestParameterized(Kunde kunde, float ergebnis){
        this.genauigkeit=0.000001f;
        this.kunde=kunde;
        this.ergebnis=ergebnis;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> values(){
        return Arrays.asList(new Object[][]{{new Kunde("Berta",50,50),1.0f},
            {new Kunde("Helga",50,150),3.0f},
            {new Kunde("Isolde",50,1500),5.0f},
            {new Kunde("Barley",4,50),1.5f},
            {new Kunde("Bob",4,150),3.5f},
            {new Kunde("Boris",4,1500),5.5f},
            {new Kunde("Sophie",69,50),2.0f},
            {new Kunde("Ria",69,150),4.0f},
            {new Kunde("Lena",69,1500),6.0f},
        });
    }

    @Test
    public void alleGueltigen(){
        Bank bank = new Bank();
        assertEquals(bank.gesamtZinssatz(kunde),ergebnis,genauigkeit);
    }

}
