
public class Test{
   public static void main(String[] args) {
      JDBCTraining jt = new JDBCTraining();
      jt.executeSQL(args[0]);
      jt.selectAllData();
   }
}
