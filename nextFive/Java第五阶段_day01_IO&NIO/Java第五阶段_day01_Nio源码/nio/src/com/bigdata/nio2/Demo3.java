package com.bigdata.nio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("d:\\a.txt");
		FileOutputStream fos=new FileOutputStream("d:\\b.txt");
		FileChannel sourceCh=fis.getChannel(); 
		FileChannel destCh=fos.getChannel(); 
		destCh.transferFrom(sourceCh,0,sourceCh.size()); 
		sourceCh.close(); 
		destCh.close();
	}

}
