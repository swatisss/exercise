import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SampleHandler extends DefaultHandler {

    public static void main(String[] argv){
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			DefaultHandler handler = new SampleHandler();
			parser.parse(argv[0], handler);
		}catch(Exception e){
			System.out.println("ERROR : " + e);
		}
	}

  public void startDocument() {
    System.out.println("startDocument");
  }

  public void endDocument() {
    System.out.println("endDocument");
  }

  public void startElement(String namespaceURI,
                           String localName,
                           String qName,
                           Attributes atts) {

    System.out.println("startElement: " + qName);
  }

  public void endElement(String namespaceURI,
                         String localName,
                         String qName) {

    System.out.println("endElement: " + qName);
  }

  public void characters(char[] ch, int start, int length) {
    System.out.print("characters: ");
    for (int i = 0; i < length; i++) {
      System.out.print(ch[start + i]);
    }
    System.out.println();
  }
} 