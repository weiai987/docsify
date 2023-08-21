package org.hopu.djp.libDemo.entity;

/**
 * 图书实体类，对应数据库表名为 lib_book
 * DROP TABLE IF EXISTS `lib_book`;
 * CREATE TABLE `lib_book`  (
 *   `book_id` int(11) NOT NULL AUTO_INCREMENT,
 *   `book_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `book_number` int(11) NULL DEFAULT NULL,
 *   `book_price` decimal(10,2) NULL DEFAULT NULL,
 *   `create_time` datetime(0) NULL DEFAULT NULL,
 *   `create_opr` int(11) NULL DEFAULT NULL,
 *   `update_time` datetime(0) NULL DEFAULT NULL,
 *   `update_opr` int(11) NULL DEFAULT NULL,
 *   `enable_flag` int(11) NULL DEFAULT NULL,
 *   `delete_flag` int(11) NULL DEFAULT NULL,
 *   PRIMARY KEY (`book_id`) USING BTREE
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 */
public class Book extends BaseEntity{
    private int bookId;
    private String bookName;
    private int bookNum;
    private double bookPrice;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "createTime=" + createTime +
                ", createOpr=" + createOpr +
                ", updateTime=" + updateTime +
                ", updateOpr=" + updateOpr +
                ", enableFlag=" + enableFlag +
                ", deleteFlag=" + deleteFlag +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookNum=" + bookNum +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
