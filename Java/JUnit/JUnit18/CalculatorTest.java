import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class CalculatorTest{
   @Test(expected = IllegalArgumentException.class)
   public void divideはIllegalArgumentExceptionを送出する() throws Exception{
      Calculator cl = new Calculator();
      cl.divide(10,0);
   }
}
