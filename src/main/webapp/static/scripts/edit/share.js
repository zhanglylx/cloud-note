function shareButtonClick() {
    //    获取请求参数
    const id = $(this).parents(".ul_functional_domain").prev().data("noteId");
    //发送请求
    _$ajaxPostJSON(
        path_edit_note_share_add,
        {"noteId": id},
        function (response) {
            alert(response.msg);
        }, function () {
            alert("分享失败");
        }
    );
    return false;
};

function searchShare() {
    //    获取请求参数
    const keyword = _$getValTrim($("#right_functional_zone_search_note"));
    _$ajaxPostJSON(
        path_edit_note_share_search,
        {"keyword": keyword},
        function (response) {
            _$analysisJsonSuccessResponse(response, function (data) {
                _$traversalList(data, function (d) {
                    // 获取shareId
                    const shareId = d.cn_share_id;
                    //    获取shareTitle
                    const shareTitle = d.cn_share_title;
                    //    获取li对象
                    const li = "<li><a>" + shareTitle + "</a></li>";
                    const $li = $(li);
                    //    绑定shareId
                    $li.data("share_search_note_shareId", shareId);
                    //    将li对象添加到ul当中
                    $(".share_note_div_ul").append($li);
                })
                $(".share_note_div").show(1300);
            })
        }
    );
}