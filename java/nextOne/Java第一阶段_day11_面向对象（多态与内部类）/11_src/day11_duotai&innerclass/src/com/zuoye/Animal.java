package com.zuoye;

public abstract class Animal {
    public final void lifeTrack(){
    	sleep();
        work();
        eat();
    }	
    private void sleep(){
        System.out.println("Ë¯¾õ");
    }
    private void eat(){
        System.out.println("³Ô¶«Î÷");
    }
    protected abstract void work();
}
