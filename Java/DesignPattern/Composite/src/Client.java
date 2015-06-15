public class Client{
   private Component component;

   public void setComponent(Component component){
      this.component = component;
   }

   public void execute(){
      this.component.operation();
   }
}
