public abstract class Component {
   private String name;

   public Component(String name){
      setName(name);
   }

   public void setName(String name){
      this.name = name;
   }

   public String getName(){
      return this.name;
   }

   public abstract void operation();
}
