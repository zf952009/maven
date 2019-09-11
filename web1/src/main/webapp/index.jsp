<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
<title>in</title>
<body>
<h2>Hello World!</h2>
<a href="api/index">spring run...</a>
<hr>
<a href="user/login">登录</a>


<div id="message">
    <ul>
        <li v-for="itme in massage">
            {{itme.name}},{{itme.password}},{{itme.res}}
        </li>
    </ul>
</div>
<script charset="UTF-8" src="${pageContext.request.contextPath}/start/jquery-3.4.1.js"></script>
<script charset="UTF-8" src="${pageContext.request.contextPath}/start/vue.min.js"></script>
<script>


</script>


<script>
    $(document).ready(function () {
        var data = new Vue({
            el: "#message",
            data: {
                massage: [{name: "邹芳1", password: "123456", res: 0}, {name: "邹芳2", password: "123456", res: 0}]
            }
        });
        $.ajax({
            url: 'user/ajaxTest',
            type: "post",
            dataType: "json",
            data: {
                name: "邹芳",
                password: "zoufang",
                res: 0
            },
            success: function (message) {
                console.log(message);
            },
            error: function () {
                alert("error");
            }

        });
    });
</script>

</body>
</html>
