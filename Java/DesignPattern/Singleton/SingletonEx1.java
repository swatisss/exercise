import java.util.ArrayList;

public class SingletonEx1{
  private static ArrayList<SingletonEx1> singletons = new ArrayList<>();

  private SingletonEx1(){}

  public static final SingletonEx1 getInstance(){
    if(singletons.size() <= 2){
      singletons.add(new SingletonEx1());
    }
    return singletons.get(singletons.size()-1);
  }
}
