package cn.zly.service.Impl;

import java.util.HashMap;

import cn.zly.dao.NoteDaoMapper;
import cn.zly.dao.ShareDaoMapper;
import cn.zly.entity.Note;
import cn.zly.entity.Share;
import cn.zly.service.ShareService;
import cn.zly.util.NoteResult;
import cn.zly.util.NoteUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.util.List;
import java.util.Map;

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

        try {
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
        } catch (DuplicateKeyException e) {
            noteResult.setStatus(1);
            noteResult.setMsg("您已经分享过此条笔记");
        }
        return noteResult;
    }

    @Override
    public NoteResult<List<Share>> searchNote(String keyword, Integer page) {
        NoteResult<List<Share>> noteResult = new NoteResult<>();
        if (page == null) {
            noteResult.setMsg("page不能为空");
            return noteResult;
        }
        if (StringUtils.isBlank(keyword)) {
            keyword = "";
        }
        String title = "%" + keyword + "%";
        int begin = (page - 1) * 3;//计算抓取起点的记录
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("begin", begin);
        List<Share> list = shareDaoMapper.findLikeTitle(params);
        if (list == null || list.size() == 0) {
            noteResult.setMsg("没有查询到任何搜索分享");
            noteResult.setStatus(1);
            return noteResult;
        }
        noteResult.setStatus(0);
        noteResult.setMsg("查询成功");
        noteResult.setData(list);
        return noteResult;
    }
}
