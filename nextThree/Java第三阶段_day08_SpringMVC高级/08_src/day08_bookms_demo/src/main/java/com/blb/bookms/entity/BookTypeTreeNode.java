package com.blb.bookms.entity;

/**
 * 书籍类型树节点
 */
public class BookTypeTreeNode {

    private Integer id;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookTypeTreeNode(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public BookTypeTreeNode() {
    }

    @Override
    public String toString() {
        return "BookTypeTreeNode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
