
public class Client{
   private Request request;

   public setRequest(Request request){
      this.request = request;
   }

   public doService(){
      request.execute();
   }
}
