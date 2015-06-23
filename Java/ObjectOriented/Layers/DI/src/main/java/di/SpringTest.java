package di;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tera.*;

public class SpringTest{
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

      Calculator calc = (Calculator)context.getBean("calc");

      int ret = calc.plusString(args[0],args[1]);

      System.out.println(ret);
   }
}
