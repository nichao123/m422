$(function () {

    //单击事件
    $("[name=\"but\" ]").click(function () {
        //无刷新
        $.get("login",$("#frm").serialize(),function (data) {
          //  alert(data);
            if (data == 1) {
                $("#nameDiv").html("登录成功！！").css("color", "blue");
            } else {
                $("#nameDiv").html("登录失败！").css("color", "red");
            }
        });
    });
});