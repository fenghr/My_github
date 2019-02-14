//******************** listUI.jsp开始****************************
//全选、全反选
function doSelectAll() {
	// jquery 1.6 前
	// $("input[name=selectedRow]").attr("checked",
	// $("#selAll").is(":checked"));
	// prop jquery 1.6+建议使用
	$("input[name=ids]").prop("checked", $("#selAll").is(":checked"));
}

// 新增
function doAdd() {
	document.forms[0].action = "/g2_tax/querydept";
	document.forms[0].submit();
}
// 编辑
function doEdit(id) {
	
	document.forms[0].action = "/g2_tax/updateuser?id=" + id;
	document.forms[0].submit();
}
// 删除
function doDelete(id) {
	var r = confirm("确定删除吗?")
	if (r) {
		document.forms[0].action = "/g2_tax/deleteuser?id=" + id;
		document.forms[0].submit();
	} else {
		return false;
	}
}
// 批量删除
function doDeleteAll() {
	var r = confirm("确定批量删除吗?")
	if (r) {
		document.forms[0].action = "/g2_tax/deleteRole";
		document.forms[0].submit();
	} else {
		return false;
	}
}
// 模糊条件查询
function doSearch() {
	var pa = document.getElementById("path").value;
	document.forms[0].action = pa+"/queryName";
	document.forms[0].submit();
}
// 导出用户列表
function doExportExcel() {
	var r = confirm("11111确定导出用户列表吗?")
	var pa = document.getElementById("path").value;
	if (r) {
		window.open(pa+"/download");
	} else {
		return false;
	}
}
// 导入
function doImportExcel() {
	var path = document.getElementById("path").value;
	document.forms[0].action = path+"/upload";
	document.forms[0].submit();
}

// **************************listUI.jsp结束******************************

// **************************addUI.jsp 与 editUI.jsp 的表单验证的js***********
// 验证表单数据 提交表单
function myClick() {
	var name = $("#name");
	if (name.val() == "" || name.val() == null) {
		document.getElementById("msgName").innerHTML = "用户名不能为空！";
		$("#name").focus();
		return false;
	}
	var password = $("#password");
	if (password.val() == "") {
		document.getElementById("msgPwd").innerHTML = "密码不能为空！";
		$("#password").focus();
		return;
	}
	// 帐号校验
	doVerify(vResult);
	if (vResult) {
		// 提交表单
		document.forms[0].submit();
	}
}
