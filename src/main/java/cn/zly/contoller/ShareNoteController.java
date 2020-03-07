package cn.zly.contoller;

import cn.zly.service.ShareService;
import cn.zly.util.NoteResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.faces.annotation.RequestMap;

@Controller
@RequestMapping(value = "/share", produces = "application/json;charset:utf-8")
public class ShareNoteController {
    @Resource
    private ShareService shareService;

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public NoteResult<Object> execute(@RequestParam("noteId") String noteId) {
        return shareService.shareNote(noteId);
    }
}
