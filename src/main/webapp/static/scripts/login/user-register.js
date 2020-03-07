document.write("<script src='static/scripts/base-value.js'></script>");

/**
 * 点击注册提交按钮
 */
function registerSubmit() {
    var registerSubmit = $("#registerSubmit");
    _$buttonClickUndoable(registerSubmit, true);
    var registerNameSpan = $("#registerNameSpan");
    var registerPasswordSpan = $("#registerPasswordSpan");
    var registerPasswordAffirmSpan = $("#registerPasswordAffirmSpan");
    _$empty(registerNameSpan, registerPasswordSpan, registerPasswordAffirmSpan);
    var name = _$getValTrim($("#registerName"));
    var nike = _$getValTrim($("#registerNike"));
    var passwprd = _$getValTrim($("#registerPassword"));
    var final_passwprd = _$getValTrim($("#registerPasswordAffirm"));
    //    检查数据格式
    if (name === "") {
        registerNameSpan.text("用户名不能为空");
        _$buttonClickUndoable(registerSubmit, false);
        return;
    }
    //    检查密码:非空  不能小于6位
    if (passwprd === "") {
        registerPasswordSpan.text("密码不能为空");
        _$buttonClickUndoable(registerSubmit, false);
        return;
    } else if (passwprd.length > 0 && passwprd.length < 6) {
        registerPasswordSpan.text("密码不能小于6位");
        _$buttonClickUndoable(registerSubmit, false);
        return;
    }
    //    检测确认密码:非空，是否与密码一致
    if (final_passwprd !== passwprd) {
        registerPasswordAffirmSpan.text("密码不一致");
        _$buttonClickUndoable(registerSubmit, false);
        return;
    }

    //开始发送请求
    _$ajaxPostJSON(
        path_login_add,
        {"name": name, "nick": nike, "password": $.md5(passwprd)},
        function (response) {
            if (response.status === 0) {
                alert(response.msg);
                //返回到登录页面
                $("#registerCancel").click();
            } else if (response.status === 1) {
                registerNameSpan.text(response.msg);
            } else {
                alert(response.msg);
            }

        },
        function () {
            alert("注册失败");
        },
        registerSubmit
    );


};

/**
 * 点击注册取消按钮
 */
function registerCancel() {
    $("#loginDiv").show();
    $("#registerDiv").hide();

};

function registerPasswordAffirm() {
    var registerPasswordText = $("#registerPassword").val();
    var registerPasswordAffirmText = $("#registerPasswordAffirm").val();
    if (registerPasswordText !== registerPasswordAffirmText) {
        $("#registerPasswordAffirmSpan").text("密码不一致");
    } else {
        _$empty($("#registerPasswordAffirmSpan"));
    }
};