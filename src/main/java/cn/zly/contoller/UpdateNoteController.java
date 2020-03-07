package cn.zly.contoller;

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
public class UpdateNoteController {
    @Resource(name = "noteService")
    private NoteService noteService;

    @RequestMapping(value = "/update.do" ,method = RequestMethod.POST,produces = "application/json;charset:utf-8")
    @ResponseBody
    public NoteResult execute(@RequestParam("noteId") String noteId, @RequestParam("noteTitle")String noteTitle, @RequestParam("noteBody")String noteBody){
        return noteService.updateNote(noteId,noteTitle,noteBody);
    }
}
