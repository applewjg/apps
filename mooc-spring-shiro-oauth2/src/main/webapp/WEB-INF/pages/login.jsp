<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC Demo 首页</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        function doLogin(){
            var url = "/auth/checklogin";
            var username= $("input[name='username']").val();
            var password= $("input[name='password']").val();
            $.ajax({
                url:url,
                type:"POST",
                data:"j_username="+username+"&j_password="+password,
                success: function(data){
                    $("#results").text(data);
                }
            });
        }
    </script>
</head>
<body>


<div class="container">
    <h1>Welcome</h1>

    <h3>请登录</h3>

    <hr/>
    <form:form action="./login.do"  method="post" commandName="userlogin" role="form">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter username:"/>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="Enter password:"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success" onclick="doLogin()">登录</button> <button href="register.do?method=init" class="btn btn-sm btn-success">注册新用户</button>
        </div>
    </form:form>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
