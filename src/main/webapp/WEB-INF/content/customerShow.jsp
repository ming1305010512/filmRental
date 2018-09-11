<%--
  Created by IntelliJ IDEA.
  User: 龙鸣
  Date: 2017/8/26
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/showBo.css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/showBo.js"></script>
<body style="height:100%;width: 100%;" class="container">

<!-- Modal -->
<div class="modal fade" id="editModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header" style="background-color: black;">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title" id="myModalLabel" style="color: white;margin-left: 200px;">customer编辑</h3>
            </div>
            <div class="modal-body">
                <div style="margin-top: 40px;">
                    <form class="form-horizontal" action="" id="editeCustomerForm">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">First Name<span style="color: red;font-size: 15px;">&nbsp;*</span></label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="firstName" id="firstName" placeholder="firstName" value="">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Last Name<span style="color: red;font-size: 15px;">&nbsp;*</span></label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="lastName">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-6">
                                <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">address<span style="color: red;font-size: 15px;">&nbsp;*</span></label>
                            <div class="col-sm-6">
                                <select class="form-control" name="address" id="address" size="1">

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
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="editeCustomer">编辑</button>
            </div>
        </div>
    </div>
</div>
    <%--页头--%>
    <div style="height: 48px;width: 1339px;background-color: #1b6d85;padding-top: 9px;" class="row">
        <div class="col-md-4">
            <span style="color: #4b8c49;font-size: 23px;">
            &nbsp;&nbsp;
            <span class="glyphicon glyphicon-gift" aria-hidden="true"></span>
            15339&nbsp;龙鸣
            </span>
        </div>
        <div class="col-md-1 col-md-offset-6">
            <a href="${pageContext.request.contextPath}/customer/logout" type="button" class="btn btn-primary" aria-label="Left Align" style="margin-left: 60px;">
                <span class=" glyphicon glyphicon-user" aria-hidden="true" style="color: #2e6da4"></span>
                <span>Admin</span>
            </a>
        </div>
    </div>

    <div style="width: 1325px">
        <div class="row">
            <%--导航栏--%>
            <div class="col-md-2 " style="margin-left: -15px;">
                <div style="width: 233px;border: 1px solid #f7ffd8;height: 97%;background-color: #f7ffd8">
                    <nav class="navbar navbar-default">
                        <ul class="nav nav-pills nav-stacked" role="tablist" style="width: 230px;">
                            <li role="presentation" class="active">
                                <a href="#customerManage" data-toggle="tab" role="tab" id="customerManageLink">
                                    <div class="row">
                                        <div class="col-md-8">
                                            <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
                                            <span>Customer管理</span>
                                        </div>
                                        <div class="col-md-1 col-md-offset-1">
                                            <span>&gt;</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li role="presentation" class="" >
                                <a href="#filmSet" data-toggle="tab" id="filmSetLink">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
                                            <span>Film设置</span>
                                        </div>
                                        <div class="col-md-1 col-md-offset-3">
                                            <span>&gt;</span>
                                        </div>
                                    </div>
                                </a>
                            </li>

                        </ul>
                    </nav>
                </div>
            </div>

            <%--导航显示的内容--%>
            <div class="col-md-10" style="background-color: white;height: 570px;background-color: #d4d4d4;margin-left: 0px;">
                <div class="tab-content">
                    <div class="tab-pane active " id="customerManage">
                        <%--标题--%>
                        <div class="row">
                            <div class="col-md-12" style="padding-top: 10px;">
                                <span id="addPageTabSpan" style="font-size: 20px;" addPageTab="${requestScope.addPageTab}">客户管理</span>
                                <hr style="margin-top: 10px;">
                            </div>
                        </div>
                        <%--客户列表与新增按钮--%>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <span>客户列表</span>
                                            </div>
                                            <div class="col-md-2 col-md-offset-2">
                                                <a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/customer/addCustomer">新增</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel-body">
                                        <table class="table table-hover table-striped" id="table_customer" style="font-size: 13px;">
                                            <thead>

                                            </thead>
                                            <tbody >

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <%--分页详细信息--%>
                            <div class="col-md-6" id="page_info">
                                当前<span id="currentPage"></span>页,总<span id="totalPage"></span>页,总<span id="totalCount"></span>条记录
                            </div>

                            <%--翻页--%>
                            <div class="col-md-6" id="page_nav">

                            </div>
                        </div>
                    </div>

                    <div class="tab-pane " id="filmSet">
                        film设置
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    $(document).ready(function () {

        if($("#addPageTabSpan").attr("addPageTab")==null||$("#addPageTabSpan").attr("addPageTab")==""){
            page_skip(1);
        }else {
            page_skip(99999);
        }
    });
    function page_skip(pn) {
        $.ajax("${pageContext.request.contextPath}/customer/getCustomer",{

            type:"GET",
            data:"pn="+pn,
            success:function (result) {
                 console.log(result);
                //显示用户信息
                build_Customer_table(result);
                //显示分页信息
                build_page_info(result)
                //显示分页条
                build_page_nav(result);
            }
        });
    }

    function build_Customer_table(result) {

        //清空数据
        $("#table_customer thead").empty();
        $("#table_customer tbody").empty();

        var customers=result.userContent.pageInfo.list;

        //构建表头
        var operationTd=$("<td></td>").append("操作");
        var firstNameTitleTd=$("<td></td>").append("First Name");
        var lastNameTitleTd=$("<td></td>").append("Last Name");
        var addressTitleTd=$("<td></td>").append("Address");
        var emailTitleTd=$("<td></td>").append("Email");
        var customerIdTitleTd=$("<td></td>").append("CustomerId");
        var lastUpdateTitleTd=$("<td></td>").append("LastUpdate");

        $("<tr></tr>").addClass("success").append(operationTd).append(firstNameTitleTd)
            .append(lastNameTitleTd).append(addressTitleTd)
            .append(emailTitleTd).append(customerIdTitleTd)
            .append(lastUpdateTitleTd).appendTo("#table_customer thead");

        /*
         参数一：要遍历的集合
         回调函数:参数一：索引  参数二：当前集合元素对象
         * */
        $.each(customers,function (index,item) {

            /**
             * 两个操作链接*/
            var editLink=$("<a></a>").append("编辑").addClass("edit_btn").css({"text-decoration":"none","color":"green"});
            var deleteLink=$("<a></a>").append("删除").addClass("delete_btn").css({"text-decoration":"none","color":"green"});

            editLink.attr({"href":"#","customerId":item.customerId,"pageNum":result.userContent.pageInfo.pageNum});
            deleteLink.attr({"href":"#","customerId":item.customerId,"pageNum":result.userContent.pageInfo.pageNum});

            var linkTd=$("<td></td>").append(editLink).append("|").append(deleteLink);
            /*
             customer信息列表
             * */
            var firstNameTd= $("<td></td>").append(item.firstName);
            var lastNameTd=$("<td></td>").append(item.lastName);
            var addressTd=$("<td></td>").append(item.address);
            var emailTd=$("<td></td>").append(item.email);
            var customerIdTd=$("<td></td>").append(item.customerId);
            <%--var dateFormat=$("<fmt:formatDate value="item.lastUpdate" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>");--%>
            var date=new Date(item.lastUpdate);
            var setDate=date.getFullYear()+"-"+("0"+(date.getMonth()+1)).slice(-2)+"-"+("0"+date.getDate()).slice(-2);
            var lastUpdateTd=$("<td></td>").append(setDate);

            $("<tr></tr>").append(linkTd).append(firstNameTd)
                .append(lastNameTd).append(addressTd)
                .append(emailTd).append(customerIdTd)
                .append(lastUpdateTd)
                .appendTo("#table_customer tbody");

        })

    }

    //显示分页信息
    function build_page_info(result) {

        //获取页信息
        var pageInfo=result.userContent.pageInfo;

//        $("#page_info").empty()
        $("#currentPage").addClass("badge").text(pageInfo.pageNum);
        $("#totalPage").addClass("badge").text(pageInfo.pages);
        $("#totalCount").addClass("badge").text(pageInfo.total)
    }
    /**
     * 构建分页的导航*/
    function build_page_nav(result) {

        //清空数据，每次构建时将原先数据清空
        $("#page_nav").empty();

        //页码
        var pageNavNums=result.userContent.pageInfo.navigatepageNums;

        //ul标签
        var ul=$("<ul></ul>")

        //构建首页和上一页li标签
        var firstLi=$("<li></li>").append($("<a></a>").attr("href","#").append("首页"));
        var preLi=$("<li></li>").append($("<a></a>").attr("href","#").append("&laquo;"))

        if(result.userContent.pageInfo.hasPreviousPage==false){
            firstLi.addClass("disabled")
            preLi.addClass("disabled")
        }else {
            firstLi.click(function () {
                page_skip(1)
            })

            preLi.click(function () {
                page_skip(result.userContent.pageInfo.pageNum - 1)
            })
        }
        ul.append(firstLi).append(preLi);

        //显示分页信息
        function build_page_info(result) {
            $("#page_info").empty()
            $("#page_info").append("当前"+result.userContent.pageInfo.pageNum+"页," +
                "总"+result.userContent.pageInfo.pages+"页,总"+result.userContent.pageInfo.total+"条记录")
        }

        //构建页码
        $.each(pageNavNums,function (index,pageNavNum) {
            var pageNavNumLi=$("<li></li>").append($("<a></a>").attr("href","#").append(pageNavNum))
            if(result.userContent.pageInfo.pageNum==pageNavNum){
                pageNavNumLi.addClass("active")
            }
            pageNavNumLi.click(function () {
                page_skip(pageNavNum)
            });
            ul.append(pageNavNumLi);
        })

        //构建下一页和尾页Li标签
        var nextLi=$("<li></li>").append($("<a></a>").attr("href","#").append("&raquo;"))
        var lastLi=$("<li></li>").append($("<a></a>").attr("href","#").append("尾页"))
        if(result.userContent.pageInfo.hasNextPage==false){
            nextLi.addClass("disabled")
            lastLi.addClass("disabled")
        }else {
            nextLi.click(function () {
                page_skip(result.userContent.pageInfo.pageNum + 1)
            })
            lastLi.click(function () {
                page_skip(result.userContent.pageInfo.pages);
            })
        }
        ul.append(nextLi).append(lastLi).addClass("pagination");

        $("<nav></nav>").append(ul).addClass("Page navigation").appendTo("#page_nav");

    }

    //编辑用户信息
    $(document).on("click",".edit_btn",function () {
        var customerId=$(this).attr("customerId");
        var pageNum=$(this).attr("pageNum");
        $("#editModel").modal();

        getAddressInfo();

        //发出请求获取用户信息
        $.ajax("${pageContext.request.contextPath}/customer/editCustomer",{
            type: "POST",
            data: "customerId=" + customerId,
            success: function (result) {
                console.log(result)
                var customer=result.userContent.customer;
//                alert(customer.address)
                $("#firstName").val(customer.firstName);
                $("#lastName").val(customer.lastName);
                $("#email").val(customer.email)
                $("#address").val(customer.address);
            }
        });

        $("#editeCustomer").attr({"customerId":customerId,"pageNum":pageNum});

    });

    //删除用户信息
    $(document).on("click",".delete_btn",function () {

        //获取customerId和当前页
        var customerId=$(this).attr("customerId");
        var pageNum=$(this).attr("pageNum");

        Showbo.Msg.confirm('您确定删除这条记录吗？',function(flag){
            if(flag=='yes'){
                $.ajax("${pageContext.request.contextPath}/customer/deleteCustomer",{
                    type: "POST",
                    data: "customerId=" + customerId,
                    success: function (result) {

                        if(result.code==100){
                            Showbo.Msg.alert('删除成功!');
                            page_skip(pageNum);
                        }else {
                            Showbo.Msg.alert('删除失败!');
                            page_skip(pageNum);
                        }
                    }
                });
            }else if(flag=='no'){
                page_skip(pageNum);
            }
        });
    });

    //编辑用户提交
    $("#editeCustomer").click(function () {

        //获取customerId
        var customerId=$("#editeCustomer").attr("customerId");
        //获取当前页
        var pageNum=$("#editeCustomer").attr("pageNum");

        //获取表单数据
        var customerData=$("#editeCustomerForm").serialize();
//        alert(customerData)

            //发出更新请求
            $.ajax("${pageContext.request.contextPath}/customer/editCustomerSubmit",{
                type: "POST",
                data: customerData+"&customerId="+customerId,
                success: function (result) {
                    var fieldError = result.userContent.fieldErrors
                    if(result.code == 100)
                    {
//                        alert("更新成功")
                        page_skip(pageNum);
                        $('#editModel').modal('hide')
                        return true;
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
                        return false;
                    }

                }
            });
    });


    function getAddressInfo() {
        $.ajax("${pageContext.request.contextPath}/address/getAddress",{
            type:"GET",
            success:function (result) {
                console.log(result)
                $.each(result.userContent.addressList,function (index, item) {
                    var optionEle=$("<option></option>").append(item.address).attr("value",item.address)
                    $("#address").append(optionEle);
                })
            }
        });
    }

    //检验编辑字段
    $("#firstName").change(function () {
        validateFirstName();
    });
    $("#lastName").change(function () {
        validateLastName();
    });
    $("#email").change(function () {
        validateEmail();
    });

    //添加用户时firstName的校验
    function validateFirstName() {
        $("#firstName").parent().removeClass("has-error has-success");
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
                $("#firstName").next("span").text("必须为3到10个英文或1到2个中文字符,不能混用")
                return false;
            } else {
                $("#name").parent().addClass("has-success")
                $("#name").next("span").text("")
                $.ajax("/customer/isCustomerExist", {
                    type: "POST",
                    data: "firstName=" + firstName,
                    success: function (result) {
                        //用户名可用
                        if (result.code == 100) {
                            $("#firstName").parent().addClass("has-success")
                            $("#firstName").next("span").text("")
                            return true;
                        } else {
                            $("#firstName").parent().addClass("has-error")
                            $("#firstName").next("span").text("用户名以存在")
                            return false;
                        }
                    }
                });
                return true;
            }
        }

    }

    //lastName校验
    function validateLastName() {
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

</script>
</html>
