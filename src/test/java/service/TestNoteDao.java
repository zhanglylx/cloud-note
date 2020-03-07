package service;

import cn.zly.service.NoteService;
import dao.BaseTest;
import org.junit.Test;

public class TestNoteDao implements BaseTest {
        private NoteService noteService =ac.getBean("noteService",NoteService.class);
    @Test
    public void testShow(){
        System.out.println(noteService.loadNote("11111111"));
    }

    @Test
    public void testUpdateNote(){
        System.out.println(noteService.updateNote("1","ttttt","asf第三方第三方"));
    }
}
