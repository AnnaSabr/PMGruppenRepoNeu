package rsvflottespeiche;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MitgliederVerwaltungTestPARA {

    int alter;
    int motivation;
    boolean angenommen;

    public MitgliederVerwaltungTestPARA(int alter,int moti , boolean annahme){
        this.alter=alter;
        this.motivation=moti;
        this.angenommen=annahme;
    }

    /**
     * Parameter Liste
     * @return ArrayList mit den zu testenden Paramtern
     */
    @Parameterized.Parameters
    public static Collection<Object[]> values(){
        return Arrays.asList(new Object[][]{{21,5,true},{46,6,true},{59,7,true}});
    }

    //19
    /**
     *testet die beiden gueltigen AKs von Alter und Motivation parametrisiert
     */
    @Test
    public void testBeitrittPARA(){
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(this.alter,this.motivation), this.angenommen);
    }
}
