package command;

import context.*;

public abstract class AbstractCommand{
   private RequestContext reqc;

   public void init(RequestContext reqc){
      this.reqc = reqc;
   }

   public RequestContext getRequestContext(){
      return reqc;
   }

   public abstract ResponseContext execute(ResponseContext resc);
}
