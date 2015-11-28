import java.util.HashMap;
import java.util.Map;

public class Test{
   public static void main(String[] args) {
      Test t = new Test();
      Map map = (Map)t.getMap();
   }

   public Object getMap(){
      return new HashMap();
   }
}
