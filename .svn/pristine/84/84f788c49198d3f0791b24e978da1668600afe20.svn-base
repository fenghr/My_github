<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <script type="text/javascript" src="../../js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/skin1.css" rel="stylesheet" type="text/css" />
    <title>角色管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${pageContext.request.contextPath}/roled/amend" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;编辑角色</div></div>
    <div class="tableH2">编辑角色</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">角色名称：</td>
            <td><input type="text" name="name" value="${role1.name }" id="role_name"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">角色权限：</td>
            <td>
					 <c:forEach items="${list }" var="l" varStatus="sta">
 							<c:forEach items="${RCode }" var="rc" varStatus="stat">
					       			
					       			<c:if test="${rc.code_id==l.id }">
					            		<c:set value="checked" var="flg"></c:set>
					       			 </c:if>	
							</c:forEach>
					       	<input type="hidden" name="goodslist[${sta.index}].id" value="${l.id }">
							<input type="checkbox" name="goodslist[${sta.index}].code" value="${l.code}" ${flg} />
									<c:set value="" var="flg"></c:set>
							<label for="privilegeIds-1" class="checkboxLabel">${l.code}</label> 	
					</c:forEach>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">状态：</td>
          	  <td>
            	<c:if test="${role1.state == 1 }">
           			 <input type="radio" name="state" id="role_state1" checked="checked" value="1"/>
           			 <label for="role_state1">有效</label>
           			 <input type="radio"  name="state" id="role_state0" value="0"/>
           			 <label for="role_state0">无效</label>
           	 </c:if>
           	 		
           		 <c:if test="${role1.state != 1 }">
           		  <input type="radio" name="state" id="role_state1"  value="1"/>
           			 <label for="role_state1">有效</label>
					<input type="radio" checked="checked" name="state" id="role_state0" value="0"/>
           			 <label for="role_state0">无效</label>
				</c:if>
			
	</td>
        </tr>
    </table>
    <input type="hidden" name="id" value="${role1.id }" id="role_roleId"/>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
   
</form>
</body>
</html>
