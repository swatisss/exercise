package JUnitExercise;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.experimental.theories.*;

@RunWith(Theories.class)
public class ParameterizedTest{
  @DataPoint
  public static int INT_PARAM_1 = 3;
  @DataPoint
  public static int INT_PARAM_2 = 4;

  public ParameterizedTest(){
    System.out.println("Initialized");
  }

  @Theory
  public void 引数を持つテストメソッド(int param) throws Exception{
    System.out.println("引数を持つテストメソッド("+param+")");
  }
}
