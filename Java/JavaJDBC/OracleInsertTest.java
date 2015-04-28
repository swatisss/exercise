import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

class OracleInsertTest{
   public static void main(String[] args) {
      Connection con = null;
      Statement st = null;
      try{
         // Driverインターフェイスを実装したクラスをロード
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // Connectionインターフェイスを実装するクラスのインスタンスをゲット
         con = DriverManager.getConnection(
         "jdbc:oracle:thin:@localhost:1521:orcl",
         "scott",
         "tiger");

         // 自動コミットをOFFにする。毎回記入。
         con.setAutoCommit(false);
         System.out.println("接続完了");

         // SQL文の用意
         String sql = "INSERT INTO emp(empno, ename) VALUES(9004,'ぶるー')";

         // Statementインターフェイスを実装するクラスのインスタンスを取得。
         st = con.createStatement();

         // SQL文の実行。トランザクションが開始される。
         // executeUpdate()メソッドは戻り値として処理した件数を返す。
         int count = st.executeUpdate(sql);

         System.out.println(count+"件処理");

         // トランザクションをコミット
         con.commit();
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(SQLException e){
         e.printStackTrace();
         if(con != null && st != null){
            try{
               con.rollback();
               System.out.println("ロールバック完了");
            }catch(SQLException ex){
               ex.printStackTrace();
            }
         }
      }finally{
         try{
            if(st != null){
               st.close();
            }

            if(con != null){
               con.close();
            }
            System.out.println("リソースの解放");
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
   }
}
