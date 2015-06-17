public class ChildTag extends Tag{
   public void write(){
      System.out.println(getBeginTag());
      System.out.println(getEndTag());
   }
}
