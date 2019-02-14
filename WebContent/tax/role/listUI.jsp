<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/skin1.css" rel="stylesheet" type="text/css" />
    <title>角色管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/my_role.js"></script>
</head>
<body class="rightBody">
<input type="hidden" value="${pageContext.request.contextPath}" id="path" />
    <div class="p_d_1">
        <div class="p_d_1_1">
<form name="form1" action="${pageContext.request.contextPath}/roled/stampa" id="sssssssss" method="post">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>角色管理 </strong></div> </div>
                <div class="search_art">
                    <li>
                        角色名称：<input type="text" name="rname" onkeypress="if(event.keyCode == 13){doRole(this.value);}" value="" id="roleName" class="s_text" style="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="120" align="center">角色名称</td>
                            <td align="center">权限</td>
                            <td width="80" align="center">状态</td>
                            <td width="120" align="center">操作</td>
                        </tr>
                            <c:forEach items="${role }" var="li"       varStatus="staa">
                            <tr bgcolor="f8f8f8" >
                                <td align="center">
                             	   <input type="checkbox" name="selectedRow" value="${li.id }"/>
                                </td>
                                <td align="center">${li.name } </td>
		                                <td align="center" >
	                                <c:forEach items="${li.lis }" var="lis1" varStatus="sta">
		                                	${lis1.code }
	                                </c:forEach>
		                                </td>
		                        <c:if test="${li.state == 1 }">
                               		 <td align="center">有效</td>
                                </c:if>
                                <c:if test="${li.state == 0 }">
                               		 <td align="center">无效</td>
                                </c:if>
                                <td align="center">
                                    <a href="javascript:doEdit(${li.id })">编辑</a>
                                    <a href="javascript:doDelete(${li.id })">删除</a>
                                </td>
                            </tr>
                               </c:forEach> 
                    </table>
                </div>
            </div>
    </form>
			<div class="c_pate" style="margin-top: 5px;">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">
				<form action="${pageContext.request.contextPath }/roled/cooo"  id="myfrom" >
					<input type="hidden" name="currpage" value="${fq.currpage }" id="currpage">
					<input type="hidden" name="totalpage" value="${fq.totalpage }" id="totalpage">
					<input type="hidden" name="totalcnt" value="${fq.totalcnt }" id="totalcnt">
				
                 	总共${countRole }条记录，当前第 ${fq.currpage } 页，共 ${fq.totalpage } 页 &nbsp;&nbsp;
                            <a href="javascript:curr('first')">上一页</a>&nbsp;&nbsp;<a href="javascript:curr('next')">下一页</a>
					到&nbsp;<input type="text" style="width: 30px;" name="inputRole" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="${fq.totalpage }" value="" /> &nbsp;&nbsp;
					</form>
			    </td>
			</tr>
		</table>	
        </div>
        </div>
    </div>
<script type="text/javascript">
	function curr(jum){
		var currpage = document.getElementById("currpage");
		var totalpage = document.getElementById("totalpage");
		if("first"==jum){
				var tex;
		
				if(parseInt(currpage.value)-1<=0){
					
					currpage.value = 1;
				}else{
					currpage.value=parseInt(currpage.value)-1;
				}
				document.getElementById("myfrom").submit();
				
		}
		if("next" == jum){
			
			if(parseInt(currpage.value)+1 >= parseInt(totalpage.value)){
				currpage.value=totalpage.value;
				
			}else{
				currpage.value=parseInt(currpage.value)+1;
			}
			document.getElementById("myfrom").submit();
		}
	}

	function doRole(name){
		document.getElementById("sssssssss").submit();
	}
</script>
</body>
</html>