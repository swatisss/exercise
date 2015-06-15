import java.util.ArrayList;
import java.util.Iterator;

public class Composite extends Component{
   private ArrayList children = new ArrayList();

   public void add(Component child){
      this.children.add(child);
   }

   public Component getChild(int index){
      return (Component)this.children.get(index);
   }

   public Composite(String name){
      super(name);
   }

   @Override
   public void operation(){
      System.out.println(getName());

      Iterator itr = children.iterator();

      while(itr.hasNext()){
         Component child = (Component)itr.next();
         child.operation();
      }
   }
}
