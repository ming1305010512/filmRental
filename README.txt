mysql：
username:root
password:123456
数据库的设置文件在resources/config/properties/db.properties

项目名称为ssmExam

运行项目：
1、项目入口地址为http://localhost:8080/index.jsp,即进入登陆页面
2、登陆成功后，将跳转到用户显示页面customerShow.jsp，该页面包括编辑、删除和新增功能
3、点击新增按钮，跳转到addCustomer.jsp新增页面,页面地址栏选择框值从数据库中获取，其余表单信息进行信息验证，新增成功后返回用户显示页面customerShow.jsp
