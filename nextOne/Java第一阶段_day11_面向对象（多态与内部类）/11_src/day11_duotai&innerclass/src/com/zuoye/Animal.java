package com.zuoye;

public abstract class Animal {
    public final void lifeTrack(){
    	sleep();
        work();
        eat();
    }	
    private void sleep(){
        System.out.println("˯��");
    }
    private void eat(){
        System.out.println("�Զ���");
    }
    protected abstract void work();
}
