import java.util.ArrayList;
import java.util.Iterator;

public class Test{
   public static void main(String[] args) {
      ConcreteSubject s = new ConcreteSubject();
      ConcreteObserverA a = new ConcreteObserverA(s);
      ConcreteObserverB b = new ConcreteObserverB(s);

      s.attach(a);
      s.attach(b);

      s.setSubjectState(400);
   }
}

abstract class Subject {
   private ArrayList observers = new ArrayList();

   public void attach(Observer observer){
      observers.add(observer);
   }

   public void detach(Observer observer){
      observers.remove(observer);
   }

   public void notifyOb(){
      Iterator itr = observers.iterator();

      while(itr.hasNext()){
         Observer o = (Observer)itr.next();
         o.update();
      }
   }
}

class ConcreteSubject extends Subject {
   private int subjectState;

   public void setSubjectState(int state){
      this.subjectState = state;
      System.out.println(subjectState);

      notifyOb();
   }

   public int getSubjectState(){
      return subjectState;
   }
}

abstract class Observer {
   public abstract void update();
}


class ConcreteObserverA extends Observer {
   private int observerState;

   private ConcreteSubject subject;

   public ConcreteObserverA(ConcreteSubject subject){
      this.subject = subject;
   }

   public void update(){
      System.out.println("ConcreteSubjectから更新通知を受け取る");

      observerState = subject.getSubjectState();

      System.out.println("ConcreteObserverAの状態"+observerState);
   }
}

class ConcreteObserverB extends Observer {
   private int observerState;
   private ConcreteSubject subject;

   public ConcreteObserverB(ConcreteSubject subject){
      this.subject = subject;
   }

   public void update(){
      System.out.println("ConcreteSubjectから更新通知を受け取る");

      observerState = subject.getSubjectState();

      System.out.println("ConcreteObserverBの状態"+observerState);
   }
}
