<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-3.1.1.min.js"></script>
    <link href="${pageContext.request.contextPath }/css/skin1.css" rel="stylesheet" type="text/css" />
<title>年度投诉统计图</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/fusioncharts/fusioncharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/fusioncharts/fusioncharts.charts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript">
	//加载完dom元素后，执行
	$(document).ready(doAnnualStatistic());
	//根据年份统计投诉数
	function doAnnualStatistic() {
		//1、获取年份
		var year = $("#year option:selected").val();
		if (year == "" || year == undefined) {
			year = "2018";//默认当前年份
		}
		//2、根据年份统计
		$
				.ajax({
					url : "${pageContext.request.contextPath }/showStatisticsChart.action",
					data : {
						"year" : year
					},
					type : "post",
					dataType : "json",
					success : function(data) {
						if (data != null && data != "" && data != undefined) {
							var revenueChart = new FusionCharts({
								"type" : "pie3d",//type 图标类型
								"renderAt" : "chartContainer",//renderAt:在哪个控件上显示图表,值的空间的id
								"width" : "600",//宽
								"height" : "400",//高
								"dataFormat" : "json",//数据格式:json/xml
								"dataSource" : {//数据源
									//chart表格的参数,caption标题,subCaption副标
								"chart" : {
										"caption" : year + " 年度投诉数统计图",
										"xAxisName" : "月  份",//横轴名
										"yAxisName" : "投  诉  数",//纵轴名
										"theme" : "fint"//theme主题
									},
									"data" : data.chartData//data具体数据
								}

							});
							revenueChart.render();//把图表渲染到页面上
						} else {
							alert("统计投诉数失败！");
						}
					},
					error : function() {
						alert("统计投诉数失败！");
					}
				});

	}
</script>
<body>
	<br>
	<div style="text-align: center; width: 100%;">
		<select name="" id="year" onchange="doAnnualStatistic()">
		<c:if test="${list != null }">
		<c:forEach items="${list }" var ="lis">
			    <option value="${lis.year }">${lis.year }</option>
		</c:forEach>
		</c:if>
</select>
	</div>
	<br>
	<div id="chartContainer" style="text-align: center; width: 100%;"></div>
</body>
</html>
