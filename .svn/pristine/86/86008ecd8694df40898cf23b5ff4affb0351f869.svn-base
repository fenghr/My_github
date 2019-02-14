<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath }/css/skin1.css" rel="stylesheet" type="text/css" />
    <title>我要投诉</title>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/js/ueditor/lang/zh-cn/zh-cn.js"></script>
    
    <script type="text/javascript">
   		window.UEDITOR_HOME_URL = "/tax/js/ueditor/";
    	var ue = UE.getEditor('editor');
		$(function() {
			queryByAllDept("0", "toCompDept");
			 $("#toCompDept").change(function(){
				$("#toDeptUserName option:gt(0)").remove();
				var pid = this.value;
				if(pid=="--请选择--"){
					return;
				}
				queryByAllDept(pid,"toDeptUserName");
			}); 
		});
		
		function queryByAllDept(pid,obj){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath }/queryByUserName.action",
				data:{"deptid":pid},
				success:function(data){
					var $select = $("#"+obj);
						$.each(data,function(i){
						var $option=$("<option></option>");
						$option.attr("value",data[i].id);
						if(pid != 0){
						$option.html(data[i].name);
						}else{
						$option.html(data[i].deptname);
						}
						$select.append($option);
					});
				},
				error : function() {
					alert("异常");
				},
				dataType:"json"
			});
			
		}
    	//提交投诉信息
    	function doSubmit(){
			var title = $("#comp_compTitle").val();
    		if(title == null||title == ''){
    			alert("投诉没有个标题...");
    			return false;
    		}
			$.ajax({
				url:"${pageContext.request.contextPath }/restful/addComplainMessage.action",
				data:$("#form").serialize(),
				type:"post",
				async: false,
				success: function(data){
					if("success" == data){
						alert("投诉成功√！");
						 window.opener.parent.location.reload(true);
			    		window.close();
					} else {
						alert("投诉失败XX！");
					}
				},
				error: function(){alert("投诉失败X！");}
			});
    	
    }
    	
    	
    </script>
    
</head>
<body>
<form id="form" name="form" action="" method="post" enctype="multipart/form-data">
    <div class="vp_d_1">
        <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <div class="vp_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>工作主页</strong>&nbsp;-&nbsp;我要投诉</div></div>
    <div class="tableH2">我要投诉</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="250px">投诉标题：</td>
            <td><input type="text" name="comp_title" value="" id="comp_compTitle" /></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人部门：</td>
            <td>
            <select id="toCompDept" name="to_comp_deptid" >
   					 <option value="">--请选择--</option>
			</select>
            <input type="hidden" name="to_comp_deptid" value="" id="toCompDept" />

</td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人姓名：</td>
            <td>
            	<select id="toDeptUserName" name="to_comp_id" >
            	<option value="">--请选择--</option>
            	</select>
            	<input type="hidden" name="to_comp_id" value="" id="toDeptUserName" />
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <td><textarea name="to_comp_content"  cols="" rows="" id="editor" style="width:90%;height:160px;"></textarea>
            </td>
        </tr>
        <tr>
            <td class="tdBg">是否匿名投诉：</td>
	            <td><input type="radio" name="is_NM" id="comp_isNmfalse" value="0"/><label for="comp_isNmfalse">非匿名投诉</label>
					<input type="radio" name="is_NM" id="comp_isNmtrue" checked="checked" value="1"/><label for="comp_isNmtrue">匿名投诉</label>
				</td>
        </tr>
    </table>
    <input type="hidden" name="comp.compCompany" value="" id="comp_compCompany"/>
	<input type="hidden" name="comp.compName" value="" id="comp_compName"/>
	<input type="hidden" name="comp.compMobile" value="15238652508" id="comp_compMobile"/>
    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="doSubmit()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:window.close()" class="btnB2" value="关闭" />
    </div>
    </div></div>
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</form>
</body>
</html>