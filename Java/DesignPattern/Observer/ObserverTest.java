import java.util.ArrayList;
import java.util.Iterator;

public class ObserverTest{
   public static void main(String[] args) {
      ConcreteDataHolder holder = new ConcreteDataHolder();
      DataListener listenerA = new ConcreteDataListenerA();
      DataListener listenerB = new ConcreteDataListenerB();

      holder.attach(listenerA);
      holder.attach(listenerB);

      holder.setData("あああああああああああああああああああああああああ");
   }
}

abstract class DataHolder{
   // Observerを複数登録するためのインスタンス変数
   private ArrayList<DataListener> observers = new ArrayList<>();

   public void attach(DataListener listener){
      observers.add(listener);
   }

   public void detach(DataListener listener){
      observers.remove(listener);
   }

   public void notifyListener(){
      Iterator itr = observers.iterator();

      while(itr.hasNext()){
         DataListener o = (DataListener)itr.next();
         o.update(this);
      }
   }
}

interface DataListener{
   public abstract void update(DataHolder holder);
}

class ConcreteDataHolder extends DataHolder{
   private String data;

   public String getData(){
      return this.data;
   }

   public void setData(String data){
      this.data = data;

      System.out.println("DataHolderの状態："+this.data);

      if(data.length() > 10){
         notifyListener();
      }
   }
}

class ConcreteDataListenerA implements DataListener{
   private String observerState;

   public void update(DataHolder holder){
      System.out.println("ConcreteDataHolderからの更新通知を受け取る");

      String data = ((ConcreteDataHolder)holder).getData();
      observerState = data+" from listenerA";

      System.out.println("ConcreteDataListenerAの状態"+observerState);
   }
}

class ConcreteDataListenerB implements DataListener{
   private String observerState;

   public void update(DataHolder holder){
      System.out.println("ConcreteDataHolderからの更新通知を受け取る");

      String data = ((ConcreteDataHolder)holder).getData();
      observerState = data+" from listenerB";

      System.out.println("ConcreteDataListenerBの状態"+observerState);
   }
}
