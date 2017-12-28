<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>添加部门</title>
    <script src="assets/js/jquery-1.12.4.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <%--导航栏--%>
    <div class="row">
        <jsp:include page="../header/header.jsp"/>
    </div>
    <%--表格区域--%>
    <div class="page-header">
        <h2>添加部门</h2>
    </div>
    <div class="row col-md-8">
        <form class="form-horizontal" action="depts/addDept" method="post">
            <div class="form-group">
                <label class="col-md-2 control-label">部门名称</label>
                <div class="col-md-10">
                    <input class="form-control" placeholder="DNAME" name="dname">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">部门地址</label>
                <div class="col-md-10">
                    <input class="form-control" placeholder="LOC" name="loc">
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
