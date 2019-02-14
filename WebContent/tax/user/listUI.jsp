<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.10.2.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/skin1.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
      function doGoPage(obj){
    	 if(obj==''){
    		 obj=1;
    	 }
    	  document.forms[0].action="${pageContext.request.contextPath}/user/"+obj;
    	  document.forms[0].submit();
      }
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/my_user.js"></script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post" enctype="multipart/form-data">
               <input type="hidden" value="${pageContext.request.contextPath}" id="path" />
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        用户名：<input type="text" name="name" value="" id="user.name" class="s_text" style="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="批量删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                        <input type="button" value="导出" class="s_button" onclick="doExportExcel()"/>&nbsp;
                    	<input name="userExcel" type="file"/>
                        <input type="button" value="导入" class="s_button" onclick="doImportExcel()"/>&nbsp;
                    </li>
                </div>
                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="140" align="center">用户名</td>
                            <td width="140" align="center">帐号</td>
                            <td width="160" align="center">所属部门</td>
                            <td width="80" align="center">性别</td>
                            <td align="center">电子邮箱</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                             <c:forEach items="${queryUser}" var="user"> 
                            <tr bgcolor="f8f8f8" >
                                <td align="center"><input type="checkbox" name="ids" value="${user.id}" /></td>
                                <td align="center">${user.name}</td>
                                <td align="center">${user.account}</td>
                                <td align="center">${user.dept}</td>
                                	<c:if test="${user.gender == false }"> <td align="center">女</td></c:if>
                                	<c:if test="${user.gender == true }"> <td align="center">男</td></c:if>
                                <td align="center">${user.email}</td>
                                <td align="center">
                                    <a href="javascript:doEdit(${user.id})">编辑</a>
                                    <a href="javascript:doDelete(${user.id})">删除</a>
                                </td>
                            </tr>
                                </c:forEach> 
                    </table>
                </div>
            </div>
        <div class="c_pate" style="margin-top: 5px;">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right" id="pageTable">
                 	总共${ps.totalcnt}条记录，当前第 ${ps.currpage}页，共 ${ps.totalpage}页 &nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/user/${ps.currpage-1}">上一页</a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/user/${ps.currpage+1}">下一页</a>
					到&nbsp;<input type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="${ps.totalpage}" value="" /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>	
        </div>
        </div>
    </div>
</form>
</body>
</html>