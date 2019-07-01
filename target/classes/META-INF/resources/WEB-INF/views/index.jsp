<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>主页</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">

    <div class="jumbotron">
        <h1>
             
        </h1>

        <p>
            	 一个什么都不卖的购物商城
        </p>

        <p>
            <a class="btn btn-primary btn-large" href="">Github</a>
        </p>
    </div>

</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
</body>
</html>