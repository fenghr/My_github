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
    <title>投诉信息</title>
</head>
<body class="rightBody">
    <div class="vp_d_1">
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <div class="vp_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>工作主页</strong>&nbsp;-&nbsp;投诉信息</div></div>
         <c:forEach items="${list}" var = "lis">
    <div class="tableH2">投诉详细信息
    		<span style="color:red;">
    		<c:if test="${lis.state == 0 }">
    				未受理
    		</c:if>
    		<c:if test="${lis.state == 1 }">
    				已受理
    		</c:if>
    		<c:if test="${lis.state == 2 }">
    				已过期
    		</c:if>
    
    		</span>
    </div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	<tr><td colspan="2" align="center">投诉人信息</td></tr>
        <tr>
            <td class="tdBg" width="250px">投诉人：</td>
            <td>
            	<c:if test="${lis.is_NM == 0 }">
            	${lis.comop_name }
            	</c:if>
            	<c:if test="${lis.is_NM == 1}">
						匿***名           	
            	</c:if>
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人单位：</td>
            <td>
            ${lis.comp_deptname }
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人姓名：</td>
            <td>
          	  <c:if test="${lis.is_NM == 0 }">
	         	   	${lis.comop_name }
	            	</c:if>
	            	<c:if test="${lis.is_NM == 1}">
							* *** *           	
            	</c:if>
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人手机：</td>
            <td>
            <c:if test="${lis.comp_mobile != null}">
            	${fn:substring(lis.comp_mobile,0,3)}****${fn:substring(lis.comp_mobile,7,11)}
            </c:if>
            <c:if test="${lis.comp_mobile == null}">
            	暂无
            </c:if>
            </td>
        </tr>
        <tr><td colspan="2" align="center">投诉信息</td></tr>
        <tr>
            <td class="tdBg">投诉时间：</td>
            <td>${lis.comp_time}</td>
        </tr>
        <tr>
            <td class="tdBg">被投诉部门：</td>
            <td>${lis.to_comp_deptname }</td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人：</td>
            <td>${lis.to_comp_name }</td>
        </tr>
        <tr>
            <td class="tdBg">投诉标题：</td>
            <td>${lis.comp_title }</td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <td><p>${lis.to_comp_content }</p></td>
        </tr>
        
        <tr>
        	<td colspan="2" align="center">受理信息</td>
        </tr>
        <c:if test="${lis.state == 0 }">
	         <tr>
	            <td class="tdBg" width="250px">受理情况:</td>
	            <td>正在等待受理Ing,请耐心等待</td>
	        </tr>
        </c:if>
        
        <c:if test="${lis.state == 2 }">
	         <tr>
	            <td class="tdBg" width="250px">受理情况:</td>
	            <td>投诉信息已过期...</td>
	        </tr>
        </c:if>
        
        <c:if test="${lis.state== 1 }">
        <tr>
            <td class="tdBg" width="250px">回复部门：</td>
            <td>${lis.cr.reply_deptname }</td>
        </tr>
        
        <tr>
            <td class="tdBg" width="250px">回复人：</td>
            <td>${lis.cr.replyer_name }</td>
        </tr>
        
        <tr>
            <td class="tdBg" width="250px">回复内容：</td>
            <td>${lis.cr.reply_content }</td>
        </tr>
        </c:if>
        
        
    </table>
    </c:forEach>
    </div></div>
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</body>
</html>