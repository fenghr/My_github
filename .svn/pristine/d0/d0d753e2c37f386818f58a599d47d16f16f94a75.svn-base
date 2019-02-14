<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/skin1.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
      function showImg(obj){
    	  var fileName = obj.files[0].name;
    	/* document.getElementById("pirtures").value=fileName; */
    	   $("pirtures").val(fileName); 
    	  var reader = new FileReader();
    	  reader.readAsDataURL(obj.files[0]);
    	  //数据读取完毕
    	  reader.onload=function(){
    		  var html = "<img id='img' width='100px' height='100px' src='"+this.result+"'/>";
    		  document.getElementById("img1").innerHTML=html;
    	  }
      }
     
    </script>
    <title>用户管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/my_user.js"></script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${pageContext.request.contextPath}/updatesuccess" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>用户管理</strong>&nbsp;-&nbsp;编辑用户</div></div>
    <div class="tableH2">编辑用户</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">所属部门：</td>
            <td><select name="dept" id="user_dept" >
            <option value="${update.dept}" >${update.dept}</option>
            <c:forEach items="${query}" var="dept">
            <option value="${update.dept}">${dept.deptname}</option>
         </c:forEach>
        </select>
</td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">头像：</td>
            <td>
                   <div id="img1"> <img src="/upload/${update.headimg}" width="100" height="100"/></div>
                    <!-- <input type="hidden" name="headImg" value="" id="user_headImg" /> -->
                    <input type="hidden"  name = "id" value="${update.id}" id="id"/>
                <input type="file" name="headImg" id="pirtures" onchange="showImg(this)"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">用户名：</td>
            <td><input type="text" name="name" value="${update.name}" id="name"/>
            <font color="RED"><span id="msgName"></span></font>
             </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td><input type="text" name="account" value="${update.account}" id="account" onblur="doVerify()"/>
            <font color="RED"><span id="msg"></span></font>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td><input type="password" name="password" value="${update.password}" id="password"/>
            <font color="RED"><span id="msgPwd"></span></font>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td>
            <c:if test="${update.gender == true }">
            <input type="radio" name="gender" id="user_gendertrue" checked="checked" value="true"/>
            <label for="user_gendertrue">男</label>
            <input type="radio" name="gender" id="user_genderfalse" value="false"/>
           <label for="user_genderfalse">女</label>
            </c:if>
               <c:if test="${update.gender == false }">
               <input type="radio" name="gender" id="user_gendertrue"  value="true"/>
            <label for="user_gendertrue">男</label>
           <input type="radio" name="gender" id="user_genderfalse" checked="checked" value="false"/>
           <label for="user_genderfalse">女</label>
            </c:if>
        </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">角色：</td>
            <td>
              <!-- 遍历角色信息-->
              <!--角色id-->
              <c:forEach items="${code}" var="dept" varStatus="sta" >
		              <!--中间表id-->
		              <c:forEach items="${userRole}" var="ur" varStatus="stat">
			              <!--判断中间表的角色id和角色表的id是否相等  -->
			              <c:if test="${dept.id == ur.role_id}">
			              <!--中间变量  -->
			              <c:set value="checked" var = "flag"></c:set>
			              </c:if>
		              </c:forEach>
		              
			           <%-- <input type="hidden" id="__multiselect_userRoleIds" name="goodslist[${sta.index}].id" value="${dept.id}" />  --%>
			              <input type="checkbox" name="ids" value="${dept.id}" ${flag}      id="userRoleIds-1"  />
			              <c:set value="" var="flag"></c:set>
			          <label     for="userRoleIds-1"    class="checkboxLabel">${dept.name}</label>
         </c:forEach>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">电子邮箱：</td>
            <td><input type="text" name="email" value="${update.email}" id="user_email"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td><input type="text" name="mobile" value="${update.mobile }" id="user_mobile"/></td>
        </tr>        
        <tr>
            <td class="tdBg" width="200px">生日：</td>
            <td>
            <input type="text" name="birthday" value='<fmt:formatDate value="${update.birthday}" pattern="yyyy-MM-dd" />' readonly="readonly" id="birthday" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});"/>
            </td>
        </tr>
		<tr>
							<td class="tdBg" width="200px">状态：</td>
							<c:if test="${update.state ==1 }">
								<td><input type="radio" name="state" id="user_state1" checked="checked" value="1" />
								<label for="user_state1">有效</label>
								<input type="radio" name="state" id="user_state0" value="0" />
								<label for="user_state0">无效</label>
							</c:if>
							<c:if test="${update.state ==0 }">
							<td><input type="radio" name="state" id="user_state1"  value="1" />
								<label for="user_state1">有效</label>
								<input type="radio" name="state" id="user_state0"  checked="checked" value="0" />
								<label for="user_state0">无效</label>
							</c:if>
							</td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td><textarea name="memo" cols="75" rows="3" id="user_memo">${update.memo}</textarea></td>
        </tr>
    </table>
    <input type="hidden" name="user.id" value="402881e8578453390157845bd2730000" id="user_id"/>
    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="myClick()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
 <script type="text/javascript">
    var vResult = false;
   /*  	//校验帐号唯一
    	function doVerify(){
    		//1、获取帐号
    		var account = $("#account").val();
    		if(account != ""){
    			//2、校验 
    			$.ajax({
    				url:"../../user/user_verifyAccount.action",
    				data: {"user.account": account, "user.id": "402881e8578453390157845bd2730000"},
    				type: "post",
    				async: false,//非异步
    				success: function(msg){
		  				if("true" != msg){
		  					//帐号已经存在
		  					//alert("帐号已经存在。请使用其它帐号！");
		  					document.getElementById("msg").innerHTML="帐号已经存在。请使用其它帐号";
		  					//定焦
		  					$("#account").focus();
		  					vResult = false;
		  				} else {
		  					//alert("ok");
		  					//document.getElementById("msg").innerHTML="帐号可以使用";
		  					//$("#msg").val="帐号可以使用";
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
    			data:{"acount":obj.value},
    			dataType:"json",
    			async:false,//非同步
    			success:function(data){
    				document.getElementById("msg").innerHTML=data.msg;
    				if("账号已存在" != data.msg){
    					vResult=true;
    				}
    			}
    		});
    	}
    </script>
</html>