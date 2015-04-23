import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

class OracleInsertTest{
   public static void main(String[] args) {
      try{
         // Driverインターフェイスを実装したクラスをロード
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // Connectionインターフェイスを実装するクラスのインスタンスをゲット
         Connection con = DriverManager.getConnection(
         "jdbc:oracle:thin:@localhost:1521:orcl",
         "scott",
         "tiger");

         // 自動コミットをOFFにする。毎回記入。
         con.setAutoCommit(false);
         System.out.println("接続完了");

         // SQL文の用意
         String sql = "INSERT INTO emp(empno, ename) VALUES(9002,'OHARAZAWA')";

         // Statementインターフェイスを実装するクラスのインスタンスを取得。
         Statement st = con.createStatement();

         // SQL文の実行。トランザクションが開始される。
         // executeUpdate()メソッドは戻り値として処理した件数を返す。
         int count = st.executeUpdate(sql);

         System.out.println(count+"件処理");

         // トランザクションをコミット
         con.commit();

         // リソースの開放。これを怠るとロックが開放されない、RDBMSの接続が切断されないなどの問題が発生する。
         // ステートメントをクローズ
         st.close();
         // RDBMSから切断
         con.close();
         System.out.println("切断完了");
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(SQLException e){
         // rollback()処理を入れるならここ。ただし、rollback()自体がSQLExceptionをスローするので、try-catchが必要。
         e.printStackTrace();
      }
   }
}
