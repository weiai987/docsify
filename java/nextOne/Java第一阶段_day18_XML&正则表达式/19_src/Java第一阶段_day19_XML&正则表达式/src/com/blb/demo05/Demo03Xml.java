package com.blb.demo05;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

public class Demo03Xml {
	
	public static void main(String[] args) throws Exception {
		Document doc = getDocumentBySax() ; 
		
//		Node node = doc.selectSingleNode("//students/student[@number='2']");
//		System.out.println(node.getName());
		
		List<Node> list = doc.selectNodes("//students/student");
		for (Node node : list) {
			
			if(node.matches("@number='2'")){
				System.out.println(node.getName()+"\t"+node.valueOf("@number"));
				
				Node nameNode = node.selectSingleNode("name");
				System.out.println(nameNode.getText());
			}
			
		}
		
	}
	
	public static Document getDocumentBySax() throws DocumentException{
		InputStream stream = Demo03.class.getClassLoader().getResourceAsStream("com/blb/demo04/class.xml");
		SAXReader reader = new SAXReader();
		return reader.read(stream);
	}
	
	public static Document getDocumentByDom() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream in = Demo03.class.getClassLoader().getResourceAsStream("com/blb/demo04/class.xml");
		org.w3c.dom.Document w3cdoc=db.parse(in);
		DOMReader domReader=new DOMReader();
		//��org.w3c.dom.Documentת��org.dom4j.Document
		Document document=domReader.read(w3cdoc);
		return document;
	}

}
