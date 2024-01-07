package Day1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    List<String> input;
    @Before
    public void setup() {
        input = new ArrayList<>();
        input.add("51591twosix4dhsxvgghxq");
        input.add("425nine");
        input.add("llvmhjtr8nbbhrfone");
        input.add("lpbjvpbtdfvtxtdvkpjs7qrvddkzmjtlqtg");
        input.add("3sixnineseven");
    }

    @Test
    public void testIsNumber() {
        Assert.assertTrue(Main.isNumber(input.get(0).substring(0, 1)));
        Assert.assertFalse(Main.isNumber(input.get(2).substring(0,1)));
    }

    @Test
    public void testGetNumbers() {
        Assert.assertEquals(54, Main.getNumbers(input.get(0)));
        Assert.assertEquals(45, Main.getNumbers(input.get(1)));
        Assert.assertEquals(88, Main.getNumbers(input.get(2)));
        Assert.assertEquals(77, Main.getNumbers(input.get(3)));
        Assert.assertEquals(33, Main.getNumbers(input.get(4)));
    }

}
