<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath }/css/skin1.css" rel="stylesheet" type="text/css" />
    <title>信息发布管理</title>
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script>
        //实例化UE
   		window.UEDITOR_HOME_URL = "${pageContext.request.contextPath }/js/ueditor/";
    	var ue = UE.getEditor('editor');
    </script>
    
</head>
<body  class="rightBody">
<form id="form" name="form" action="${pageContext.request.contextPath }/addinfo" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong>&nbsp;-&nbsp;新增信息</div></div>
    <div class="tableH2">新增信息</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">信息分类：</td>
            <td><select name="typeid" id="info_type">


</select>

</td>
            <td class="tdBg" width="200px">来源：</td>
            <td><input type="text" name="source" value="" id="info_source"/><font color="" id="font1"/>*</td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息标题：</td>
            <td colspan="3"><input type="text" name="title" value="" id="info_title" style="width:90%"/><font color="" id="font2"/>*</td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息内容：</td>
            <td colspan="3"><textarea name="content" cols="" rows="" id="editor" style="width:90%;height:160px;"></textarea></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td colspan="3"><textarea name="memo" cols="90" rows="3" id="info_memo"></textarea></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">创建人：</td>
            <td>
              ${loginUser.name}
               <input type="hidden" name="creatorid" value="${loginUser.id}" id="info_creator"/>
            </td>
            <td class="tdBg" width="200px">创建时间：</td>
            <td>
               <fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd HH:mm"/>
             	<input type="hidden" name="create_time" value="" id="info_createTime"/>
            </td>
        </tr>
    </table>
     <script type="text/javascript">
     $("#info_source").blur(function(){
    	 var info_source = $("#info_source").val();
    	 if(info_source == null || info_source==''){
        	$("#font1").prop("color","red");
        	return false;
         }else{
        	 $("#font1").prop("color","");	 
         }
     });
     $("#info_title").blur(function(){
    	 var info_title = $("#info_title").val();
    	 if(info_title == null || info_title==''){
        	$("#font2").prop("color","red");
        	return false;
         }else{
        	 $("#font2").prop("color","");	 
         }
     });
     function fun(){
    	 var info_source = $("#info_source").val();
    	 var info_title = $("#info_title").val();
         if(info_source == null || info_source == '' ||info_title == null || info_title == ''){
        	 return false;
         }
         $("#form").submit();
     }
    
	$(function(){
	  	 $.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/queryType",
			dataType:"json",
			success:function(data){
				 var option;
				  $.each(data,function(i){
				  option=$("<option value='"+data[i].id+"'></option>");
				  option.html(data[i].tname);
				  $("#info_type").append(option); 
				 }); 
			}
	   });  
 	});
  
    </script>
    <div class="tc mt20">
        <input type="button" onclick="fun();" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>