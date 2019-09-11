<%@page language="java" pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Hello World!</h2>

<h2>传统文件上传</h2>
<h4>file updolad</h4>
<form method="post" enctype="multipart/form-data" action="user/fileUP">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>

<h4>file updolad SpringMVC</h4>
<form method="post" enctype="multipart/form-data" action="user/springMVCFileUP">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>


<table>

</table>
<link rel="stylesheet" href="start/layui/css/layui.css">
<script rel="script" charset="UTF-8" src="start/layui/layui.js"></script>
<script>
    layui.use(['layer', 'laydate', 'jquery'], function () {
        var $ = layui.$
            , layer = layui.layer
            , laydate = layui.laydate;
        $(document).ready(function () {
            $.ajax({
                url: "/web6/user/index",
                dateType: "json",
                success: function (data) {
                    console.log(data);
                },
                error: function () {
                    alert("error");
                },
            });
        });
    });

</script>
</body>
</html>
