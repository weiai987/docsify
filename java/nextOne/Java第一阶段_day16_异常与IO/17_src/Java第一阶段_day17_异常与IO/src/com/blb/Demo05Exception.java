package com.blb;

class AgeOutOfBoundException extends RuntimeException{

    public AgeOutOfBoundException() {
    }

    public AgeOutOfBoundException(String message) {
        super(message);
    }
}

public class Demo05Exception {

    public static void main(String[] args) {
        setAge(-1);
    }

    public static void setAge(int age) throws AgeOutOfBoundException {
        // 如果年龄为负数抛出此异常
        if(age<0){
            throw new AgeOutOfBoundException("年龄不能为负数");
        }
    }


}
