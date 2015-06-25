import java.io.FileOutputStream;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

class Transform {
   public static void main(String[] args) {
      try{
         StreamSource xsltSrc = new StreamSource(args[0]);
         StreamSource xmlSrc = new StreamSource(args[1]);
         StreamResult result = new StreamResult(new FileOutputStream("result.html"));

         TransformerFactory transFactory = TransformerFactory.newInstance();
         Transformer transformer = transFactory.newTransformer(xsltSrc);
         transformer.transform(xmlSrc, result);
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}
