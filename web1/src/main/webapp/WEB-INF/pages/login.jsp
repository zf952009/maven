<%@page contentType="text/html;charset=utf-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form class="layui-form" action="${pageContext.request.contextPath}/user/login" method="post">
    <div class="layui-row">
        <div class="layui-col-xs4">
            <div class="grid-demo grid-demo-bg1">&nbsp;</div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            <div class="grid-demo">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                    <legend>用户登录</legend>
                </fieldset>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入用户名"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <input type="submit" lay-submit lay-filter="demo1" class="layui-btn layui-btn-normal"
                       value="登&nbsp;&nbsp;录" style="width: 100px; margin-left: 100px; margin-top:20px ;"/>
                <a href="/index.php/admin/login/register.html" class="layui-btn" target="_parent"
                   style="margin-top:20px ;">&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;册&nbsp;&nbsp;&nbsp;&nbsp;</a>

            </div>
        </div>
    </div>
</form>
<!--底部分割线-->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
</fieldset>

<link rel="stylesheet" href="${pageContext.request.contextPath}/start/layui/css/layui.css">
<script charset="UTF-8" src="${pageContext.request.contextPath}/start/layui/layui.all.js"></script>
</body>
</html>
