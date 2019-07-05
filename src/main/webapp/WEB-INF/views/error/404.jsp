<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <!-- 设置项目根路径 -->
     <% String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; %>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>404 - 当前页面不存在</title>
        <style>
            body{
            		background: #ccc;
            	}
            	.xy{
            		width: 650px;
            		height: 400px;
            		position: absolute;
            		top: 50%;
            		left: 50%;
            		margin-left: -325px;
            		margin-top: -200px;
            	}
            	.xydd{
            		color: #999;
            		font-family: '微软雅黑';
            		font-size: 20px;
            		text-align: center;
            	}
        </style>
    </head>
    <body>
        <div class="xy" href="javascript:;">
        	<!-- 通过项目绝对路径访问，否则，通过后台controller跳转，会携带controller路径，导致访问地址不正确 -->
            <img src="<%=basePath %>/images/404.jpg" alt="" />
        </div>
        <div class="xydd">
            <h1>当前页面被UFO抓走了！！！</h1>
        </div>
    </body>
</html>
