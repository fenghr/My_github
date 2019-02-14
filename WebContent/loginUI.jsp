<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link href="${pageContext.request.contextPath }/css/login.css" type="text/css" rel="stylesheet">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
<body>
<script type="text/javascript">
//重新得到验证码
function reloadExtraCode(){
	var imgcode = document.getElementById("imgExtraCode");
	imgcode.src='${pageContext.request.contextPath}/demo/ma_randimg?randomStamp='+Math.random();
}
//判断账户名是否存在
function checkName(obj){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/demo/checkName",
		data:{"account":obj.value},
		dataType:"json",
		success:function(data){
			$("#checkaccount").html(data.msg);
			$("#password").val(data.password);
		},
	});
	
}
//

function logins(){
	document.forms[0].submit();
	//比较安全  扫描工具  参数不暴露
}

function setClean(){
	document.getElementById("account").value = "";
	document.getElementById("password").value = "";
}

//解决子框架嵌套的问题
if(window != window.parent){
	window.parent.location.reload(true);
}


</script>
<style type="text/css">
html { overflow-y: hidden;  }

.password{
      background-color:#f1f3f6;
	  border:1px solid #f1f3f6;
	  font-color:#ccc;
}
#rememberpwd{
	  position:static;
	  margin-top:20px;
	  margin-left:-60px;
	  margin-bottom: 20px;
	 
}
#rememberpwd11{
	  margin-left:-40px;
	 
}
#Layer1 {
	position:absolute;
	left:224px;
	top:479px;
	padding-top:5px;
	width:99px;
	height:21px;
	background-color:#fff;
	z-index:1;
}
.password1 {      
	 background-color:#f1f3f6;
	  border:1px solid #f1f3f6;
	  font-color:#ccc;
}

#ma_validateCode{border:0px none;
				 background-color:#F1F3F6; 
				 color:#555;
				 padding-left:15px;
				 font-size:16px;
				 margin-right:40px;
				 width:60px;
				 overflow: hidden;

}
.youbian input{  border:0px none;
				 background-color:transparent; 
				 color:#555;
				 padding-left:10px;
				 font-size:16px;
				 width:56%;
				 overflow: hidden;}
</style>
    <!--[if IE 6]>
    <script type="text/javascript" src="/tax/ehome/js/DD_belatedPNG.js" ></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('b, s, img, span, .prev, .next, a, input, .youbian, td');
    </script>
    <![endif]-->
</head>
<body scroll="no">

<form id="login_login" name="form1" action="${pageContext.request.contextPath}/demo/home" method="post">

<div id="lo_tf">
<div class="outside">
    <div class="head">
      <table width="1000" height="60" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="840" align="left"><img src="${pageContext.request.contextPath }/images/login/form_03.png"   width="332" height="47"/></td>
          <td align="center">&nbsp;&nbsp;<a href="#"></a></td>
        </tr>
      </table>
    </div>
    <div class="main2">
	   <div class="content">  
	   <div class="youbian">
	    <table width="251" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="12">&nbsp;</td>
          </tr>
          <tr>
           <td height="45" align="left"></td>
          </tr>
          <tr>
          	<td height="13">&nbsp;
            	<span><div height=20 valign="middle" style="padding-left: 18px"><font color="red" id="errMsg"></font></div></span>
            </td>
          </tr>
          <tr>
            <td height="40">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    	<td height="32" align="left"><span style="color:#767676;font-size:14px;">帐号:</span></td>
  </tr>
</table>
			<table width="100%" height="39" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td background="${pageContext.request.contextPath }/images/login/shuru_03.png" width=""><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td align="left">
                    <input type="text" name="account"  size="31" value="" id="account" class="password1" style="color: #767676" onblur="checkName(this)"/><span id="checkaccount"></span>${msg_infu}
                    </td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
		    <tr>
            <td height="10"><table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="32" align="left"><span style="color:#767676;font-size:14px;">密&nbsp;&nbsp;码:</span></td>
  </tr>
</table></td>
          </tr>
          <tr>
            <td height="40">
            <table width="100%" height="39" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td background="${pageContext.request.contextPath }/images/login/shuru_03.png"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td align="left">
                    	<input type="password" name="password" size="31" id="password" class="password" style="color: #767676"/>${msg_infa}
                    </td>
                  </tr>
                </table></td>
              </tr>
            </table> 
            </td>
          </tr>
          
          <tr><td height="32" align="left"><span style="color:#767676;font-size:14px;">验证码：</span></td></tr>
         <tr>
        <td><input name="validateCode" id="ma_validateCode" type="text" size="30" maxlength="6" value="${ma.validateCode}"/> 
           <a href="javascript:reloadExtraCode();">
             <img title="图片看不清点击切换！" src="${pageContext.request.contextPath }/demo/ma_randimg" id="imgExtraCode" align="top"  name="imgExtraCode" />
           </a>${msg_info}
     
         </td>
      </tr>
    
          <tr>
            <td height="40"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
              <input type="checkbox" id="rememberpwd" name="rememberpwd" /><font id="rememberpwd11">是否记住密码</font>
                <td align="right"><a href="#" onclick="javascript:logins();"><img src="${pageContext.request.contextPath }/images/login/form_15.png" width="95" height="37"/></a></td>
                <td width="18">&nbsp;</td>
                <td align="left"><img src="${pageContext.request.contextPath }/images/login/form_17.png" width="95" height="37" onclick="setClean()"/></td>
              </tr>
            </table>
            </td>
          </tr>
        </table>
	  </div>   
       </div>
   </div>
	<div class="foot">版权所有&nbsp;|&nbsp;国税局&nbsp;&nbsp;2016年</div>
</div>
</div>
</form>
</body>
</html>