package cn.zly.service;

import cn.zly.entity.Share;
import cn.zly.util.NoteResult;

import java.util.List;

public interface ShareService {
    NoteResult<Object> shareNote(String noteId);

    NoteResult<List<Share>> searchNote(String keyword);
}
