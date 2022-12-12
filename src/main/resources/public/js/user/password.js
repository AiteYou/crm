layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);

    form.on('submit(saveBtn)',function (data){
        //所有表单元素的值
        console.log(data.field);
        //发送ajsx请求
        $.ajax({
            type:"post",
            url: ctx + "/user/updatePwd",
            data:{
                oldPassword:data.field.old_password,
                newPassword:data.field.new_password,
                repeatPassword:data.field.again_password
            },
            success:function (result){
                //判断是否修改成功
                if (result.code == 200){
                    //修改密码成功后 清空cookie 跳转到登录界面
                    layer.msg("修改密码成功，系统将在三秒后退出...",function (){
                        //清空cookie
                        $.removeCookie("userIdStr",{domain:"localhost",path:"/crm"});
                        $.removeCookie("userName",{domain:"localhost",path:"/crm"});
                        $.removeCookie("trueName",{domain:"localhost",path:"/crm"});

                        //跳转
                        window.parent.location.href = ctx + "/index";
                    });

                }else {
                    layer.msg(result.msg,{icon:5});
                }
            }

        });

    });



});