document.write("<script src='static/scripts/base-value.js'></script>");

function loadUserBooks() {
    //获取userId
    var userId = $.cookie(user_id_Cookie_key);
//    判断是否获取到有效userId
    if (!userId) {
        alert("用户id获取失败");
        _$goToUrlCurrentPage(path_login_page);
        return;
    }
    _$ajaxPostJSON(
        path_edit_books,
        {"userId": userId},
        function (response) {
            if (response.status === 0) {
                var book;
                var bookId;
                var bookName;
                for (i = 0; i < response.data.length; i++) {
                    book = response.data[i];
                    bookId = book.cn_notebook_id;
                    bookName = book.cn_notebook_name;
                    $("#book_ul").append(createBookLi(bookId, bookName));
                }
            }

        },
        function () {
            alert("笔记本加载失败")
        }
    )

};

/**
 *
 * @param bookId
 * @param bookName
 */
function createBookLi(bookId, bookName) {
    var li = "<li>" +
        "<a>" +
        "<i>" +
        "</i>" +
        bookName +
        "</a>" +
        "<button class='li_button'>V</button><div class='clear_float'></div></li>" +
        createBookFunctionDl();
    var $li = $(li);
    //将bookId值与jquery对象绑定
    $li.data("bookId", bookId);
    return $li;
};

/**
 * 创建功能区
 * @returns {string}
 */
function createBookFunctionDl() {
    var f = '<div class="ul_functional_domain" style="display: none"><dl class="ul_dl" style="float: right">' +
        '  <dt><button class="ul_dl_delete" style="color: red">删除</button></dt>' +
        ' <dt><button class="ul_dl_move">移动</button></dt>' +
        '</dl></div><div class=\'clear_float\'></div>';
    return f;
};

