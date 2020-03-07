package cn.zly.service.Impl;

import cn.zly.dao.NoteDaoMapper;
import cn.zly.entity.Note;
import cn.zly.service.NoteService;
import cn.zly.util.NoteResult;
import cn.zly.util.NoteUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Resource(name = "noteDao")
    private NoteDaoMapper noteDao;

    @Override
    public NoteResult<List<Map>> loadBookNotes(String bookId) {
        NoteResult<List<Map>> noteResult = new NoteResult<>();
        if (StringUtils.isBlank(bookId)) {
            noteResult.setStatus(2);
            noteResult.setMsg("bookId不能为空");
            return noteResult;
        }
        noteResult.setData(noteDao.findByBookId(bookId));
        noteResult.setStatus(0);
        noteResult.setMsg("查询成功");
        return noteResult;
    }

    @Override
    public NoteResult<Note> loadNote(String noteId) {
        NoteResult<Note> noteNoteResult = new NoteResult<>();
        if (StringUtils.isBlank(noteId)) {
            noteNoteResult.setStatus(2);
            noteNoteResult.setMsg("noteId不能为空");
            return noteNoteResult;
        }
        Note note = noteDao.findByNoteId(noteId);
        if (note == null) {
            noteNoteResult.setStatus(1);
            noteNoteResult.setMsg("没有查询到数据");
            return noteNoteResult;
        }
        noteNoteResult.setData(note);
        noteNoteResult.setStatus(0);
        noteNoteResult.setMsg("查询成功");
        return noteNoteResult;
    }

    @Override
    public NoteResult updateNote(String noteId, String noteTitle, String noteBody) {
        NoteResult noteResult = new NoteResult();
        noteResult.setStatus(2);
        if (StringUtils.isBlank(noteId)) {
            noteResult.setMsg("noteId不能为空");
            return noteResult;
        }
        if (StringUtils.isBlank(noteTitle)) {
            noteResult.setMsg("noteTitle不能为空");
            return noteResult;
        }
        if (StringUtils.isBlank(noteTitle)) {
            noteResult.setMsg("noteBody不能为空");
            return noteResult;
        }
        Note note = new Note();
        note.setCn_note_id(noteId);
        note.setCn_note_title(noteTitle);
        note.setCn_note_body(noteBody);
        note.setCn_note_last_modify_time(System.currentTimeMillis());
        if (noteDao.updateNote(note) == 1) {
            noteResult.setStatus(0);
            noteResult.setMsg("保存成功");
        } else {
            noteResult.setStatus(1);
            noteResult.setMsg("保存失败");
        }
        return noteResult;
    }

    @Override
    public NoteResult<Note> addNote(String userId, String bookId, String title) {
        NoteResult<Note> noteNoteResult = new NoteResult<>();
        noteNoteResult.setStatus(2);
        if (StringUtils.isBlank(userId)) {
            noteNoteResult.setMsg("userId不能为空");
            return noteNoteResult;
        }
        if (StringUtils.isBlank(bookId)) {
            noteNoteResult.setMsg("bookId不能为空");
            return noteNoteResult;
        }
        if (StringUtils.isBlank(title)) {
            noteNoteResult.setMsg("title不能为空");
            return noteNoteResult;
        }
        Note note = new Note();
        note.setCn_user_id(userId);
        note.setCn_notebook_id(bookId);
        note.setCn_note_title(title);
        note.setCn_note_id(NoteUtil.createId());
        note.setCn_note_body("");
//        1,正常  2.删除
        note.setCn_note_status_id(1);
//        类型:1 - 正常
        note.setCn_note_create_time(System.currentTimeMillis());
        try {
            noteDao.save(note);
            noteNoteResult.setStatus(0);
            noteNoteResult.setMsg("创建成功");
            noteNoteResult.setData(note);
            return noteNoteResult;
        } catch (Exception e) {
            e.printStackTrace();
            noteNoteResult.setStatus(1);
            noteNoteResult.setMsg("创建失败");
            return noteNoteResult;
        }
    }
}
