package com.blb.mybatis_demo.entity;


import java.io.Serializable;

public class Book implements Serializable {

  private long id;
  private String bookName;
  private double price;
  private long typeId;
  private String author;
  private String publishOrg;
  private String publishTime;
  private long state;
  private String bookImage;

  public Book(long id, String bookName, double price, long typeId, String author, String publishOrg, String publishTime, long state, String bookImage) {
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
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


  public long getState() {
    return state;
  }

  public void setState(long state) {
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
            ", bookImage='" + bookImage + '\'' +
            '}';
  }
}
