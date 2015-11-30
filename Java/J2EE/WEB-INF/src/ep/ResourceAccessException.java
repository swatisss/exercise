package ep;

public class ResourceAccessException extends RuntimeException{
   public ResourceAccessException(String mess, Throwable e){
      super(mess,e);
   }
}
