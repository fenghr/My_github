<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="http://localhost:8080/tax/">
    <title>查看信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
<body>
<div align="center " style="text-align: center; width: 100%;height: 100%;overflow: hidden">
    	<!-- 标题 -->
        <div style="text-align: center; width: 100%;">
        	<h1>实话实说</h1>
        </div>
        <hr/>
        <!-- 时间、作者 -->
        <div style="text-align: center; width: 100%;color:#ccc;font-size:12px;">
                                    信息分类：${info.types[0].tname }&nbsp;&nbsp;&nbsp;&nbsp;
        	创建人：${info.user.name }&nbsp;&nbsp;&nbsp;&nbsp;
        	创建时间：${info.create_time }
        </div>
        <div style="text-align: center; width: 100%;padding:8px;">
        	<p><span style="text-decoration: underline; font-size: 18px;"><strong>${info.content }</strong></span><strong>
        	<!-- <img src="http://localhost:8080/tax/upload/ueditor/image/20161014/1476410407558096941.jpg" title="1476410407558096941.jpg" alt="six.jpg" width="133" height="85" style="width: 133px; height: 85px; float: left;"/> -->
        	</strong></p>
        </div>
    </div>
    
</body>
</html>