<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>国税协同办公平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/home.css"
	rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
<body>
	<!-- 头部{ -->
	<jsp:include page="../common/headcom.jsp"></jsp:include>
	<!-- }头部 -->
	<!-- 导航{ -->
	<jsp:include page="../common/daohang.jsp"></jsp:include>
	<!-- }导航 -->
	<!-- 左{ -->
	<div class="content">
		<div class="left">
			<!-- 个人资料{ -->
			<div class="left_grzx1">
				<div class="left_grzxbt">
					<h1>个人资料</h1>
				</div>
				<table width="98%" border="0" align="center">
					<tr>
						<td width="76" height="100" align="center" valign="middle">
							<div class="left-tx">

								<img src="/upload/${loginUser.headimg }"
									width="70" height="70" />

							</div>
						</td>
			<!-- 			<td width="5%"><img
							src=""
							width="4" height="59" alt="" /></td> -->
						<td width="60%"><table width="95%" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td colspan="2" style="font-weight: bold; color: #3a7daa;">${loginUser.name}</td>
								</tr>
									<td colspan="2">所属部门:${loginUser.dept}</td>
								<tr>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- }个人资料 -->
		</div>
		<!-- }左 -->

		<!-- 右{ -->
		<div class="right">
			<div class="left_grzx1">
				<div class="left_grzxbt">
					<h1>信息列表</h1>
				</div>
			
					<script type="text/javascript">
               
								$(function(){
									queryComplain(); 
									queryinfo();
								});
								
								function queryComplain(){
									$.ajax({
										type:"post",
										url:"${pageContext.request.contextPath }/complaintView.action",
										dataType:"json",
										success:function(data){
											var tr;
											var td;
											var a;
											$.each(data,function(i){
									 		var stat;
												var name;
												var title;
												title = data[i].comp_title;
												var tit = title.substr(0,39)+"...";
												if(data[i].state == 1){
													stat="已受理";
												}
												if(data[i].state == 2){
													stat="已过期";
												}
												if(data[i].state == 0){
													stat="待受理";
												}
												
												if(data[i].is_NM == 1){
													name = "匿名";
												}
												
												if(data[i].is_NM == 0){
													name = data[i].comop_name;
												}
											 	tr = $("<tr></tr>");
												td = $("<td height='23'  target='_blank'></td>");
												 a = ("<a href='${pageContext.request.contextPath }/restful/complainUserIdMessage.action/"+data[i].id+"/"+data[i].state+"'>"+tit+"</a>");
												td.append(a);
												tr.append(td); 
												
													td = $("<td width='180px'></td>");	
												td.html(stat);
												tr.append(td);
												
												td = $("<td width='180px'></td>");		
												td.html(name);
												tr.append(td);
												
												
												td = $("<td width='180px'></td>");	
												td.html(data[i].comp_time);
												tr.append(td);
												
												$("#table2").append(tr); 
												});
											}
										});
									};
								
								function queryinfo(){ 
									
									$.ajax({
										type:"post",
										url:"${pageContext.request.contextPath }/queryQian",
										dataType:"json",
										success:function(data){
											var tr;
											var td;
											var box;
											var a;
											var fmt;
											$.each(data,function(i){
											
											tr = $("<tr></tr>");
											td = $("<td height='23'  target='_blank'></td>");					
											a = ("<a href='${pageContext.request.contextPath }/queryId?info_id="+data[i].info_id+"'>"+data[i].title+"</a>");
											td.append(a);
											tr.append(td);
											
											td = $("<td width='150px'></td>");	
											td.html(data[i].types[0].tname);
											tr.append(td);
											
											td = $("<td width='150px'></td>");		
											td.html(data[i].user.name);
											tr.append(td);
											
											td = $("<td width='150px'></td>");	
											td.html(data[i].create_time);
											tr.append(td);
											
											$("#table1").append(tr); 
											 }); 
										}
									});
								};
							</script>

				<table width="98%" id="table1" border="0" align="center">
				</table>
			</div>
		</div>
		<!-- }右-->
		<div class="clear"></div>

		<div class="layout_center">
			<div class="lc_grzx1">
				<div class="lc_grzxbt">
					<h1>我的投诉</h1>
					<div style="float: right; padding-top: 3px;">
						<a
							href="${pageContext.request.contextPath }/restful/complainAddUIView.action"
							target="_blank">我要投诉</a>&nbsp;&nbsp;
					</div>
				</div>
				<table id="table2" width="98%" border="0" align="center">
				</table>
			</div>
			<div class="lc_grzx1">
				<div class="lc_grzxbt">
					<h1>我的咨询</h1>
				</div>
				<table width="98%" border="0" align="center">
					<tr>
						<td></td>
						<td width="150px"></td>
						<td width="150px"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<!-- 尾部{ -->
	<div class="foot">版权所有©国税局 2016</div>
	<!-- }尾部 -->
</body>
</html>