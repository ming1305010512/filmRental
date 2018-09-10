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
    <title>用户新增</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/showBo.css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/showBo.js"></script>
<body style="height:100%;width: 100%;">
    <div style="height: 48px;width: 100%;background-color: #1b6d85;padding-top: 9px;" class="row">
        <div class="col-md-4">
                <span style="color: #4b8c49;font-size: 23px;">
                &nbsp;&nbsp;
                <span class="glyphicon glyphicon-gift" aria-hidden="true"></span>
                15339&nbsp;龙鸣
                </span>
        </div>
        <div class="col-md-1 col-md-offset-7">
            <a href="${pageContext.request.contextPath}/customer/logout" type="button" class="btn btn-primary" aria-label="Left Align">
                <span class=" glyphicon glyphicon-user" aria-hidden="true" style="color: #2e6da4"></span>
                <span>Admin</span>
            </a>
        </div>
    </div>
    <%--导航栏--%>
    <div class="row">

        <%--导航栏--%>
        <div class="col-md-2 " style="margin-left: -15px;">
            <div style="width: 233px;border: 1px solid #f7ffd8;height: 97%;background-color: #f7ffd8">
                <nav class="navbar navbar-default">
                    <ul class="nav nav-pills nav-stacked" role="tablist" style="width: 230px;">
                        <li role="presentation" class="active">
                            <a href="#addcustomer" data-toggle="tab" role="tab" id="addcustomerLink">
                                <div class="row">
                                    <div class="col-md-8">
                                        <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
                                        <span>创建Customer</span>
                                    </div>
                                    <div class="col-md-1 col-md-offset-1">
                                        <span>&gt;</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li role="presentation" class="" >
                            <a href="#manageSet" data-toggle="tab" id="manageSetLink">
                                <div class="row">
                                    <div class="col-md-8">
                                        <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
                                        <span>管理设置</span>
                                    </div>
                                    <div class="col-md-1 col-md-offset-1">
                                        <span>&gt;</span>
                                    </div>
                                </div>
                            </a>
                        </li>

                        <li role="presentation" class="" >
                            <a href="#applicationSet" data-toggle="tab" id="applicationSetLink">
                                <div class="row">
                                    <div class="col-md-8">
                                        <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
                                        <span>应用设置设置</span>
                                    </div>
                                    <div class="col-md-1 col-md-offset-1">
                                        <span>&gt;</span>
                                    </div>
                                </div>
                            </a>
                        </li>

                        <li role="presentation" class="" >
                            <a href="#mainDataSet" data-toggle="tab" id="mainDataSetSetLink">
                                <div class="row">
                                    <div class="col-md-8">
                                        <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
                                        <span>主数据管理</span>
                                    </div>
                                    <div class="col-md-1 col-md-offset-1">
                                        <span>&gt;</span>
                                    </div>
                                </div>
                            </a>
                        </li>

                        <li role="presentation" class="" >
                            <a href="#customerOrderManage" data-toggle="tab" id="customerOrderManageLink">
                                <div class="row">
                                    <div class="col-md-8">
                                        <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
                                        <span>客户订单管理</span>
                                    </div>
                                    <div class="col-md-1 col-md-offset-1">
                                        <span>&gt;</span>
                                    </div>
                                </div>
                            </a>
                        </li>

                        <li role="presentation" class="" >
                            <a href="#diliverManage" data-toggle="tab" id="diliverManageLink">
                                <div class="row">
                                    <div class="col-md-8">
                                        <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
                                        <span>发货单管理</span>
                                    </div>
                                    <div class="col-md-1 col-md-offset-1">
                                        <span>&gt;</span>
                                    </div>
                                </div>
                            </a>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>
        <div class="col-md-10" style="background-color: white;height: 500px;background-color: #d4d4d4;margin-left: 0px;">


            <div class="tab-content mycontent">
                <div class="tab-pane active " id="addcustomer">

                    <%--标题--%>
                    <div class="row">
                        <div class="col-md-12">
                            <h3>customer创建</h3>
                            <hr style="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">基本信息</h3>
                                </div>
                                <div class="panel-body">
                                    <div style="margin-left: -20px;margin-top: 0px;">
                                        <form class="form-horizontal" action="" id="addCustomerForm">
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">First Name<span style="color: red;font-size: 15px;">&nbsp;*</span></label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="firstName" id="firstName" placeholder="firstName" value="">
                                                    <span class="help-block"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Last Name<span style="color: red;font-size: 15px;">&nbsp;*</span></label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="lastName" id="lastName" placeholder="lastName">
                                                    <span class="help-block"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Email</label>
                                                <div class="col-sm-4">
                                                    <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                                                    <span class="help-block"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">address<span style="color: red;font-size: 15px;">&nbsp;*</span></label>
                                                <div class="col-sm-4">
                                                    <select class="form-control" name="address" id="address" size="1">
                                                        <c:forEach items="${requestScope.addressList}" var="address">
                                                            <option value="${address.address}">${address.address}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                            <%--store_id,默认--%>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <input type="hidden" class="form-control" name="storeId" id="storeId" value="1" placeholder="Email">
                                                    <span class="help-block"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-1">
                                                    <a type="submit" class="btn btn-info btn-sm" href="#" id="addSubmitBtn">新增</a>
                                                </div>
                                                <div class=" col-sm-1">
                                                    <a type="submit" class="btn btn-info btn-sm" href="#">取消</a>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane " id="applicationSet">
                    应用设置
                </div>

                <div class="tab-pane" id="manageSet">
                    管理设置
                </div>
                <div class="tab-pane" id="mainDataSet">
                    主数据设置
                </div>
                <div class="tab-pane" id="customerOrderManage">
                    客户订单管理
                </div>
                <div class="tab-pane" id="diliverManage">
                    发货管理
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    $(document).ready(function () {

    });
    $("#firstName").blur(function () {
        validateFirstName();
    });
    $("#lastName").blur(function () {
        validateLastName();
    });
    $("#email").blur(function () {
        validateEmail();
    });

    //添加用户时firstName的校验
    function validateFirstName() {

        $("#firstName").parent().removeClass("has-error has-success");
//        $("#firstName").find(".help-block").text("");
        //获取表单name的值
        // alert()
        var firstName=$("#firstName").val();
        var regExpName=/(^[a-zA-Z0-9_-]{3,10}$)|(^[\u2E80-\u9FFF]{1,2}$)/;
        if(firstName==""){
            $("#firstName").parent().addClass("has-error")
            $("#firstName").next("span").text("firstName不能为空")
            return false;
        }else {
            if (!regExpName.test(firstName)) {
                $("#firstName").parent().addClass("has-error")
                $("#firstName").next("span").text("必须为3到10个英文字符或1到2个中文字符")
                return false;
            } else {
                $.ajax("/customer/isCustomerExist", {
                    type: "POST",
                    data: "firstName=" + firstName,
                    success: function (result) {
                        //用户名可用
                        if (result.code == 100) {
                            $("#firstName").parent().addClass("has-success")
                            $("#firstName").next("span").text("")
                            return true;
                            //保存按钮增加校验属性，设置为success
                        } else {
                            $("#firstName").parent().addClass("has-error")
                            $("#firstName").next("span").text("用户名以存在")
                            return false;
                        }
                    }
                });
            }
        }

    }

    //lastName校验
    function validateLastName() {
        $("#lastName").parent().removeClass("has-error has-success");
        //获取表单name的值
        // alert()
        var lastName=$("#lastName").val();
        var regExpName=/(^[a-zA-Z0-9_-]{3,10}$)|(^[\u2E80-\u9FFF]{1,2}$)/

        if(lastName==""){
            $("#lastName").parent().addClass("has-error")
            $("#lastName").next("span").text("lastName不能为空")
        }else {
            if (!regExpName.test(lastName)) {
                $("#lastName").parent().addClass("has-error")
                $("#lastName").next("span").text("必须为3到10个英文字符或1到2个中文字符")
                return false;
            } else {
                $("#lastName").parent().addClass("has-success")
                $("#lastName").next("span").text("")
                return true;
            }
        }

    }
    //email校验
    function validateEmail() {
        $("#email").parent().removeClass("has-error has-success");
        //获取表单name的值
        // alert()
        var lastName=$("#email").val();
        var regExpName=/^[a-zA-Z\d]+(\.[a-zA-Z\d]+)*@([\da-zA-Z](-[\da-zA-Z])?)+(\.{1,2}[a-zA-Z]+)+$/

        if(lastName==""){
            $("#email").parent().addClass("has-error")
            $("#email").next("span").text("email不能为空")
        }else {
            if (!regExpName.test(lastName)) {
                $("#email").parent().addClass("has-error")
                $("#email").next("span").text("邮箱格式不正确")
                return false;
            } else {
                $("#email").parent().addClass("has-success")
                $("#email").next("span").text("")
                return true;
            }
        }

    }

    //服务器端校验
    $("#addSubmitBtn").click(function () {

        //先进行客户端校验
        validateFirstName();
        validateLastName();
        validateEmail();

        //获取表单数据
        var customerData = $("#addCustomerForm").serialize();
        $.ajax("${pageContext.request.contextPath}/customer/addCustomerSubmit", {
            type: "POST",
            data: customerData,
            success: function (result) {
                var fieldError = result.userContent.fieldErrors
                if(result.code == 100)
                {
                    Showbo.Msg.alert('新增成功!');
                    $("#addCustomerForm").attr("action","${pageContext.request.contextPath}/customer/customerShow")
                    $("#addCustomerForm").submit();
                }else
                {
                    console.log(result);
                    $.each(fieldError,function (index,fielderror) {
                        if(fielderror.field=="firstName"){
                            $("#firstName").parent().addClass("has-error")
                            $("#firstName").next("span").text("必须为3到10个英文字符或1到2个中文字符")
                            return false;
                        }
                        if (fielderror.field=="lastName"){
                            $("#lastName").parent().addClass("has-error")
                            $("#lastName").next("span").text("必须为3到10个英文字符或1到2个中文字符");
                            return false;
                        }
                        if(fielderror.field=="email"){
                            $("#email").parent().addClass("has-error")
                            $("#email").next("span").text("邮箱格式不正确")
                            return false;
                        }
                    })
                }
            }
        });
    });
</script>
</html>
