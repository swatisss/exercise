public class SingletonEx2Test{
  public static void main(String[] args) {
    SingletonEx2 e1 = SingletonEx2.getInstance("obj1");
    SingletonEx2 e2 = SingletonEx2.getInstance("obj2");
    SingletonEx2 e3 = SingletonEx2.getInstance("obj3");

    System.out.println(e1.getName());
    System.out.println(e2.getName());
    System.out.println(e3.getName());
  }
}
