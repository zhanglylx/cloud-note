document.write("<script src='static/scripts/base-value.js'></script>");


function userLogin() {
    var loginButton = $("#login");
    _$buttonClickUndoable(loginButton, true);
    var count = $("#count").val().trim();
    var password = $("#password").val().trim();
    var count_span = $("#count_span");
    var password_span = $("#password_span");
    var loginArr = [count_span, password_span];

    if (count === "") {
        count_span.text("用户名不能为空");
        _$buttonClickUndoable(loginButton, false);
        return;
    }

    if (password === "") {
        password_span.text("密码不能为空");
        _$buttonClickUndoable(loginButton, false);
        return;
    }
    _$empty(loginArr);
    //    发送请求
    _$ajaxPostJSON(
        path_login,
        {"name": count, "password": $.md5(password)},
        function (result) {
            _$empty(loginArr);
            //    result是服务器返回的JSON结果
            if (result.status === 0) {
                //    将用户信息保存到Cookie
                var userId = result.data.cn_user_id;
                $.cookie(user_id_Cookie_key, userId, {expires: 1});
                _$goToUrlCurrentPage(path_edit);
            } else if (result.status === 1) {
                count_span.text(result.msg);
            } else if (result.status === 2) {
                password_span.text(result.msg);
            } else {
                alert("服务端发生异常")
            }
            _$buttonClickUndoable(loginButton, false);
        },
        function () {
            _$empty(loginArr);
            alert("服务端发生异常");
            _$buttonClickUndoable(loginButton, false);
        }
    );
}
;

/**
 * 点击注册按钮
 */
function register() {
    $("#loginDiv").hide();
    $("#registerDiv").show();
};



