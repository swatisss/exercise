import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class Exercise3 {
   public static void main(String[] args) {
      School school = new School();
      Student student1 = new Student("A", new Date());
      Student student2 = new Student("B", null);
      Student student3 = new Student("C", new Date());
      Student student4 = new Student("D", new Date());

      school.add(student1);
      school.add(student2);
      school.add(student3);
      school.add(student4);

      school.showAll();
      school.removeNotExaminedStudent();
      school.showAll();
   }
}

class Student{
   private String name;
   private Date examdate = null;

   Student(String name, Date examdate){
      this.name = name;
      this.examdate = examdate;
   }

   public void showName(){
      System.out.println("–¼‘O:" + this.name);
   }

   public void showSize(){
      System.out.println("–¼‘O‚Ì•¶š”:"+ name.length());
   }

   public void showDate(){
      System.out.println("óŒ±“ú:" + this.examdate);
   }

   public Date getDate(){
      return this.examdate;
   }
}

class School {
   private ArrayList<Student> students = new ArrayList<Student>();

   public void add(Student student){
      students.add(student);
   }

   public void showAll(){
      for(int i = students.size()-1; i >= 0; i--){
         Student student = (Student)students.get(i);
         student.showName();
         student.showSize();
         student.showDate();
      }
      System.out.println("\n");
   }

   public boolean isExamined(Student student){
      Date date = student.getDate();
      if(date == null){
         return false;
      }
      return true;
   }

   public void removeNotExaminedStudent(){
      
      for(int i = 1; i < students.size(); i++){
         Student student = (Student)students.get(i);
         if(!isExamined(student)){
            students.remove(student);
         }
      }
   }

}
