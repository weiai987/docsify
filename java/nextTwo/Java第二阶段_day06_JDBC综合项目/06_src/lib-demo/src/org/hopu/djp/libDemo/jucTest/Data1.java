package org.hopu.djp.libDemo.jucTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Data1 {
    private boolean flag = false;
    private int num= 0;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ldt.atZone(ZoneId.systemDefault());
        Date d =  Date.from(zonedDateTime.toInstant());
        System.out.println("date=" + d);

    }
}
