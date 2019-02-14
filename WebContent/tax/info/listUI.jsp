<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
<link href="${pageContext.request.contextPath }/css/skin1.css" rel="stylesheet" type="text/css" />
<title>信息发布管理</title>
</head>
<!-- <body  class="rightBody" onload="queryinfo('',1)"> -->
 <body  class="rightBody" >
	<form id="id2" name="form1" action="" method="post">
<input type="hidden" value="${pageContext.request.contextPath}" id="path" />
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>信息发布管理</strong>
						</div>
					</div>
					<div class="search_art">
						<li>信息标题：<input type="text" name="title" value=""
							id="infoTitle" class="s_text" style="width: 160px;" />
						</li>
						<li><input type="button" id="button1" class="s_button" value="搜 索" /></li>
						
						<li style="float: right;"><input type="button" value="新增"
							class="s_button" onclick="doAdd()" />&nbsp; 
							<input type="button" value="删除" class="s_button" onclick="doDeleteAll()" />&nbsp;</li>
					</div>
					<script type="text/javascript">
					function doSelectAll() {
						$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
					}
					function doAdd(){
						var path = document.getElementById("path").value;
						document.forms[0].action = path+"/tax/info/addUI.jsp";
						document.forms[0].submit();
					}
						function doDeleteAll() {
							var path = document.getElementById("path").value;
							var r = confirm("确定批量删除吗?")
							if (r) {
								document.forms[0].action = path + "/delByid";
								document.forms[0].submit();
							} else {
								return false;
							}
						}
						function doDelete(id){
							var path = document.getElementById("path").value;
							var r = confirm("确认删除吗?");
							if(r){
								document.forms[0].action = path+"/delByid?selectedRow="+id;	
								document.forms[0].submit();
							}else{
								return false;
							}
						}
					</script>
					<div class="t_list" style="margin: 0px; border: 0px none;">
						<table id="table1" width="100%" border="0">
							<tr class="t_tit">
								<td width="30" align="center"><input type="checkbox"
									id="selAll" onclick="doSelectAll()" /></td>
								<td align="center">信息标题</td>
								<td width="120" align="center">信息分类</td>
								<td width="120" align="center">创建人</td>
								<td width="140" align="center">创建时间</td>
								<td width="80" align="center">状态</td>
								<td width="120" align="center">操作</td>
							</tr>
						
						</table>
					</div>
				</div>
				<div class="c_pate" style="margin-top: 5px;">
					<table width="100%" class="pageDown" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td align="right">总共<font id="a1"></font>条记录，当前第<font id="a2"></font> 页，共<font id="a3"></font> 页 &nbsp;&nbsp;
							 <a id="up">上一页</a>&nbsp;&nbsp;<a id="down" >下一页</a> 到&nbsp;
							 <input id="input5"	type="text" style="width: 30px;"
							 onkeypress="if(event.keyCode == 13){doGoPage(this.value);}"
								min="1" max="" value="1" /> &nbsp;&nbsp;
							</td>
						</tr>
					</table>
					
					<script type="text/javascript">
					function doGoPage(val){
						$("#table1 tr:gt(0)").remove();
						if(val==''){
							queryinfo('',1);
						}else{
							var msg = $("#id2").serialize();
							queryinfo(msg,val);
						}
					}
								$(function(){
									queryinfo('',1);
									$("#button1").click(function(){
										$("#table1 tr:gt(0)").remove();
										var msg = $("#id2").serialize();
										queryinfo(msg,parseInt($("#a2").html()));
									});
									 $("#up").click(function(){
										var flg = $("#infoTitle").val();
										$("#table1 tr:gt(0)").remove();
										if(flg==null){
											queryinfo("",parseInt($("#a2").html())-1);
										}else{
											var msg = $("#id2").serialize();
											queryinfo(msg,parseInt($("#a2").html())-1);
										}
									}); 
								 	$("#down").click(function(){
										var flg = $("#infoTitle").val();
										$("#table1 tr:gt(0)").remove();
										if(flg==null){
											queryinfo("",parseInt($("#a2").html())+1);
										}else{
											var msg = $("#id2").serialize();
											queryinfo(msg,parseInt($("#a2").html())+1);
										}
									});
								});
								function queryinfo(msg,currpage){
									$.ajax({
										type:"post",
										url:"${pageContext.request.contextPath }/queryAll?currpage="+currpage,
										data:msg,
										dataType:"json",
										success:function(data){
											var flg = $("#infoTitle").val();
										 	$("#a1").html(data.totalcnt);
											$("#a2").html(data.currpage);
											$("#a3").html(data.totalpage); 
											$("#input5").html(data.totalpage); 
							 				var state;
							 				var state2;
											var tr;
											var td;
											var box;
											var a;
												$.each(data.list,function(i){
											 	if(data.list[i].state == 0){
													state="停用";	
												}
												if(data.list[i].state == 1){
													state="发布";	
												} 
											tr = $("<tr></tr>");
											
											td = $("<td></td>");
											box = $("<input></input>");
											box.prop("type","checkbox");
											box.prop("name","selectedRow");
											box.prop("value",data.list[i].info_id);
											td.append(box);
											tr.append(td);
											
											td = $("<td></td>");
											td.html(data.list[i].title);
											tr.append(td);
											
											td = $("<td></td>");	
											td.html(data.list[i].types[0].tname);
											tr.append(td);
											
											td = $("<td></td>");		
											td.html(data.list[i].user.name);
											tr.append(td);
											
											td = $("<td></td>");	
											td.html(data.list[i].create_time);
											tr.append(td);
											
											td = $("<td></td>");	
											td.html(state);
											tr.append(td);
											 
											var state2 =data.list[i].state;
											var infoid2 =data.list[i].info_id;
											td = $("<td ></td>");	
											a = $("<a  id='a3' href='${pageContext.request.contextPath }/upstate?currpage="+data.currpage+"&state="+data.list[i].state+"&info_id="+data.list[i].info_id+"'></a>");
											if(state == "发布"){
												state2="停用";	
											}
											if(state == "停用"){
												state2="发布";	
											} 
											a.html(state2);
											td.append(a);
											tr.append(td);
											
											a = $("<a href='${pageContext.request.contextPath }/queryinfoid?info_id="+data.list[i].info_id+"'></a>");
											a.html(" 编辑");
											td.append(a);
											tr.append(td);
											
											var ids = data.list[i].info_id;
											a = $("<a href='javascript:doDelete("+ids+")'></a>");
											a.html(" 删除");
											td.append(a);
											tr.append(td);
											
											$("#table1").append(tr); 
											 });
												
												
										}
									}); 
								};
							</script>
				</div>
			</div>
		</div>
	</form>

</body>
</html>