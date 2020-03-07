package cn.zly.service.Impl;

import cn.zly.dao.NoteDaoMapper;
import cn.zly.dao.ShareDaoMapper;
import cn.zly.entity.Note;
import cn.zly.entity.Share;
import cn.zly.service.ShareService;
import cn.zly.util.NoteResult;
import cn.zly.util.NoteUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("shareService")
public class ShareServiceImpl implements ShareService {
    @Resource
    private NoteDaoMapper noteDaoMapper;
    @Resource
    private ShareDaoMapper shareDaoMapper;

    @Override
    public NoteResult<Object> shareNote(String noteId) {
        NoteResult<Object> noteResult = new NoteResult<>();
        if (StringUtils.isBlank(noteId)) {
            noteResult.setStatus(2);
            noteResult.setMsg("noteId不能为空");
            return noteResult;
        }
        Note note = noteDaoMapper.findByNoteId(noteId);
        if (note == null) {
            noteResult.setStatus(1);
            noteResult.setMsg("noteId没有对应的笔记信息");
            return noteResult;
        }
//        向cn_share表插入数据
        Share share = new Share();
        share.setCn_share_id(NoteUtil.createId());
        share.setCn_note_id(noteId);
        share.setCn_share_title(note.getCn_note_title());
        share.setCn_share_body(note.getCn_note_body());
        shareDaoMapper.save(share);
        noteResult.setStatus(0);
        noteResult.setMsg("分享成功");
        return noteResult;
    }
}
