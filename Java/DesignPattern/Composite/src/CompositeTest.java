public class CompositeTest{
   public static void main(String[] args) {
      Composite parent = new Composite("親");
      Leaf leaf1 = new Leaf("子1");
      Leaf leaf2 = new Leaf("子2");

      parent.add(leaf1);
      parent.add(leaf2);

      Client c = new Client();

      c.setComponent(parent);
      c.execute();

      c.setComponent(leaf1);
      c.execute();
   }
}
