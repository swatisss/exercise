import java.util.HashMap;

public class SingletonEx2{
  private static HashMap<String,SingletonEx2> singletons = new HashMap<>();
  private String name;

  private SingletonEx2(String name){
    setName(name);
  }

  static{
    singletons.put("obj1", new SingletonEx2("obj1"));
    singletons.put("obj2", new SingletonEx2("obj2"));
    singletons.put("obj3", new SingletonEx2("obj3"));
  }

  public static final SingletonEx2 getInstance(String name){
    if(singletons.containsKey(name)){
      return singletons.get(name);
    }
    return null;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }
}
