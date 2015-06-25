import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class DOMSample {
	public static void main (String[] argv){
		//XML�t�@�C����ǂݍ��݁ADocument�I�u�W�F�N�g�ɕϊ� => ���[�g�v�f���擾�������֐����Ăяo��
		try{			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			//XML�t�@�C��(��P����)��ǂݍ��݁ADocument�^�̕ϐ�doc�ɃZ�b�g
			Document doc = builder.parse(argv[0]);
			//doc�����̗v�f(XML�����̃��[�g�v�f)���w�肵�Ċ֐����Ăяo��
			printDomTree(doc.getDocumentElement(), 0);
		}catch(Exception e){
			System.out.print("ERROR:" + e);
		}
	}
	
	public static void printDomTree(Element element, int level){
		//System.out.println("���Јꗗ");

		//level�ɉ����ċ󔒂��o��(�C���f���g)
	    for(int i = 0; i < level * 1; i++){
	      System.out.print(" ");
	    }
	    level++;
	    //element(Element�^)�̃^�O�����o��
	    System.out.print(element.getTagName() + ":");

	    //�q�m�[�h���X�g���擾
	  	NodeList childNodeList = element.getChildNodes();
	    //element�̎q�m�[�h����������
	    for(int i = 0; i < childNodeList.getLength(); i++){
	    	Node childNode = childNodeList.item(i);
	    	//�q�m�[�h���e�L�X�g�Ȃ�Γ��e���o��
		    if(childNode.getNodeType() == Node.TEXT_NODE){
		    	//���e���o��
		    	System.out.print(((Text) childNode).getData());
		    }
		    //�q�m�[�h���v�f�^�Ȃ��printDomTree()���Ăяo��(�ċA����)
		    else if(childNode.getNodeType() == Node.ELEMENT_NODE){
		    	printDomTree((Element) childNode, level);
		    }
		}
	}
}
