package com.blb.bookms.entity;

/**
 * 书籍
 */
public class Book {

    private Integer id;
    private String  bookName;
    private float price;
    private Integer typeId;
    private String author;
    private String publishOrg;
    private String publishTime;
    private Integer state;
    private String bookImage;

    //书籍类型
    private BookType bookType;

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Book(Integer id, String bookName, float price, Integer typeId, String author, String publishOrg, String publishTime, Integer state, String bookImage) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.typeId = typeId;
        this.author = author;
        this.publishOrg = publishOrg;
        this.publishTime = publishTime;
        this.state = state;
        this.bookImage = bookImage;
    }

    public Book() {
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishOrg() {
        return publishOrg;
    }

    public void setPublishOrg(String publishOrg) {
        this.publishOrg = publishOrg;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", typeId=" + typeId +
                ", author='" + author + '\'' +
                ", publishOrg='" + publishOrg + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", state=" + state +
                '}';
    }
}
