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
      System.out.println("DB�ɐڑ�");
   }

   public abstract Executer createExecuter();
}

abstract class Executer{
   public abstract void execute(String sql);
}

class OracleConnector extends DBConnector{
   public void connect(){
      System.out.println("Oracle�ɐڑ�");
   }

   public Executer createExecuter(){
      return new OracleExecuter();
   }
}

class MySQLConnector extends DBConnector{
   public void connect(){
      System.out.println("MySQL�ɐڑ�");
   }

   public Executer createExecuter(){
      return new MySQLExecuter();
   }
}

class OracleExecuter extends Executer{
   public void execute(String sql){
      System.out.println("Oracle��"+sql+"�̎��s");
   }
}

class MySQLExecuter extends Executer{
   public void execute(String sql){
      System.out.println("MySQL��"+sql+"�̎��s");
   }
}
