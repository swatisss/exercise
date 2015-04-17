import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class Parse {
  public static void main(String[] args) {
    try {
      SAXParserFactory objFac=SAXParserFactory.newInstance();
      // 文書型宣言による検証機能を有効にする
      objFac.setValidating(true);
      XMLReader objXml=objFac.newSAXParser().getXMLReader();
      // 引数で指定されたXML文書を解析する
      objXml.parse(args[0]);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("検証処理を終了しました。");
  }
}
