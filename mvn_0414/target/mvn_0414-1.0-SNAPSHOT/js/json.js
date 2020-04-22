function testJson(){
    //获得参数值
    var name =$("#name").val();
    var pwd =$("#pwd").val();
    alert(name+"=>"+pwd);

    //
    // $.getJSON("/user/json1",{"uname":name,"upass":pwd},function(data){
    //    // alert(data.uname+"==>"+alert(data.upass));
    //    alert(data);
    // });


    $.ajax({
        //请求路径
        url : "myjson",
        //请求类型
        type : "post",
        //data表示发送的数据
        data : {
            "uname" : name,
            "upass" : pwd
        }, //定义发送请求的数据格式为JSON字符串
        contentType : "application/json;charset=utf-8",
        //定义回调响应的数据格式为JSON字符串，该属性可以省略
        dataType : "json",
        //成功响应的结果
        success : function(data) {
            if (data != null) {
                alert("用户名：" + data.uname + "，密码：" + data.upass);
            }
        }
    });

}