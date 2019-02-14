<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/skin1.css" rel="stylesheet" type="text/css" />
            <script type="text/javascript">
					 function rolename(obj){
		            	 var n = document.getElementById("role_name").value;
		            	if(n != null && n != ""){
								$.ajax({
									type:"post",
									data:{"name":obj.value},
									url:"${pageContext.request.contextPath}/roled//ajaxRole",
									dataType:"text",
									success:function(data){
										if("角色名有效" == data){
											$("#sp").html(data);
										}else{
											
											$("#sp").html(data);
										}
									}
								});		
		            	} else{
		            		$("#sp").html("角色名不能为空");
		            	}
					} 
			</script>
						
    <title>角色管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${pageContext.request.contextPath}/roled/roleAdd" method="post" >
	<input type="hidden" value="${pageContext.request.contextPath}" id="path" />
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;新增角色</div></div>
    <div class="tableH2">新增角色</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">角色名称：</td>
            <td><input type="text" onblur="rolename(this)" name="name" value="" id="role_name"/><font color="red" id="sp"></font>
            </td>
        </tr>
						
						<tr>  
  
            <td class="tdBg" width="200px">角色权限：</td>
            <td>

              <!-- map 的话 map的key作为显示值   map的value作为。。。 -->
       <c:forEach items="${list }" var="l" varStatus="sta">
       			<input type="hidden" name="goodslist[${sta.index}].id" value="${l.id }">
            	<input type="checkbox" name="goodslist[${sta.index}].code" value="${l.code}" />
            	
				<label for="privilegeIds-1" class="checkboxLabel">${l.code}</label> 
      </c:forEach> 
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">状态：</td>
            <td><input type="radio" name="state" id="role_state1" value="1"/><label for="role_state1">有效</label>
			<input type="radio" name="state" id="role_state0" value="0"/><label for="role_state0">无效</label>
		</td>
        </tr>
    </table>
    
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
    
   
</form>
</body>
</html>