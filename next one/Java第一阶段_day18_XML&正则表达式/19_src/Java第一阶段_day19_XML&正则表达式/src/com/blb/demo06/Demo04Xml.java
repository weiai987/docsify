package com.blb.demo06;

import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Demo04Xml {

	public static void main(String[] args) throws Exception {
//		 1,创建内存中的Document对象
		Document document = DocumentHelper.createDocument();
//		2，把document对象填充完
		Element root = document.addElement("students");
		Element s1 = root.addElement("student").addAttribute("number", "1");
		s1.addElement("name").addText("six");
		s1.addElement("age").addText("16");
		s1.addElement("sex").addText("girl");
		
		Element s2 = root.addElement("student").addAttribute("number", "2");
		s2.addElement("name").addText("seven");
		s2.addElement("age").addText("23");
		s2.addElement("sex").addText("boy");
		
		
//		3,把上的document对象通过流写到硬盘上的xml文件中。
		OutputFormat of = OutputFormat.createPrettyPrint();
		FileWriter fw = new FileWriter("src/com/blb/seven06/student.xml");
		XMLWriter xw = new XMLWriter(fw,of);
		xw.write(document);
		xw.flush();
	}

}
