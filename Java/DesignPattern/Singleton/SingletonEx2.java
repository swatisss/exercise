import java.util.HashMap;

public class SingletonEx2{
  private static HashMap<String,SingletonEx2> singletons = new HashMap<>();

  private SingletonEx2(){}

  static{
    singletons.put("obj1", new SingletonEx2());
    singletons.put("obj2", new SingletonEx2());
    singletons.put("obj3", new SingletonEx2());
  }

  public static final SingletonEx2 getInstance(String name){
    if(singletons.containsKey(name)){
      return singletons.get(name);
    }
    return null;
  }
}
