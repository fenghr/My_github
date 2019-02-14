<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath }/css/skin1.css" rel="stylesheet" type="text/css" />
    <title>投诉受理管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${pageContext.request.contextPath }/saveAcceptComplainReplyMessage.comp" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong>&nbsp;-&nbsp;投诉受理</div></div>
    <div class="tableH2">投诉详细信息
    <span style="color:red;">
		<c:if test="${list.state == 0 }">
    				待受理
    		</c:if>
    		<c:if test="${list.state == 1 }">
    				已受理
    		</c:if>
    		<c:if test="${list.state == 2 }">
    				已过期
    		</c:if>
	</span>
	</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	
    	<!-- ******************投诉人信息********************* -->
    	
    	<tr><td colspan="2" align="center">投诉人信息</td></tr>
        <tr>
            <td class="tdBg" width="250px">投诉人：</td>
            <td>
            	<c:if test="${list.is_NM ==1}">
            		非匿名投诉
            	</c:if>
            	<c:if test="${list.is_NM ==0}">
            		匿名
            	</c:if>
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人单位：</td>
            <td>
            	<c:if test="${list.comp_deptname != null}">
            		${list.comp_deptname }
            	</c:if>
            	<c:if test="${list.comp_deptname == null}">
            		暂无..
            	</c:if>
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人姓名：</td>
            <td>${list.comop_name }</td>
        </tr>
        <tr>
            <td class="tdBg">投诉人手机：</td>
            <td>
             <c:if test="${lis.comp_mobile != null}">
            	${fn:substring(list.comp_mobile,0,3)}****${fn:substring(list.comp_mobile,7,11)}
            </c:if>
            <c:if test="${lis.comp_mobile == null}">
            	暂无
            </c:if>
            
            </td>
        </tr>
        
        <!-- ***************************投诉信息********************* -->
        
        <tr><td colspan="2" align="center">投诉信息</td></tr>
        <tr>
            <td class="tdBg">投诉时间：</td>
            <td>${list.comp_time }</td>
        </tr>
        <tr>
            <td class="tdBg">被投诉部门：</td>
            <td>${list.to_comp_deptname }</td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人：</td>
            <td>${list.to_comp_name }</td>
        </tr>
        <tr>
            <td class="tdBg">投诉标题：</td>
            <td>${list.comp_title }</td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <!-- 不去解析  内容是什么就显示什么 -->
            <td><p>${list.to_comp_content }</p></td>
        </tr>
        
         <!-- ***************************受理信息********************* -->
         
        <tr><td colspan="2" align="center">受理信息</td></tr>
        <tr>
            <td colspan="2">
            	
            </td>
        </tr>
        <tr><td colspan="2" align="center">受理操作</td></tr>
        <tr>
            <td class="tdBg">回复部门：</td>
            <td>${list.cr.reply_deptname }
            <input type="hidden" name="reply_deptname" value="${list.cr.reply_deptname }" id="replyer_deptid"/>
            <input type="hidden" name="replyer_id" value="${list.cr.replyer_id }" id="replyer_id"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg">回复人：</td>
            <td> ${list.cr.replyer_name }
            <input type="hidden" name=replyer_name value="${list.cr.replyer_name }" id=replyer_name/>
            </td>
        </tr>

        <tr>
            <td class="tdBg" width="200px">回复内容：</td>
            <td><textarea name="reply_content" cols="90" rows="8" id="reply_content"></textarea></td>
        </tr>
    </table>
    <input type="hidden" name="complain_id" value="${list.id }" id="complain_id"/>
    <input type="hidden" name="strTitle" value="" id="strTitle"/>
    <input type="hidden" name="strState" value="" id="strState"/>
    <input type="hidden" name="startTime" value="" id="startTime"/>
    <input type="hidden" name="endTime" value="" id="endTime"/>
    <input type="hidden" name="pageNo" value="1" id="pageNo"/>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>