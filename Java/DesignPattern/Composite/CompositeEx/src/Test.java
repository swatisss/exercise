import java.util.ArrayList;
import java.util.Iterator;

public class Test{
   public static void main(String[] args) {
      CompositeTag parent = new CompositeTag();
      parent.setName("school");

      CompositeTag childTag1 = new CompositeTag();
      childTag1.setName("course");

      CompositeTag childTag2 = new CompositeTag();
      childTag2.setName("student");

      CompositeTag childTag3 = new CompositeTag();
      childTag3.setName("name");

      ChildTag value = new ChildTag();
      value.setName("ぶるー");

      parent.addChild(childTag1);
      childTag1.addChild(childTag2);
      childTag2.addChild(childTag3);
      childTag3.addChild(value);

      Output op = new Output(parent);
      op.show();
   }
}

class Output{
   private Tag tag;

   Output(Tag tag){
      this.tag = tag;
   }

   public void show(){
      tag.write();
   }
}

abstract class Tag{
   private int level = 1;

   private String name;

   public void setName(String name){
      this.name = name;
   }

   public String getName(){
      return this.name;
   }

   public void setLevel(int newLevel){
      this.level = newLevel;
   }

   public int getLevel(){
      return this.level;
   }

   public String getBeginTag(){
      String tab = "";

      for(int i = 1; i < getLevel(); i++){
         tab += "\t";
      }

      String beginTag = tab + "<"+getName()+">";
      return beginTag;
   }

   public String getEndTag(){
      String tab = "";

      for(int i = 1; i < getLevel(); i++){
         tab += "\t";
      }

      String endTag = tab + "</" + getName() + ">";
      return endTag;
   }

   public abstract void write();
}

class CompositeTag extends Tag{
   private ArrayList<Tag> childTags = new ArrayList<>();

   public void addChild(Tag child){
      child.setLevel(getLevel()+1);
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

class ChildTag extends Tag{
   public void write(){
      String tab = "";

      for(int i = 1; i < getLevel(); i++){
         tab += "\t";
      }
      System.out.println(tab+getName());
   }
}
