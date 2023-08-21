package com.hopu;
public abstract class AbstractClass{
    public final void execute(){
        open();
        put();
        close();
    }
	
    private void open(){
        System.out.println("´ò¿ª±ùÏä");
    }

    private void close(){
        System.out.println("¹Ø±Õ±ùÏä");
    }

    protected abstract void put();
}