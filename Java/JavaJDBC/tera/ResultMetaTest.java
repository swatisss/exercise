package tera;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

class ResultMetaTest{
   public static void main(String[] args) {
      Connection conn = null;
      Statement stm = null;
      ResultSet rs = null;

      try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
      System.out.println("�ڑ�");

      conn.setAutoCommit(false);

      String sql = "SELECT empno, ename FROM emp";

      stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

      rs = stm.executeQuery(sql);

      ResultSetMetaData rsMeta = rs.getMetaData();

      int columnCount = rsMeta.getColumnCount();

      while(rs.next()){
         for(int i = 1; i <= columnCount; i++){
            String data = rs.getString(i);
            System.out.println(i + "��F"+data);
         }
      }
      /*for(int i = 1; i <= columnCount;i++){
         String name = rsMeta.getColumnName(i);
         int type = rsMeta.getColumnType(i);

         String typeName = rsMeta.getColumnTypeName(i);
         int size = rsMeta.getPrecision(i);

         System.out.println(name+"\t"+type+"\t"+typeName+"\t"+size);

         switch(type){
            case java.sql.Types.NUMERIC:
               System.out.println("java.sql.Types.NUMERIC�ɑΉ������f�[�^�^");
               break;
            case java.sql.Types.VARCHAR:
               System.out.println("java.sql.Types.VARCHAR�ɑΉ������f�[�^�^");
               break;
         }
      }
      */
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(SQLException e){
         e.printStackTrace();
         if(conn != null && stm != null){
            try{
               conn.rollback();
               System.out.println("���[���o�b�N����");
            }catch(SQLException ex){
               ex.printStackTrace();
            }
         }
      }finally{
         try{
            if(stm != null){
               stm.close();
            }

            if(conn != null){
               conn.close();
            }
            System.out.println("���\�[�X�̉��");
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
   }
}
