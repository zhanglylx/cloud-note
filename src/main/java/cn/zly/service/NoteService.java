package cn.zly.service;

import cn.zly.entity.Note;
import cn.zly.util.NoteResult;

import java.util.List;
import java.util.Map;

public interface NoteService {
    NoteResult<List<Map>> loadBookNotes(String bookId);

    NoteResult<Note> loadNote(String noteId);

    NoteResult updateNote(String noteId, String noteTitle, String noteBody);

    NoteResult<Note> addNote(String userId, String bookId, String title);
}
