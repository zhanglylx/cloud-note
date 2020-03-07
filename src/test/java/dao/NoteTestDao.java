package dao;

import cn.zly.dao.NoteDaoMapper;
import cn.zly.entity.Note;
import org.junit.Test;

public class NoteTestDao implements BaseTest {
    private NoteDaoMapper noteDao = ac.getBean("noteDao", NoteDaoMapper.class);

    @Test
    public void testFindByBookId() {
        System.out.println(noteDao.findByBookId("1"));
        System.out.println(noteDao.findByBookId("1").get(0).get("cn_note_id"));
    }

    @Test
    public void testFindByNoteId() {
        System.out.println(noteDao.findByNoteId("11111111"));
    }

    @Test
    public void testUpdateNote() {
        Note note = noteDao.findByNoteId("1");
        note.setCn_note_body("水电费第三方第三方收到");
        note.setCn_note_title("sfd");
        note.setCn_note_last_modify_time(System.currentTimeMillis());
        System.out.println(noteDao.updateNote(note));
    }

}
