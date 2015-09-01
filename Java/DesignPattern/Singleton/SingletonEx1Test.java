public class SingletonEx1Test{
  public static void main(String[] args) {
    SingletonEx1 e1 = SingletonEx1.getInstance();
    SingletonEx1 e2 = SingletonEx1.getInstance();
    SingletonEx1 e3 = SingletonEx1.getInstance();
    SingletonEx1 e4 = SingletonEx1.getInstance();

    System.out.println("e1とe2は同じインスタンス? "+(e1 == e2));
    System.out.println("e2とe3は同じインスタンス? "+(e2 == e3));
    System.out.println("e3とe4は同じインスタンス? "+(e3 == e4));
  }
}
