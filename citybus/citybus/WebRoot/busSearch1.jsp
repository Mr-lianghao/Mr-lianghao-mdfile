<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>公交查询</title>
<%--导入css --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.84bus.net/zhengzhou/">
<link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/global.js"></script>

</head class="main">

<body>
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
<div id="divpagecontent">
<div id="BAIDU_DUP_fp_wrapper" style="position: absolute; left: -1px; bottom: -1px; z-index: 0; width: 0px; height: 0px; overflow: hidden; visibility: hidden; display: none;">
</div>
<!-- 全局页宽 -->
<div class="global-width"></div>
<!-- 头部 -->
<div class="header">
<div class="header-logo">
<div class="title">
<font size="11">公交线路查询</font>
</div>
</div>
<div class="clear"></div>
</div>
<!-- /头部 -->
<div class="left">
<div class="indexSearch">
	<dl>
	<dt>线路查询</dt>
	<dd>
		<form action="${pageContext.request.contextPath}/servlet/findLineByLname" name="s1" id="s1" method="get" onsubmit="return s(1,2);">
		<input type="hidden" name="t" value="1">
		<input id="k1" class="input1" name="lname" placeholder="例:某路" size="40">
		<input type="submit" class="submit width1" value="哪一路">
     	</form>
     </dd>
     </dl>
	<dl>
	<dt>站点查询</dt>
     <dd>
		<form action="${pageContext.request.contextPath}/servlet/findLineBySname" name="s2" id="s2" method="get" onsubmit="return s(2,2);">
		<input type="hidden" name="t" value="2">
		<input id="k2" class="input1" type="text" name="sname" placeholder="例:站点" size="40" onkeyup="if (this.value !='') suggest.display(this,event);">
		<input type="submit" class="submit width1" value="哪一站">
     	</form>
     </dd>
     </dl>
	<dl>
	<dt>站站查询</dt>
     <dd>
		<form action="${pageContext.request.contextPath}/servlet/findLineByTwoSname" name="s3" id="s3" method="get" onsubmit="return s(3,2);">
		<input type="hidden" name="t" value="3">
    	<input id="k31" class="input2" name="sname1" placeholder="例:起点站" size="30" onkeyup="if (this.value !='') suggest.display(this,event);">-
     	<input id="k32" class="input2" name="sname2" placeholder="例:终点站" size="30" onkeyup="if (this.value !='') suggest.display(this,event);">
    	<input type="submit" class="submit width2" value="从哪上到哪下">
     	</form>
     </dd>
     </dl>
</div>
</div>
</div>
<jsp:include page="foot.jsp" />
</body>

</html>
