package com.hopu.demo.zuoye;
//妖怪类
public class Monster {
	private String name;//怪物名
	private int hp;//血量
	private int aggressivity;//攻击力
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAggressivity() {
		return aggressivity;
	}
	public void setAggressivity(int aggressivity) {
		this.aggressivity = aggressivity;
	}
	/** 攻击 */
	public void attack() {
		System.out.println("怪物"+this.getName()+"展开攻击");
		System.out.println("当前生命值："+this.getHp());
		System.out.println("攻击力是："+this.getAggressivity());
	}
	/** 移动 */
	public void move() {
	}
}
