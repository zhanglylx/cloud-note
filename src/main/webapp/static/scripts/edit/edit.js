document.write("<script src='static/scripts/base-value.js'></script>");

function clearEdit() {
    _$emptyInput($("#input_note_title"));
    ueDitor.setContent("");
}

function createNoteOrBook() {
    var button = $("#can").data(create_BookOrNote_button_status);
    var bookId = $("#book_ul .liChecked").data("bookId");
    var userId = $.cookie(user_id_Cookie_key);
    var title = _$getValTrim($("#alert-notebook_noteBookName"));
    if (_$isNullNonZero(title)) {
        alert("笔记名称不能为空");
        return;
    }
    if (_$isNullNonZero(userId)) {
        alert("登录失效");
        _$goToUrlCurrentPage(path_login_page);
        return;
    }
    //新增note笔记名称
    if ($("#createNote").is(button)) {
        if (_$isNullNonZero(bookId)) {
            alert("请选择一个笔记本");
            return;
        }
        _$ajaxPostJSON(
            path_edit_note_add,
            {"userId": userId, "bookId": bookId, "title": title},
            function (response) {
                _$analysisJsonSuccessResponse(response, function (data) {
                    var id = data.cn_note_id;
                    var title = data.cn_note_title;
                    //将标题插入到notelist中
                    $("#note_ul").append(createNoteLi(id, title));
                    alert(response.msg);
                    $(".alert-notebook_div .cancel").click();
                })
            },
            null,
            $(this)
        );
        //    创建book笔记
    } else if ($("#createBook").is(button)) {
        _$ajaxPostJSON(
            path_edit_books_add,
            {"userId": userId, "title": title},
            function (response) {
                _$analysisJsonSuccessResponse(response, function (data) {
                    var bookId = data.cn_notebook_id;
                    var name = data.cn_notebook_name;
                    var $li = createBookLi(bookId, name);
                    //添加在第一个
                    // $("#book_ul").prepend($li);
                    //添加在最后一个
                    $("#book_ul").append($li);
                    alert(response.msg);
                    $(".alert-notebook_div .cancel").click();
                });
            }
        );
    } else {
        alert("系统出现异常");
    }

}