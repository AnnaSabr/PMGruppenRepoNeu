import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



public class BankTest {
    private Bank bank;


    @Before
    public void setUp(){
        this.bank = new Bank();
    }


    @Test
    public void aKGuthaben1(){
        Kunde kunde = new Kunde("Otto",50,50);
        assertEquals(bank.gesamtZinssatz(kunde),1.0f,0.000001f);
    }
    @Test
    public void aKGuthaben2(){
        Kunde kunde = new Kunde("Otto",50,500);
        assertEquals(bank.gesamtZinssatz(kunde),3.0f,0.000001f);
    }
    @Test
    public void aKGuthaben3(){
        Kunde kunde = new Kunde("Otto",50,5000);
        assertEquals(bank.gesamtZinssatz(kunde),5.0f,0.000001f);
    }


    @Test
    public void gWGuthaben1(){
        Kunde kunde = new Kunde("Otto",50,1);
        assertEquals(bank.gesamtZinssatz(kunde),1.0f,0.000001f);
    }
    @Test
    public void gWGuthaben2(){
        Kunde kunde = new Kunde("Otto",50,100);
        assertEquals(bank.gesamtZinssatz(kunde),1.0f,0.000001f);
    }
    @Test
    public void gWGuthaben3(){
        Kunde kunde = new Kunde("Otto",50,101);
        assertEquals(bank.gesamtZinssatz(kunde),3.0f,0.000001f);
    }
    @Test
    public void gWGuthaben4(){
        Kunde kunde = new Kunde("Otto",50,1000);
        assertEquals(bank.gesamtZinssatz(kunde),3.0f,0.000001f);
    }
    @Test
    public void gWGuthaben5(){
        Kunde kunde = new Kunde("Otto",50,1001);
        assertEquals(bank.gesamtZinssatz(kunde),5.0f,0.000001f);
    }


    @Test
    public void uAKGuthaben(){
        Kunde kunde = new Kunde("Otto",50,-5);
        assertEquals(bank.gesamtZinssatz(kunde),0.0f,0.000001f);
    }
    @Test
    public void uGWGuthaben(){
        Kunde kunde = new Kunde("Otto",50,0);
        assertEquals(bank.gesamtZinssatz(kunde),0.0f,0.000001f);
    }
    /*
AK Guthaben1: 1-100
AK Guthaben2: 101-1000
AK guthaben3 : 1000<

GW Guthaben1: 1
GW Guthaben2: 100
GW Guthaben3: 101
GW Guthaben4: 1000
GW Guthaben5: 1001

uAK Guthaben 1>
uGW Guthaben: 0
*/


    @Test
    public void aKAlter1(){
        Kunde kunde = new Kunde("Otto",3,50);
        assertEquals(bank.gesamtZinssatz(kunde),1.5f,0.000001f);
    }
    @Test
    public void aKAlter2(){
        Kunde kunde = new Kunde("Otto",50,50);
        assertEquals(bank.gesamtZinssatz(kunde),1.0f,0.000001f);
    }
    @Test
    public void aKAlter3(){
        Kunde kunde = new Kunde("Otto",69,50);
        assertEquals(bank.gesamtZinssatz(kunde),2.0f,0.000001f);
    }



    @Test
    public void GWAlter1(){
        Kunde kunde = new Kunde("Otto",0,50);
        assertEquals(bank.gesamtZinssatz(kunde),1.5f,0.000001f);
    }
    @Test
    public void GWAlter2(){
        Kunde kunde = new Kunde("Otto",5,50);
        assertEquals(bank.gesamtZinssatz(kunde),1.0f,0.000001f);
    }
    @Test
    public void GWAlter3(){
        Kunde kunde = new Kunde("Otto",6,50);
        assertEquals(bank.gesamtZinssatz(kunde),1.0f,0.000001f);
    }
    @Test
    public void GWAlter4(){
        Kunde kunde = new Kunde("Otto",64,50);
        assertEquals(bank.gesamtZinssatz(kunde),1.0f,0.000001f);
    }@Test
    public void GWAlter5(){
        Kunde kunde = new Kunde("Otto",65,50);
        assertEquals(bank.gesamtZinssatz(kunde),2.0f,0.000001f);
    }





    @Test
    public void uAKAlter(){
        Kunde kunde = new Kunde("Otto",-50,50);
        assertEquals(bank.gesamtZinssatz(kunde),0.0f,0.000001f);
    }
    @Test
    public void uGWAlter(){
        Kunde kunde = new Kunde("Otto",-1,50);
        assertEquals(bank.gesamtZinssatz(kunde),0.0f,0.000001f);
    }


/*
AK Alter1: 0-5
AK Alter2: 6-64
AK Alter3 64<

GW Alter1: 0
GW Alter2: 5
GW Alter3: 6
GW Alter4: 64
GW Alter5: 65

uAK ALter: 0>
uGW Alter2: -1
 */
}
