import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class Parse {
  public static void main(String[] args) {
    try {
      SAXParserFactory objFac=SAXParserFactory.newInstance();
      // �����^�錾�ɂ�錟�؋@�\��L���ɂ���
      objFac.setValidating(true);
      XMLReader objXml=objFac.newSAXParser().getXMLReader();
      // �����Ŏw�肳�ꂽXML��������͂���
      objXml.parse(args[0]);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("���؏������I�����܂����B");
  }
}
