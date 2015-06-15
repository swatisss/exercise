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
