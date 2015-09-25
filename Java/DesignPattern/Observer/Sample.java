import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Sample{
   public static void main(String[] args) {
      ConcreteSubject s = new ConcreteSubject();
      ConcreteObserverA a = new ConcreteObserverA(s);
      ConcreteObserverB b = new ConcreteObserverB(s);

      s.attach(a);
      s.attach(b);

      s.setState(400);
   }
}

abstract class Subject{
   // Observerを複数登録するためのインスタンス変数
   private ArrayList<Observer> observers = new ArrayList<>();

   public void attach(Observer o){
      observers.add(o);
   }

   public void detach(Observer o){
      observers.remove(o);
   }

   public void notifyOb(){
      Iterator itr = observers.iterator();

      while(itr.hasNext()){
         Observer o = (Observer)itr.next();
         o.update();
      }
   }
}

abstract class Observer{
   public abstract void update();
}

class ConcreteSubject extends Subject{
   private int state;

   public int getState(){
      return this.state;
   }

   public void setState(int state){
      this.state = state;

      System.out.println("Subjectの状態："+this.state);

      notifyOb();
   }
}

class ConcreteObserverA extends Observer{
   private double observerState;

   private ConcreteSubject subject;

   public ConcreteObserverA(ConcreteSubject s){
      this.subject = s;
   }

   public void update(){
      System.out.println("ConcreteSubjectからの更新通知を受け取る");

      int value = subject.getState();
      observerState = (double)value;

      System.out.println("ConcreteObserverAの状態"+observerState);
   }
}

class ConcreteObserverB extends Observer{
   private double observerState;

   private ConcreteSubject subject;

   public ConcreteObserverB(ConcreteSubject s){
      this.subject = s;
   }

   public void update(){
      System.out.println("ConcreteSubjectからの更新通知を受け取る");

      int value = subject.getState();
      observerState = (double)value;

      System.out.println("ConcreteObserverBの状態"+observerState);
   }
}
