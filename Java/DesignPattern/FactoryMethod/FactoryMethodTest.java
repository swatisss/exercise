public class FactoryMethodTest{
   public static void main(String[] args) {
      DBConnector c = new OracleConnector();
      Client client = new Client(c);
      client.operation("UPDATE x SET y = 100");
   }
}

class Client {
   private DBConnector conn;

   public Client(DBConnector conn){
      this.conn = conn;
   }

   public void operation(String sql){
      Executer exe = conn.createExecuter();
      exe.execute(sql);
   }
}

abstract class DBConnector{
   public void connect(){
      System.out.println("DBに接続");
   }

   public abstract Executer createExecuter();
}

abstract class Executer{
   public abstract void execute(String sql);
}

class OracleConnector extends DBConnector{
   public void connect(){
      System.out.println("Oracleに接続");
   }

   public Executer createExecuter(){
      return new OracleExecuter();
   }
}

class MySQLConnector extends DBConnector{
   public void connect(){
      System.out.println("MySQLに接続");
   }

   public Executer createExecuter(){
      return new MySQLExecuter();
   }
}

class OracleExecuter extends Executer{
   public void execute(String sql){
      System.out.println("Oracleで"+sql+"の実行");
   }
}

class MySQLExecuter extends Executer{
   public void execute(String sql){
      System.out.println("MySQLで"+sql+"の実行");
   }
}
