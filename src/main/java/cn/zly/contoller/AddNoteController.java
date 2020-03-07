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

@Controller
@RequestMapping("/note")
public class AddNoteController {
    @Resource(name = "noteService")
    private NoteService noteService;

    @RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "application/json;charset:utf-8")
    @ResponseBody
    public NoteResult<Note> execute(
            @RequestParam("userId") String userId
            ,  @RequestParam("bookId")String bookId
            , @RequestParam("title") String title) {
        return noteService.addNote(userId,bookId,title);
    }
}
