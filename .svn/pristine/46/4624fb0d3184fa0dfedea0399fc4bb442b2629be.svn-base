<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/skin1.css" rel="stylesheet" type="text/css" />
    <title>用户管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/my_user.js"></script>

   
</head>
<body class="rightBody">
<form id="form" name="form" action="${pageContext.request.contextPath}/adduser" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
        <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>用户管理</strong>&nbsp;-&nbsp;新增用户</div></div>
    <div class="tableH2">新增用户</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">所属部门：</td>
            <td><select name="dept" id="user_dept">
            <c:forEach items="${list}" var="dept">
            <option value="${dept.deptname}">${dept.deptname}</option>
             </c:forEach>
</select>
</td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">头像：</td>
            <td>
           <%-- <c:if test="${headimg != null}"> --%>
                <input type="file" name="headImg"/>
               <%--  </c:if> --%>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">用户名：</td>
            <td><input type="text" name="name" value="" id="name"/>
             <font color="RED"><span id="msgName"></span></font>
             </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td><input type="text" name="account" id="account" onblur="doVerify(this)"/>
                <font color="RED"><span id="msg"></span></font>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td><input type="text" name="password" value="" id="password"/>
              <font color="RED"><span id="msgPwd"></span></font>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td><input type="radio" name="gender" id="user_gendertrue" value="true"/><label for="user_gendertrue">男</label>
            <input type="radio" name="gender" id="user_genderfalse" checked="checked" value="false"/><label for="user_genderfalse">女</label>
</td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">角色：</td>
            <td>
            <!-- 对于list而言 -->
          
            <c:forEach items="${queryCole}" var="code" varStatus="sta">
              <input type="checkbox" name="ids" value="${code.id}"  id="ids" />
              <label   for="userRoleIds-1" class="checkboxLabel">${code.name}</label>
            </c:forEach>
              <input type="hidden" id="__multiselect_userRoleIds" name="__multiselect_userRoleIds" value="" />
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">电子邮箱：</td>
            <td><input type="text" name="email" value="" id="user_email"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td><input type="text" name="mobile" value="" id="user_mobile"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">生日：</td>
            <td><input type="text" name="birthday" value="" readonly="readonly" id="birthday" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});"/></td>
        </tr>
		<tr>
            <td class="tdBg" width="200px">状态：</td>
            <td><input type="radio" name="state" id="user_state1" checked="checked" value="1"/><label for="user_state1">有效</label>
            <input type="radio" name="state" id="user_state0" value="0"/><label for="user_state0">无效</label>
</td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td><textarea name="memo" cols="75" rows="3" id="user_memo"></textarea></td>
        </tr>
    </table>
    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="myClick()" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
   <script type="text/javascript">
   vResult = false;
   /*  //ajax校验帐号唯一
   function doVerify(){
	  	//1、获取帐号
	  	var account = $("#account").val();//jauery获取表单项的值
	  	if(account != ""){
	  		//2、校验 
	  		$.ajax({
	  			url:"../../user/user_verifyAccount.action",
	  			data: {"user.account": account},
	  			type: "post",
	  			async: false,//非异步
	  			success: function(msg){
	  				if("true" != msg){
	  					//帐号已经存在
	  					//alert("帐号已经存在。请使用其它帐号！");
	  					//document.getElementById("msg").innerHTML="帐号已经存在。请使用其它帐号";
	  					$("#msg").text("* 帐号已经存在。请使用其它帐号");
	  					//定焦
	  					$("#account").focus();
	  					vResult = false;
	  				} else {
	  					$("#msg").text("* 帐号可以使用");
	  					vResult = true;
	  				}
	  			}
	  		});
	  	}
 } */
   
   
   
     function doVerify(obj){
    	 $.ajax({
    		 type:"post",
    		 url:"${pageContext.request.contextPath}/checkName",
    		 data:{"account":obj.value},
    		 dataType:"json",
    		 async: false,//非异步
    		 success:function(data){
    			 document.getElementById("msg").innerHTML=data.msg;
    			 if("账号已存在" !=data.msg){
    				 vResult=true;
    			 }
    		 }
    	 });
     }
</script> 
</html>