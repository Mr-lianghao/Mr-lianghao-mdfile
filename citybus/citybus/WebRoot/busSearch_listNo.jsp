<%@ page language="java" import="java.util.*;import com.citybus.domain.LineString;import com.citybus.domain.TransInfo;" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>公交列表</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<link href="${pageContext.request.contextPath }/js/c.css" rel="stylesheet" type="text/css">
</head>
<script src="./js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	window.onload=function(){
		var sear = document.getElementById("count").value;
		var aa = document.getElementById("aa");
		if(sear==""||sear==null||sear==0||sear=="0"){
		//alert("aa");
			aa.style.display="";
			aa.innerHTML="<font color='red'size='4'>很抱歉，沒有找到符合的路线。</font>";
			
		}
	}

</script>
<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
<div>
<div id="BAIDU_DUP_fp_wrapper" style="position: absolute; left: -1px; bottom: -1px; z-index: 0; width: 0px; height: 0px; overflow: hidden; visibility: hidden; display: none;"><iframe id="BAIDU_DUP_fp_iframe" src="about:blank" style="width: 0px; height: 0px; visibility: hidden; display: none;"></iframe></div>





<div class="warp2">
	<div class="left_side">
		 <div style="text-align:left; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公交查询&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;查询结果
					</div><div class="l_main">
			<div class="z_content">
				<div class="v_text v_text2"><h1><font color="blue">${sname1 }</font>到 <font color="blue">${sname2 }</font> 乘车方案</h1></div>
				<div class="clear"></div>
				<div class="futit"></div>
				<div class="z_info">
<b>可换乘线路列表</b><br>

<table class="mtable">
<tbody>

<tr>
		
		<td width="10%"><font color="#1B8EC4" 5="">&nbsp;</font></td>
		<td width="87%"><font size="3" color="red">抱歉没有找到符合条件的路线，可能是查找的线路多于一次换乘或站点不存在！</font></font></td>
	</tr>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
 </tbody>
</table><br>

</div>


</body>
</html>
