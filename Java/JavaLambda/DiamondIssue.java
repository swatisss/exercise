interface Human{
   default void work(){
      System.out.println("");
   }
}

interface Student extends Human{
   default void work(){
      System.out.println("•×‹­‚·‚é");
   }
}

interface Employee extends Human{
}

class NightStudent implements Student, Employee{

}

class DiamondIssue {
   public static void main(String[] args) {
      NightStudent ns = new NightStudent();
      ns.work();
   }
}
