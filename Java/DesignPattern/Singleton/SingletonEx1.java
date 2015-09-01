import java.util.ArrayList;

public class SingletonEx1{
  private static ArrayList<SingletonEx1> singletons = new ArrayList<>();

  private SingletonEx1(){}

  public static final SingletonEx1 getInstance(){
    /** コレクションの要素数を判定条件に使用する。
    * 具体例：
    * size=0のとき、1個めのインスタンスを生成
    * size=1のとき、2個めのインスタンスを生成
    * size=2のとき、3個めのインスタンスを生成
    * size=3のときは、インスタンスを生成せずに3個めの要素を返す
    **/
    if(singletons.size() < 3){
      singletons.add(new SingletonEx1());
    }
    // コレクションの添字は0からなので-1
    return singletons.get(singletons.size()-1);
  }
}
