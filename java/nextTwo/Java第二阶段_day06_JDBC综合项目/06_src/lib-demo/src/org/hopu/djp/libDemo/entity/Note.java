package org.hopu.djp.libDemo.entity;

import java.time.LocalDateTime;

/**
 * 借阅记录实体类，对应数据库表名为 lib_note
 * DROP TABLE IF EXISTS `lib_note`;
 * CREATE TABLE `lib_note`  (
 *   `note_id` int(11) NOT NULL AUTO_INCREMENT,
 *   `note_type` int(11) NULL DEFAULT NULL,
 *   `user_id` int(11) NULL DEFAULT NULL,
 *   `book_id` int(11) NULL DEFAULT NULL,
 *   `book_num` int(11) NULL DEFAULT NULL,
 *   `book_action_time` datetime(0) NULL DEFAULT NULL,
 *   `book_action_status` int(11) NULL DEFAULT NULL,
 *   `create_opr` int(11) NULL DEFAULT NULL,
 *   `update_time` datetime(0) NULL DEFAULT NULL,
 *   `update_opr` int(11) NULL DEFAULT NULL,
 *   `enable_flag` int(11) NULL DEFAULT NULL,
 *   `delete_flag` int(11) NULL DEFAULT NULL,
 *   PRIMARY KEY (`note_id`) USING BTREE
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 */
public class Note extends BaseEntity {
    // 主键，唯一编号
    private int noteId;
    // 操作类型，01-借书，02-还书
    private int noteType;
    // 发起用户ID
    private int userId;
    // 目标图书ID
    private int bookId;
    // 借书/还书数量
    private int bookNum;
    // 申请发起时间
    private LocalDateTime bookActionTime;
    // 申请处理状态，01-未审批，02-审批通过，03-审批驳回
    private int bookActionStatus;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getNoteType() {
        return noteType;
    }

    public void setNoteType(int noteType) {
        this.noteType = noteType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public LocalDateTime getBookActionTime() {
        return bookActionTime;
    }

    public void setBookActionTime(LocalDateTime bookActionTime) {
        this.bookActionTime = bookActionTime;
    }

    public int getBookActionStatus() {
        return bookActionStatus;
    }

    public void setBookActionStatus(int bookActionStatus) {
        this.bookActionStatus = bookActionStatus;
    }

    @Override
    public String toString() {
        return "Note{" +
                "createTime=" + createTime +
                ", createOpr=" + createOpr +
                ", updateTime=" + updateTime +
                ", updateOpr=" + updateOpr +
                ", enableFlag=" + enableFlag +
                ", deleteFlag=" + deleteFlag +
                ", noteId=" + noteId +
                ", noteType=" + noteType +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", bookNum=" + bookNum +
                ", bookActionTime=" + bookActionTime +
                ", bookActionStatus=" + bookActionStatus +
                '}';
    }
}
