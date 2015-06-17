import java.util.ArrayList;
import java.util.Iterator;

public class CompositeTag extends Tag{
   private ArrayList<Tag> childTags = new ArrayList<>();

   public void addChild(Tag child){
      childTags.add(child);
   }

   public void write(){
      Iterator itr = childTags.iterator();

      System.out.println(getBeginTag());

      while(itr.hasNext()){
         Tag child = (Tag)itr.next();
         child.write();
      }

      System.out.println(getEndTag());
   }
}
