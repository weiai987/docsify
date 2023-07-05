package com.bigdata.nio1;

import java.nio.ByteBuffer;

/**
 * Nio中buffer缓冲区的三个属性
 * position
 * limit
 * capacity
 * 
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		//1创建缓冲区
		ByteBuffer buf=ByteBuffer.allocate(1024);
		System.out.println("---------写之前----------");
		System.out.println("capacity:"+buf.capacity());
		System.out.println("limit:"+buf.limit());
		System.out.println("position:"+buf.position());
		
		//2写入数据
		buf.put("abcdefg".getBytes());
		System.out.println("---------写之后----------");
		System.out.println("capacity:"+buf.capacity());
		System.out.println("limit:"+buf.limit());
		System.out.println("position:"+buf.position());
		
		//3切换为读取模式
		buf.flip();
		System.out.println("---------切换为读取模式----------");
		System.out.println("capacity:"+buf.capacity());
		System.out.println("limit:"+buf.limit());
		System.out.println("position:"+buf.position());
		
		
		byte[] data=new byte[3];
		buf.get(data);
		System.out.println("---------读取之后----------");
		System.out.println(new String(data,0,3));
		System.out.println("capacity:"+buf.capacity());
		System.out.println("limit:"+buf.limit());
		System.out.println("position:"+buf.position());
		
		buf.mark();
		buf.get(data);
		System.out.println("----------mark()----------");
		System.out.println("---------再次读取之后----------");
		System.out.println(new String(data,0,3));
		System.out.println("capacity:"+buf.capacity());
		System.out.println("limit:"+buf.limit());
		System.out.println("position:"+buf.position());
		
		
		buf.reset();
		buf.get(data);
		System.out.println("------reset() 重置------------");
		System.out.println(new String(data,0,3));
		System.out.println("capacity:"+buf.capacity());
		System.out.println("limit:"+buf.limit());
		System.out.println("position:"+buf.position());
		
		
		buf.clear();
		//buf.compact();
		System.out.println("---------clear()清空 conpact()压缩--------");
		System.out.println("capacity:"+buf.capacity());
		System.out.println("limit:"+buf.limit());
		System.out.println("position:"+buf.position());
	}
}
