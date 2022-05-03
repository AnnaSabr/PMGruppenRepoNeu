import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SpecialArrayListTest {
    
    private String a;
    private String b;
    private String result;

    public SpecialArrayListTest(String a, String b, String r){
        this.a = a;
        this.b = b;
        this.result = r;
    }

    @Parameters
    public static Collection<Object[]> values(){
        return Arrays.asList(new Object[][] { { "", "", "" }, { "", "a", "a" }, { "a", "", "a" }, {"abc", "123", "abc123"} });
    }

    @Test
    public void testConcatAddStrings(){
        SpecialArrayList sar = new SpecialArrayList();
        sar.concatAddStrings(this.a, this.b);
        assertArrayEquals(sar.toArray(), new String[]{this.result}); 
    }
}
