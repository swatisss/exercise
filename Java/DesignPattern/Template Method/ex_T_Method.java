class ex_T_Method{
   public static void main(String[] args) {
      Client oracleCl = new Client(new OracleAccessor());
      Client mysqlCl = new Client(new MySQLAccessor());
      oracleCl.execute();
      mysqlCl.execute();
   }
}
class Client{
   private Accessor accessor;

   Client(Accessor accessor){
      this.accessor = accessor;
   }

   public void execute(){
      accessor.doSaveAsXML();
   }
}

abstract class Accessor{
   public final void doSaveAsXML(){
      String record = getDataFromRDB();
      String xml = toXML(record);
      saveToFile(xml);
   }

   abstract protected String getDataFromRDB();

   protected String toXML(String record){
      System.out.println("XML形式に変換");
      return record+" XML";
   }

   protected void saveToFile(String xml){
      System.out.println("XMLとして保存");
   }
}

class OracleAccessor extends Accessor{
   protected String getDataFromRDB(){
      System.out.println("Oracleからデータを取得");
      return "結果セット";
   }
}

class MySQLAccessor extends Accessor{
   protected String getDataFromRDB(){
      System.out.println("MySQLからデータを取得");
      return "結果セット";
   }
}
