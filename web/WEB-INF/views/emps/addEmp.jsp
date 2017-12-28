<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>添加员工</title>
    <script src="assets/js/jquery-1.12.4.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/bootstrap-datetimepicker.js"></script>
    <script src="assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
</head>

<body>
<div class="container-fluid">
    <%--导航栏--%>
    <div class="row">
        <jsp:include page="../header/header.jsp"/>
    </div>
    <div class="page-header">
        <h2>添加员工</h2>
    </div>
    <div class="row col-md-8">
        <form class="form-horizontal" action="emps/addEmp" method="post">
            <div class="form-group">
                <label class="col-md-2 control-label">姓名</label>
                <div class="col-md-10">
                    <input class="form-control" placeholder="ENAME" name="ename">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">工作</label>
                <div class="col-md-10">
                    <input class="form-control" placeholder="JOB" name="job" value="MANAGER">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">上级</label>
                <div class="col-md-10">
                    <input class="form-control" placeholder="MGR" name="mgr" value="7839">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">雇佣日期</label>
                <div class="col-md-10">
                    <input class="form_datetime form-control" placeholder="HIREDATE" name="hiredate">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">薪水</label>
                <div class="col-md-10">
                    <input class="form-control" placeholder="SAL" name="sal">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">补助</label>
                <div class="col-md-10">
                    <input class="form-control" placeholder="COMM" name="comm">
                </div>
            </div>
            <%--使用下拉列表, 选择对应的部门--%>
            <div class="form-group">
                <label class="col-md-2 control-label">部门</label>
                <div class="col-md-10">
                    <%--因为 Emp 中 Dept 为对象, 所以需要使用对象的传参方式--%>
                    <select class="form-control" name="dept.deptno">
                        <c:forEach items="${depts}" var="dept">
                            <option value="${dept.deptno}">${dept.dname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-10 col-md-offset-2">
                    <button type="submit" class="btn btn-success">添加</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        format: "yyyy/MM/dd"
    });
</script>
