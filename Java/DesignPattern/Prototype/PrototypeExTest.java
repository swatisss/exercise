import java.util.HashMap;

public class PrototypeExTest{
   public static void main(String[] args) {
      //PrototypeManagerにSql文を追加。
      PrototypeManager manager = new PrototypeManager();
      manager.register("SELECT", new ConcreteSqlHolder("SELECT * FROM emp"));
      manager.register("UPDATE", new ConcreteSqlHolder("UPDATE emp SET sal = X"));
      manager.register("INSERT", new ConcreteSqlHolder("INSERT INTO emp(empno) VALUES(X)"));
      manager.register("DELETE", new ConcreteSqlHolder("DELETE FROM emp WHERE empno=X"));

      AbstractSqlHolder s1 = manager.getSqlHolder("SELECT");
      AbstractSqlHolder s2 = manager.getSqlHolder("UPDATE");
      AbstractSqlHolder s3 = manager.getSqlHolder("INSERT");
      AbstractSqlHolder s4 = manager.getSqlHolder("DELETE");

      s2.replaceSqlStatement("260000");
      s3.replaceSqlStatement("12345");
      s4.replaceSqlStatement("12345");

      System.out.println(s1.getSqlStatement());
      System.out.println(s2.getSqlStatement());
      System.out.println(s3.getSqlStatement());
      System.out.println(s4.getSqlStatement());
   }
}

class PrototypeManager{
   private HashMap sqlHolders = new HashMap();

   public void register(String key, AbstractSqlHolder sqlHolder){
      sqlHolders.put(key, sqlHolder);
   }

   public AbstractSqlHolder getSqlHolder(String key){
      AbstractSqlHolder s = (AbstractSqlHolder)sqlHolders.get(key);

      AbstractSqlHolder copy = null;

      try{
         copy = (AbstractSqlHolder)s.clone();
      }catch(CloneNotSupportedException e){
         e.printStackTrace();
      }
      return copy;
   }
}

abstract class AbstractSqlHolder implements Cloneable{
   private String sqlStatement;

   public AbstractSqlHolder(String sqlStatement){
      this.sqlStatement = sqlStatement;
   }

   public void setSqlStatement(String sqlStatement){
      this.sqlStatement = sqlStatement;
   }

   public String getSqlStatement(){
      return sqlStatement;
   }

   public void replaceSqlStatement(String str){
      sqlStatement = sqlStatement.replace("X",str);
   }

   public Object clone() throws CloneNotSupportedException{
      AbstractSqlHolder s = (AbstractSqlHolder)super.clone();
      String sqlStatement = new String(s.getSqlStatement());

      s.setSqlStatement(sqlStatement);

      return s;
   }
}

class ConcreteSqlHolder extends AbstractSqlHolder{
   public ConcreteSqlHolder(String sqlStatement){
      super(sqlStatement);
   }
}
