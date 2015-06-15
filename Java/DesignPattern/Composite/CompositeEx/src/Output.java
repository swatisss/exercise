public class Output{
   private Tag tag;

   Output(Tag tag){
      this.tag = tag;
   }

   public void show(){
      tag.write();
   }
}
