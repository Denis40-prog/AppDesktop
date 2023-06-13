import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAdd {
    @Test
    public void testAddShouldReturnTwoAddedInteger(){
        int a = 4;
        int b = 10;
        MyFirstClass myFirstClass = new MyFirstClass();

        int result = 1;// = myFirstClass.add(a, b);

        assertEquals(14, result);
    }
}