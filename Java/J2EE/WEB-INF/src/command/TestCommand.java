package command;

import context.*;
import bean.*;

public class TestCommand extends AbstractCommand{
   public ResponseContext execute(ResponseContext resc){
      RequestContext reqc = getRequestContext();

      String param1 = reqc.getParameter("value1")[0];

      TestBean bean = new TestBean();
      bean.setName(param1);

      resc.setResult(bean);
      System.out.println();
      resc.setTarget("show");
      return resc;
   }
}
