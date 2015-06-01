import static org.junit.Assert.*;
import org.junit.Test;

public class DogTest{

   @Test
   public void testGetName(){
      String name ="pochi";

      Dog dog = new Dog(name);
      assertEquals(name, dog.getName());
   }
}
