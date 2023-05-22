package com.hopu.demo.zuoye;
/** 怪蛇类 */
public class Snake extends Monster {
	/** 加血 */
	public void addHp(){
		this.setHp(this.getHp()+20);
		System.out.println("实施大蛇补血术......，当前的生命值是"+this.getHp());
	}

	/** 重写父类的移动方法*/
	public void move() {
		System.out.println("我是蛇，我走S线路");
	}
}
