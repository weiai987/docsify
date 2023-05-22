package com.hopu.demo.zuoye;
public class Test {
	public static void main(String[] args) {
		Snake sn = new Snake();//生产一个蛇精
		sn.setName("怪蛇甲");
		sn.setHp(5);
		sn.setAggressivity(20);
		sn.attack();//调用攻击方法
		if(sn.getHp()<10){//当生命少于10时，加20血
			sn.addHp();
		}
		sn.move();//蛇移动
		System.out.println("======================");
		
		Centipede ct = new Centipede();//new一个蜈蚣
		ct.setName("蜈蚣精乙");
		ct.setHp(60);
		ct.setAggressivity(15);
		ct.attack();//蜈蚣攻击
		ct.move();
	}
}
