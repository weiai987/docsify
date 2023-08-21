package org.hopu.djp.libDemo.dao;

import org.hopu.djp.libDemo.entity.Book;
import org.hopu.djp.libDemo.entity.Note;

import java.sql.ResultSet;
import java.util.List;

public interface INoteDao {
    //    新增借阅记录
    int addOne(Note note, int oprId);
    //    查看所有记录
    List<Note> findAll();
    //    查看指定记录
    Note findById(int noteId);
    List<Note> findList(Note note);
    //    修改指定记录
    int editOne(Note book, int oprId);
    //    删除指定记录
    int delOneById(int noteId, int oprId);
    //    禁用/启用指定记录
    int enableById(int noteId, Boolean b, int oprId);
    //    从结果集转换成实体类
    Note toNote(ResultSet rs);
}
