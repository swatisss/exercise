public class Test{
   public static void main(String[] args) {
      // 複数SQL文
      CompositeSQLExecuter parent = new CompositeSQLExecuter();
      parent.setSQL("SELECT * FROM emp");

      CompositeSQLExecuter child1 = new CompositeSQLExecuter();
      child1.setSQL("SELECT * FROM customer");

      SingleSQLExecuter child2 = new SingleSQLExecuter();
      child2.setSQL("SELECT * FROM student");

      parent.setChild(child1);
      child1.setChild(child2);

      // 単一SQL文
      SQLComponent single = new SingleSQLExecuter();
      single.setSQL("DELETE FROM emp WHERE eno = 1");

      // クライアントから実行させる
      Client c1 = new Client(parent);
      c1.operation();
      Client c2 = new Client((SQLCommand)single);
      c2.operation();
   }
}

class Client{
   private SQLCommand command;

   public Client(SQLCommand command){
      this.command = command;
   }

   public void operation(){
      command.executeSQL();
   }
}

interface SQLCommand {
   void executeSQL();
}

abstract class SQLComponent {
   private String sql;

   void setSQL(String sql){
      this.sql = sql;
   }

   String getSQL(){
      return this.sql;
   }

   public abstract void execute();
}

class SingleSQLExecuter extends SQLComponent implements SQLCommand{
   public void execute(){
      System.out.println(getSQL());
   }

   // 単一SQLの時に呼び出される。
   public void executeSQL(){
      System.out.println();
      System.out.println("単一SQLの実行");
      execute();
   }
}

class CompositeSQLExecuter extends SQLComponent implements SQLCommand{
   private SQLComponent child;

   public void setChild(SQLComponent child){
      this.child = child;
   }

   public SQLComponent getChild(){
      return child;
   }

   public void execute(){
      SQLComponent child = getChild();
      child.execute();

      System.out.println(getSQL());
   }

   public void executeSQL(){
      System.out.println("複数SQLの実行");
      execute();
   }
}
