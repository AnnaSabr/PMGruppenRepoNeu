import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;

public class ArrayListTest {
    private ArrayList<String> list = null;

    @Before
    public void setUp(){
        this.list = new ArrayList<>();
        this.list.add("Str1");
        this.list.add("Str2");
        assumeTrue(this.list != null && this.list.get(0).equals("Str1")  && this.list.get(1).equals("Str2"));
    }

    @Test
    public void testAdd(){
        this.list.add("Str3");
        assertArrayEquals(this.list.toArray(), new String[]{"Str1","Str2","Str3"});
    }

    @Test
    public void testRemoveObject(){
        this.list.remove("Str2");
        assertArrayEquals(this.list.toArray(), new String[]{"Str1"});
    }

    @Test
    public void testRemoveIndex(){
        this.list.remove(0);
        assertArrayEquals(this.list.toArray(), new String[]{"Str2"});
    }

    @After
    public void tearDown(){
        this.list.clear();
        this.list = null;
        assumeTrue(this.list == null);
    }
}
