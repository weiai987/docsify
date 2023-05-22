package com.blb.demo04;

import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

public class Demo02Xml {
	
	public static void main(String[] args) throws DocumentException {
		Document doc = getDocumentBySax() ; 
		Element root = doc.getRootElement();
//		System.out.println(root.getName());
		
		Iterator<Element> iterator = root.elementIterator();

		while(iterator.hasNext()){
			Element next = iterator.next();
			System.out.println(next.getName()+" "+next.attributeValue("number"));
			Element nameEle = next.element("name");
			System.out.println(nameEle.getName());
			System.out.println(nameEle.getText());
		}
		
	}
	
	public static Document getDocumentBySax() throws DocumentException{
		InputStream stream = Demo02.class.getClassLoader().getResourceAsStream("com/blb/demo04/class.xml");
		SAXReader reader = new SAXReader();
		return reader.read(stream);
	}
	
	public static Document getDocumentByDom() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream in = Demo02.class.getClassLoader().getResourceAsStream("com/blb/demo04/class.xml");
		org.w3c.dom.Document w3cdoc=db.parse(in);
		DOMReader domReader=new DOMReader();
		//��org.w3c.dom.Documentת��org.dom4j.Document
		Document document=domReader.read(w3cdoc);
		return document;
	}

}
