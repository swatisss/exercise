import java.util.HashMap;

public class PrototypeTest{
   public static void main(String[] args) {
      PrototypeManager manager = new PrototypeManager();
      manager.register("A", new IPStudent("ぶるー"));
      manager.register("B", new IPStudent("加賀さん"));
      manager.register("C", new IPStudent("不知火"));

      Student s1 = manager.getStudent("A");
      Student s2 = manager.getStudent("B");
      Student s3 = manager.getStudent("C");

      System.out.println(s1.getStudentName());
      System.out.println(s2.getStudentName());
      System.out.println(s3.getStudentName());
   }
}

class PrototypeManager{
   private HashMap students = new HashMap();

   public void register(String key, Student s){
      students.put(key, s);
   }

   public Student getStudent(String key){
      Student s = (Student)students.get(key);

      Student copy = null;

      try{
         copy = (Student)s.clone();
      }catch(CloneNotSupportedException e){
         e.printStackTrace();
      }
      return copy;
   }
}

abstract class Student implements Cloneable{
   private String name;
   public Student(String name){
      this.name = name;
   }

   public void setName(String name){
      this.name = name;
   }

   public String getStudentName(){
      return name;
   }

   public Object clone() throws CloneNotSupportedException{
      Student s = (Student)super.clone();
      String name = new String(s.getStudentName());

      s.setName(name);

      return s;
   }
}

class IPStudent extends Student{
   public IPStudent(String name){
      super(name);
   }
}
