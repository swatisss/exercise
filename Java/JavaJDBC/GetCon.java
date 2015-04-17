import java.io.IOException;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetCon{
   public static void main(String[] args) {
      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");

         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
         System.out.println("接続");

         BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
         try{
            System.out.println("接続中なう");
            String b = a.readLine();
            System.out.printf("入力 = %S%n　長さ = %d 文字%n", b, b.length());
         }catch(IOException e){
            System.out.println(e.getMessage());
         }catch(Exception e){
            System.out.println(e.getMessage());
         }
         con.close();
      }catch(ClassNotFoundException e){
         System.out.println(e.getMessage());
      }catch(SQLException e){
         System.out.println(e.getMessage());
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
   }
}
