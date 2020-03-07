package cn.zly.service;

import cn.zly.util.NoteResult;

public interface ShareService {
    NoteResult<Object> shareNote(String noteId);
}
