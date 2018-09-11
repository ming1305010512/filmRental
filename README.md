mysql：
username:root
password:123456
数据库的设置文件在resources/config/properties/db.properties

项目名称为ssmExam

运行项目：
1、项目入口地址为http://localhost:8080/index.jsp,即进入登陆页面
2、登陆成功后，将跳转到用户显示页面customerShow.jsp，该页面包括编辑、删除和新增功能
3、点击新增按钮，跳转到addCustomer.jsp新增页面,页面地址栏选择框值从数据库中获取，其余表单信息进行信息验证，新增成功后返回用户显示页面customerShow.jsp


# 2、问题记录
## 2.1、c3p0数据库连接问题
报错：Could not get JDBC Connection; nested exception is java.sql.SQLException: Connections could not be acquired from the underlying database!

问题解决:
我所遇到的问题是我数据库使用的是8.0.11版本，但是mysql-connector-java驱动包使用的是5.几的版本，需将驱动版本提升
````
<!--数据库驱动包-->
    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.11</version>
    </dependency>
````