package com.blb.bookms.entity;

import java.util.List;

/**
 * 分页包装类
 * @param <T>
 */
public class Page<T> {

    //每页行数
    public static final int LIMIT = 10;
    private int count;
    private List<T> data;
    private int current;
    private int limit;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
