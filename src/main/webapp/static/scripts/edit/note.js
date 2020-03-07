document.write("<script src='static/scripts/base-value.js'></script>");

function createNoteLi(noteId, noteTitle) {
    var sli = "<li>" + noteTitle + "<button class='li_button'>V</button><div class='clear_float'></div></li>"
        + createNoteFunctionDl();
    var $sli = $(sli);
    $sli.data("noteId", noteId);
    return $sli;
};

//加载笔记
function loadNoteBook() {
    //设置选中效果
    $("#book_ul li").removeClass();
    //设置选中效果
    $(this).addClass("liChecked");
    //删除功能区，如果当前元素下展示功能区，则不删除
    if ($(this).next().attr("class") !== "ul_functional_domain") {
        $(".ul_functional_domain").remove();
    }

    _$buttonClickUndoable($("#createNote"), false);
    //禁用保存按钮
    _$buttonClickUndoable($("#saveNote"), true);
    $("#saveNote").removeClass();
    $("#saveNote").css("color", "");
    //删除title和笔记内容
    clearEdit();
    var bookId = $(this).data("bookId");
    _$buttonClickUndoable($(this), true);
    //   发送ajax
    _$ajaxPostJSON(
        path_edit_note,
        {"bookId": bookId},
        function (response) {
            //    获取笔记信息
            var notes = response.data;
            _$empty($("#note_ul"))
            for (var i = 0; i < notes.length; i++) {
                var noteId = notes[i].cn_note_id;
                var noteTitle = notes[i].cn_note_title;
                $("#note_ul").append(createNoteLi(noteId, noteTitle));
            }
        },
        function () {
            alert("笔记内容加载失败");
        }
    );
};

//显示笔记信息
function loadNote() {
    //设置选中效果
    $("#note_ul li").removeClass()
    //设置选中效果
    $(this).addClass("liChecked");
    //删除功能区，如果当前元素下展示功能区，则不删除
    if ($(this).next().attr("class") !== "ul_functional_domain") {
        $(".ul_functional_domain").remove();
    }
    $("#saveNote").addClass("liChecked");
    $("#saveNote").css("color", "beige");
    //开启笔记可点击
    _$buttonClickUndoable($("#saveNote"), false);
    clearEdit();
    //获取请求参数
    var noteId = $(this).data("noteId");
    if (!noteId) {
        alert("获取笔记id失败");
        return;
    }
    //发送ajax请求
    _$ajaxPostJSON(
        path_edit_note_load,
        {"noteId": noteId},
        function (response) {
            if (response.status === 0) {
                //获取返回的笔记标题
                var title = response.data.cn_note_title;
                //    获取返回的笔记内容
                var body = response.data.cn_note_body;
                //    设置笔记标题
                $("#input_note_title").val(title);
                //    设置笔记内容
                ueDitor.setContent(body);
            } else {
                alert(response.msg);
            }
        },
        function () {
            alert("获取笔记信息失败");
        }
    )
};

/**
 * 更新笔记
 */
function updateNote() {
    var title = _$getValTrim($("#input_note_title"));
    var body = ueDitor.getContent();
    var noteId = $("#note_ul li.liChecked").data("noteId");
    _$ajaxPostJSON(
        path_edit_note_update,
        {"noteTitle": title, "noteBody": body, "noteId": noteId},
        function (response) {
            if (response.status === 0) {
                $("#note_ul li.liChecked").text(title);
                alert("保存成功");
            } else {
                alert(response.msg);
            }
        },
        function () {
            alert("保存笔记失败，服务器异常")
        },
        $("#saveNote")
    )
    ;
};

/**
 * 弹出新建笔记本对话框
 */
function alertAddBookWindows() {
    //弹出新建笔记本对话框
    $("#can").load("static/alert/alert-notebook.html");
    $("#can").data(create_BookOrNote_button_status, $(this));
    //显示背景
    $(".opacity_bg").show();
    $("#can").show();
}

function closeAlertAddBookWindows() {
    $("#can").hide();
    $(".opacity_bg").hide();
}

/**
 * 创建功能区
 * @returns {string}
 */
function createNoteFunctionDl() {
    var f = '<div class="ul_functional_domain" style="display: none"><dl class="ul_dl" style="float: right">' +
        '  <dt><button class="ul_dl_delete" style="color: red">删除</button></dt>' +
        ' <dt><button class="ul_dl_move">移动</button></dt>' +
        ' <dt><button class="ul_dl_share">分享</button></dt>' +
        '</dl></div><div class=\'clear_float\'></div>';
    return f;
};