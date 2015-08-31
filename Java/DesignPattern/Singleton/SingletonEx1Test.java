public class SingletonEx1Test{
  public static void main(String[] args) {
    SingletonEx1 e1 = SingletonEx1.getInstance();
    SingletonEx1 e2 = SingletonEx1.getInstance();
    SingletonEx1 e3 = SingletonEx1.getInstance();
    SingletonEx1 e4 = SingletonEx1.getInstance();
    SingletonEx1 e5 = SingletonEx1.getInstance();

    System.out.println("e1とe2は違うインスタンス"+e1.equals(e2));
    System.out.println("e2とe3は違うインスタンス"+e2.equals(e3));
    System.out.println("e3とe4は同じインスタンス"+e3.equals(e4));
    System.out.println("e4とe5は同じインスタンス"+e4.equals(e5));

  }
}
