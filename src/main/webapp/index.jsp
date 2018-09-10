<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/26
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<body style="height:100%;width: 100%; background-image: url('${pageContext.request.contextPath}/image/login.jpg')">
    <div >
        <h2 style="color: #4b8c49">
            <span class="glyphicon glyphicon-gift" aria-hidden="true"></span>
            15339&nbsp;龙鸣
        </h2>
        <div style="background-color: white; height: 290px;width: 480px;margin-left: auto;margin-right: auto;margin-top: 60px;">
            <h3 style="height: 45px;padding-top: 22px;color: #444444;">&nbsp;电影租赁管理系统</h3>
            <hr style="color: gray">
            <div style="margin-left: 45px;margin-top: 35px;">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/customer/login" id="formLogin">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="firstName" id="firstName" placeholder="username">
                            <span id="helpBlock2" class="help-block" message="${requestScope.message}">${requestScope.message}</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-info loginBtn">登陆</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    $("#formLogin").ligerForm()
</script>
</html>
