package com.hopu;
public abstract class AbstractClass{
    public final void execute(){
        open();
        put();
        close();
    }
	
    private void open(){
        System.out.println("�򿪱���");
    }

    private void close(){
        System.out.println("�رձ���");
    }

    protected abstract void put();
}