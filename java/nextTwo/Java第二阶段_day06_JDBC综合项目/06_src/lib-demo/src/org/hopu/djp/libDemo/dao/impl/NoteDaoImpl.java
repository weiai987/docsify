package org.hopu.djp.libDemo.dao.impl;

import org.hopu.djp.libDemo.dao.INoteDao;
import org.hopu.djp.libDemo.entity.Note;

import java.sql.ResultSet;
import java.util.List;

public class NoteDaoImpl implements INoteDao {
    @Override
    public int addOne(Note note, int oprId) {
        return 0;
    }

    @Override
    public List<Note> findAll() {
        return null;
    }

    @Override
    public Note findById(int noteId) {
        return null;
    }

    @Override
    public List<Note> findList(Note note) {
        return null;
    }

    @Override
    public int editOne(Note book, int oprId) {
        return 0;
    }

    @Override
    public int delOneById(int noteId, int oprId) {
        return 0;
    }

    @Override
    public int enableById(int noteId, Boolean b, int oprId) {
        return 0;
    }

    @Override
    public Note toNote(ResultSet rs) {
        return null;
    }
}
