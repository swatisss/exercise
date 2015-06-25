import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class DOMSample {
	public static void main (String[] argv){
		//XMLファイルを読み込み、Documentオブジェクトに変換 => ルート要素を取得し処理関数を呼び出す
		try{			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			//XMLファイル(第１引数)を読み込み、Document型の変数docにセット
			Document doc = builder.parse(argv[0]);
			//doc直下の要素(XML文書のルート要素)を指定して関数を呼び出す
			printDomTree(doc.getDocumentElement(), 0);
		}catch(Exception e){
			System.out.print("ERROR:" + e);
		}
	}
	
	public static void printDomTree(Element element, int level){
		//System.out.println("書籍一覧");

		//levelに応じて空白を出力(インデント)
	    for(int i = 0; i < level * 1; i++){
	      System.out.print(" ");
	    }
	    level++;
	    //element(Element型)のタグ名を出力
	    System.out.print(element.getTagName() + ":");

	    //子ノードリストを取得
	  	NodeList childNodeList = element.getChildNodes();
	    //elementの子ノードを順次処理
	    for(int i = 0; i < childNodeList.getLength(); i++){
	    	Node childNode = childNodeList.item(i);
	    	//子ノードがテキストならば内容を出力
		    if(childNode.getNodeType() == Node.TEXT_NODE){
		    	//内容を出力
		    	System.out.print(((Text) childNode).getData());
		    }
		    //子ノードが要素型ならばprintDomTree()を呼び出す(再帰処理)
		    else if(childNode.getNodeType() == Node.ELEMENT_NODE){
		    	printDomTree((Element) childNode, level);
		    }
		}
	}
}
