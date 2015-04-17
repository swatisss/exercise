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
         System.out.println("ê⁄ë±");

         BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
         try{
            System.out.println("ê⁄ë±íÜÇ»Ç§");
            String b = a.readLine();
            System.out.printf("ì¸óÕ = %S%nÅ@í∑Ç≥ = %d ï∂éö%n", b, b.length());
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
