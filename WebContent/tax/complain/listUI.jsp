<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath }/css/skin1.css" rel="stylesheet" type="text/css" />
    <title>投诉受理管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
  
   
   //搜索
  	function doSearch(){
	   var startTime = $("#comp_starTime").val();
	   var endTime = $("#comp_endTime").val();
	   var start = new Date(startTime.replace("-","/").replace("-","/"));
	   var end = new Date(endTime.replace("-","/").replace("-","/"));
		if(start >= end){
			alert("开始日期不可大于结束日期");
			return false;
		}
	   
	   //重置页号
  		 $("#pageNo").val(1); 
  		document.forms[0].action = "${pageContext.request.contextPath }/complaintShowAccept.comp";
/*   		document.forms[0].action = "${pageContext.request.contextPath }/doSearchFuzzyQuery/1"; */
  		document.forms[0].submit();
  	}
  	//受理
  	function doDeal(id,obj){
  		document.forms[0].action = "${pageContext.request.contextPath }/restful/acceptComplainMessage.comp?id="+id+"&obj="+obj;
  		document.forms[0].submit();
  	}
  	
 	//投诉统计
  	function doAnnualStatistic(){
  		document.forms[0].action = "${pageContext.request.contextPath }/annualStatisticChartUI.action";
  		document.forms[0].submit();
  	}
 	
 	
 	function doGoPage(val){
		$("#table1 tr:gt(0)").remove();
		var msg = $("#id2").serialize();
		var reg = /^[1-9]*[0-9]*$/;
		if(!reg.test(val)){
			queryAllComplain(msg,1);
		}else{
			queryAllComplain(msg,val);
		}
	}
 	
 	
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" id ="id2" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       	投诉标题：<input type="text" name="comp_Searchtitle"  id="comp_title" class="s_text" style="width:160px;"/>
                    </li>
                    <li>
                       	投诉时间：<input type="text" name="comp_SearchstarTime"  readonly="readonly" id="comp_starTime" class="s_text" style="width:160px;" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});"/>
                              - 
                             <input type="text" name="comp_SearchendTime"  readonly="readonly" id="comp_endTime" class="s_text" style="width:160px;" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});"/>
                    </li>
                    <li>
                       	状态：<select name="Searchstate" id="Searchstate">
    <option value="">全部</option>
    <option value="0">待受理</option>
    <option value="1">已受理</option>
    <option value="2">已过期</option>


</select>


                    </li>
                    <li><input type="button" id = "button1" class="s_button" value="搜 索" /></li>
                    <li style="float:right;">
                    	<input type="button" value="统计" class="s_button" onclick="doAnnualStatistic()"/>&nbsp;
                    </li>

                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0" id="table1">
                        <tr class="t_tit">
                            <td align="center">投诉标题</td>
                            <td width="120" align="center">被投诉部门</td>
                            <td width="120" align="center">被投诉人</td>
                            <td width="140" align="center">投诉时间</td>
                            <td width="100" align="center">受理状态</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                    </table>
                </div>
            </div>
            
            <script type="text/javascript">
            $(function(){
     	 		queryAllComplain('',1);
     	 		
     	 		$("#button1").click(function(){
					$("#table1 tr:gt(0)").remove();
					var msg = $("#id2").serialize();
					queryAllComplain(msg,parseInt($("#a2").html()));
				});
     	 		
     	 		 $("#up").click(function(){
						var flg = $("#comp_title").val();
						$("#table1 tr:gt(0)").remove();
						if(flg==null){
							queryAllComplain("",parseInt($("#a2").html())-1);
						}else{
							var msg = $("#id2").serialize();
							queryAllComplain(msg,parseInt($("#a2").html())-1);
						}
					});
     	 		 
     	 		$("#down").click(function(){
					var flg = $("#comp_title").val();
					$("#table1 tr:gt(0)").remove();
					if(flg==null){
						queryAllComplain("",parseInt($("#a2").html())+1);
					}else{
						var msg = $("#id2").serialize();
						queryAllComplain(msg,parseInt($("#a2").html())+1);
					}
				});
     	 		
     	 	});
     	
            
            function queryAllComplain(msg,currpage){
            		var startTime = $("#comp_starTime").val();
         	 		var endTime = $("#comp_endTime").val();
         	  	 	var start = new Date(startTime.replace("-","/").replace("-","/"));
         	  	    var end = new Date(endTime.replace("-","/").replace("-","/"));
         		if(start >= end){
         			alert("开始日期不可大于结束日期");
         			return false;
         		}
            	var url ;
            	var data;
            		url = "${pageContext.request.contextPath }/complaintShowAccept.comp?currpage="+currpage;
            		data=msg;
				$.ajax({
					type:"post",
					url:url,
					data:data,
					dataType:"json",
					success:function(data){
						var tr;
						var td;
						var a;
						$("#a1").html(data.totalcnt);
						$("#a2").html(data.currpage);
						$("#nowpage").val(data.currpage);
						$("#a3").html(data.totalpage);
						$("#input5").html(data.totalpage); 
						$.each(data.list,function(i){
							var stat;
							var title;
							title = data.list[i].comp_title;
							var tit = title.substr(0,39)+"...";
							if(data.list[i].state == 1){
								stat="已受理";
								 a = ("<a href='#'>"+stat+"</a>");
							}
							if(data.list[i].state == 2){
								stat="已过期";
								 a = ("<a href='#'>"+stat+"</a>");
							}
							if(data.list[i].state == 0){
								stat="待受理";
								a = ("<a href='javascript:doDeal("+data.list[i].id+")'>"+stat+"</a>");
							}
							
							tr = $("<tr></tr>");
							td = $("<td align='center'></td>");
							td.html(tit);
							tr.append(td);
							
							td = $("<td align='center'></td>");
							td.html(data.list[i].to_comp_deptname);
							tr.append(td);
							
							td = $("<td align='center'></td>");
							td.html(data.list[i].to_comp_name);
							tr.append(td);
							
							td = $("<td align='center'></td>");
							td.html(data.list[i].comp_time);
							tr.append(td);
							
							
							td = $("<td align='center'></td>");
							td.html(stat);
							tr.append(td);
							
							
							td = $("<td align='center'></td>");
							td.html(a);
							tr.append(td);
							$("#table1").append(tr);
							});
						}
					});
				};
     	
            </script>
          <div class="c_pate" style="margin-top: 5px;">
          <input type="hidden" name="currpage"  id="nowpage">
		<table id="table2" width="100%" class="pageDown" border="0" cellspacing="0"
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
        </div>


    </div>
</form>

</body>
</html>