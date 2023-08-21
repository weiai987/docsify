package com.blb.utils;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils {

	/**
	 * 读取文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String read(String file) throws IOException {
		FileReader fileReader = new FileReader(IOUtils.class.getClassLoader().getResource(file).getPath());
		CharArrayWriter charArrayWriter = new CharArrayWriter();
		
		char[] data = new char[1024];
		int len;
		
		while ((len=fileReader.read(data))!=-1) {
			charArrayWriter.write(data, 0, len);
		}
		return charArrayWriter.toString();
	}
	
	/**
	 * 将输入流转为文件
	 * @param inputStream
	 * @param file
	 * @throws IOException
	 */
	public static void inputStreamToFile(InputStream inputStream, File file) throws IOException {
		File file2 = new File(file.getParent());
		if (!file2.exists()) {
			file2.mkdir();
		}
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		byte[] data = new byte[1024];
		int len;
		while ((len=inputStream.read(data))!=-1) {
			fileOutputStream.write(data, 0, len);
		}
		inputStream.close();
		fileOutputStream.close();
	}
	
	/**
	 * 将输入流转为byte数组
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] inputStreamToByte(InputStream inputStream) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		byte[] data = new byte[1024];
		int len;
		while ((len=inputStream.read(data))!=-1) {
			byteArrayOutputStream.write(data, 0, len);
		}
		inputStream.close();
		return byteArrayOutputStream.toByteArray();
	}
	
}
