package JUnitExercise;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.experimental.theories.Theories;

@Runwith(Theories.class)
public class List8_4Test{
  @DataPoint
  public static enum Hand{
    GU,TYOKI,PA
  }

  @Theory
  public void グーとチェキ
}
