package cn.zly.contoller;

import cn.zly.entity.Note;
import cn.zly.service.NoteService;
import cn.zly.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
    @Resource(name = "noteService")
    NoteService noteService;

    @RequestMapping(value = "/loadnotes.do", method = RequestMethod.POST, produces = "application/json;charset:utf-8")
    @ResponseBody
    public NoteResult<List<Map>> loadNotes(@RequestParam(name = "bookId") String bookId) {
        return noteService.loadBookNotes(bookId);
    }


    @RequestMapping(value = "/load.do", method = RequestMethod.POST, produces = "application/json;charset:utf-8")
    @ResponseBody
    public NoteResult<Note> loadNote(@RequestParam(name = "noteId") String noteId) {

        return noteService.loadNote(noteId);
    }
}
