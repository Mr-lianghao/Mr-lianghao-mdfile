<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
<!--
function aaa()
{
	var lname = document.getElementById("lname");
	
	if(lname.value=="")
	{
		alert("请输入线路");
	}else{
		window.location.href="${pageContext.request.contextPath}/servlet/findLineByLname?lname="+lname.value;
	}
	//
}
function bbb()
{
	var sname = document.getElementById("sname");
	
	if(sname.value=="")
	{
		alert("请输入站点");
	}else{
		window.location.href="${pageContext.request.contextPath}/servlet/findLineBySname?sname="+sname.value;
	}
}
function ccc()
{
	var snam1 = document.getElementById("snam1");
	var snam2 = document.getElementById("snam2");
	
	if(sname1.value==""||sname2.value=="")
	{
		alert("请输入起始站和目的站");
	}else{
		window.location.href="${pageContext.request.contextPath}/servlet/findLineByTwoSname?sname1="+sname1.value+"&sname2="+sname2.value;
	}
	
}

function ddd()
{
	if(document.form0.ss.value=="")
	{
		alert("请输入地标名！");
		document.form0.ss.focus();
		return false;
	}
	form0.submit();
}
-->
</script>

<title>公交查询</title>
<%--导入css --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:left; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公交查询
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>公交查询</h1>
								<hr />
								
								<div style="margin-top:20px; margin-bottom:5px">
									<img
										src="${pageContext.request.contextPath }/images/bussearch.gif"
										width="100%" height="38" />
								</div>

								<div style="margin-top:20px; margin-bottom:5px">
								
									<TABLE id=guide  class="ctl">
										<TR> 
							          		<tr>
										<td style="text-align:left; padding-right:220px">
										按站点查询： <input
											type="text" name="sname" class="inputtable" 
											id="sname" /> 
											<input type="image" onclick="bbb()" src="images/serchbutton.gif"
											border="0" style="margin-bottom:-4px">
										</td>
										<TR> 
							          		<tr>
										<td style="text-align:left; padding-right:220px">
										按线路查询： <input
											type="text" name="lname" class="inputtable" 
											id="lname" /> 
											<input type="image"  onclick="aaa()" src="images/serchbutton.gif"
											border="0" style="margin-bottom:-4px">
										</td>
									
										<TR> 
							          		<tr>
										<td style="text-align:left; padding-right:220px">
										换乘查询： <input
											type="text" name="sname1" class="inputtable" 
											id="sname1"  /> ---<input
											type="text" name="sname2" class="inputtable" 
											id="sname2"  /> 
											<input type="image" onclick="ccc()" src="images/serchbutton.gif"
											border="0" style="margin-bottom:-4px">
										</td>
 									</TABLE>
								</td>
						</tr>
						<tr>
						<div id = "di" style="margin-top:20px; margin-bottom:5px">
									
								</div>
						
						</tr>
						
					</table>
				</td>
			</tr>
		</table>
	</div>

	<jsp:include page="foot.jsp" />


</body>
</html>
