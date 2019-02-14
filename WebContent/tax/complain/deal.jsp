

<html>
<head>
    


    <script type="text/javascript" src="../../js/jquery/jquery-3.1.1.min.js"></script>
    <link href="../../css/skin1.css" rel="stylesheet" type="text/css" />
    <title>投诉受理管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="../../complain/complain_deal.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong>&nbsp;-&nbsp;投诉受理</div></div>
    <div class="tableH2">投诉详细信息<span style="color:red;">(待受理)</span></div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	
    	<!-- ******************投诉人信息********************* -->
    	
    	<tr><td colspan="2" align="center">投诉人信息</td></tr>
        <tr>
            <td class="tdBg" width="250px">是否匿名投诉：</td>
            <td>匿名投诉</td>
        </tr>
        <tr>
            <td class="tdBg">投诉人单位：</td>
            <td>
            
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人姓名：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人手机：</td>
            <td>
            
            152****2508
            
            </td>
        </tr>
        
        <!-- ***************************投诉信息********************* -->
        
        <tr><td colspan="2" align="center">投诉信息</td></tr>
        <tr>
            <td class="tdBg">投诉时间：</td>
            <td>
            	2016-11-01 20:54
            </td>
        </tr>
        <tr>
            <td class="tdBg">被投诉部门：</td>
            <td>部门A</td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人：</td>
            <td>超级管理员</td>
        </tr>
        <tr>
            <td class="tdBg">投诉标题：</td>
            <td>投诉111</td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <!-- 不去解析  内容是什么就显示什么 -->
            <td><p>多对多多对多多多多多</p></td>
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
            <td>
            部门B
            <input type="hidden" name="reply.replyDept" value="部门B" id="reply_replyDept"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg">回复人：</td>
            <td>
            徐丽莎
            <input type="hidden" name="reply.replyer" value="徐丽莎" id="reply_replyer"/>
            </td>
        </tr>

        <tr>
            <td class="tdBg" width="200px">回复内容：</td>
            <td><textarea name="reply.replyContent" cols="90" rows="8" id="reply_replyContent"></textarea></td>
        </tr>
    </table>
    <input type="hidden" name="complain.compId" value="4028eedd58b54a940158ba73a1730000" id="complain_compId"/>
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