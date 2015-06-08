import org.junit.Test;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PlusStringTest{

   public static void main(String[] args) {
      JUnitCore.main(Test.class.getName());
   }

   @Test
   public void plusStringTest(){
      IntegerCalculator icl = new IntegerCalculator();
      int expected = 12;
      int actual = icl.plusString("4","3");
      assertThat(actual, is(expected));
   }
}
