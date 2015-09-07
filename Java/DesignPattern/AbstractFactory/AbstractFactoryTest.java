
public class AbstractFactoryTest{
   public static void main(String[] args) {
      Client cl = new Client();

      cl.execute("test");
      cl.execute("prod");
   }
}
