package rsvflottespeiche;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


public class MitgliederVerwaltungTest {

    //1
    /**
     * testet zu kleines Alter
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testBeitrittuAEK1a() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(-5, 6), true);
    }

    //2
    /**
     * testet zu hohes Alter
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testBeitrittuAEK1b() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(150, 6), true);
    }

    //3
    /**
     * testet Grenzwert bei zu kleinem Alter
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testBeitrittuGW1() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(-1, 6), true);
    }

    //4
    /**
     * testet Grenzwert bei zu hohem Alter
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testBeitrittuGW2() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(100, 6), true);
    }



    //5
    /**
     * testet gueltigen Bereich des Alters
     */
    @Test
    public void testBeitrittgAEK1() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, 6), true);
    }

    //6
    /**
     * testet gueltigen unteren Grenzwert des Alters
     */
    @Test
    public void testBeitrittgGW1() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(0, 6), false);
    }

    //7
    /**
     * testet gueltigen oberen Grenzwert des Alters
     */
    @Test
    public void testBeitrittgGW2() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(99, 6), true);
    }



    //8
    /**
     * testet zu geringes Alter fuer zweite Anforderung
     */
    @Test
    public void testBeitrittuAEK2() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(10, 6), false);
    }

    //9
    /**
     * testet Grenzwert fuer zu kleines Alter, bei zweiter Anforderung
     */
    @Test
    public void testBeitrittuGW3() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(15, 6), false);
    }



    //10
    /**
     * testet gueltige Bereich Alters, nach zweiter Anforderung
     */
    @Test
    public void testBeitrittgAEK2() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, 6), true);
    }

    //11
    /**
     * testet gueltigen Grenzwert des Alters, nach zweiter Anforderung
     */
    @Test
    public void testBeitrittgGW3() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(16, 6), true);
    }



    //12
    /**
     * testet zu niedrigen Bereich bei motivation
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testBeitrittuAEK3a() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, -5), true);
    }

    //13
    /**
     * testet zu niedrigen Grenzwert bei motivation
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testBeitrittuGW4() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, -1), true);
    }



    //14
    /**
     * testet zu hohen Bereich bei motivation
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testBeitrittuAEK3b() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, 15), true);
    }

    //15
    /**
     * testet zu hohen Grenzwert bei Motivation
     */
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testBeitrittuGW5() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, 11), true);
    }




    //16
    /**
     * testet gueltigen Bereich bei motivation
     */
    @Test
    public void testBeitrittgAEK3() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, 6), true);
    }

    //17
    /**
     * testet unteren gueltigen Grenzwert, bei motivation
     */
    @Test
    public void testBeitrittgGW4() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, 4), true);
    }

    //18
    /**
     * testet oberen gueltigen Grenzwert, bei motivation
     */
    @Test
    public void testBeitrittgGW5() {
        MitgliederVerwaltung mV = new MitgliederVerwaltung();
        assertEquals(mV.testBeitritt(21, 7), true);
    }



}
