package JUnitExercise;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class List8_1Test{
  public List8_1 sut = null;

  @Before
  public void setUp() throws Exception{
    sut = new List8_1();
  }

  @Test
  public void canRegisterは17ならばfalseを返す(){
    // set up
    boolean expected = false;
    boolean actual = false;

    // exercise
    actual = sut.canRegister(17);

    // verify
    assertThat(actual, is(exepected));
  }

  @Test
  public void canRegister19ならばtrueを返す(){
    //setup
    boolean expected = true;
    boolean actual = false;

    // exercise
    actual = sut.canRegister(19);

    // verify
    assertThat(actual, is(expected));
  }
}
