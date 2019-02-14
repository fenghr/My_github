//******************** ROLE  listUI.jsp开始****************************
//全选、全反选
function doSelectAll() {
	// jquery 1.6 前
	// $("input[name=selectedRow]").attr("checked",
	// $("#selAll").is(":checked"));
	// prop jquery 1.6+建议使用
	$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
}
//新增
	function doAdd(){
		
		var pt = document.getElementById("path").value;
		document.forms[0].action = pt+"/roled/code1";
		document.forms[0].submit(); 	
	}
	//编辑
	function doEdit(id){
		var pt = document.getElementById("path").value;
		document.forms[0].action = pt+"/roled/role_compile?id="+id;
		document.forms[0].submit();
	}
	//删除
	function doDelete(id){
		var r = confirm("确定删除吗?")
		if (r) {
			var pt = document.getElementById("path").value;
			document.forms[0].action = pt+"/roled/delete.action?id=" + id;
			document.forms[0].submit();
		}else{
			return false;
		}
	}
	//批量删除
	function doDeleteAll(){
		var r = confirm("确定批量删除吗?")
		if (r) {
			var pt = document.getElementById("path").value;
			document.forms[0].action = pt+"/roled/delete.all";
			document.forms[0].submit();
		}else{
			return false;
		}
	}
	//模糊查询
	function doSearch() {
		var pt = document.getElementById("path").value;
		document.forms[0].action = pt+"/roled/inquire.Role";
		document.forms[0].submit();
	}