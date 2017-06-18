<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>公交系统首页</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />

</head>
<script type="text/javascript">
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
</script>
<body class="main" >

	<%@include file="head.jsp"%>
	<%@include file="menu_search.jsp" %>
	<div id="divcontent" background-color="#FCFDEF">
		<table width="900px" border="0" cellspacing="0">
			<tr>
			<td width="497">
			<table  >
				<tr> <!-- 1 -->
					<td  colspan="3"><img src="${pageContext.request.contextPath }/images/news.gif" height="38" /></td>
				</tr>
	          	<tr><!-- 2 -->
					<td style="text-align:right; padding-right:220px">
					输入站点： <input
						type="text" name="sname" class="inputtable" 
						id="sname" /> 
						<input type="image" src="${pageContext.request.contextPath }/images/serchbutton.gif"
						border="0" onclick="bbb()" style="margin-bottom:-4px">
					</td>
				</tr>
			<tr><!-- 3 -->
				<td style="text-align:right; padding-right:220px">
				公交线路：<input
					type="text" name="lname" class="inputtable" 
					id="lname" /> 
					<input type="image" src="${pageContext.request.contextPath }/images/serchbutton.gif"
					border="0" onclick="aaa()" style="margin-bottom:-4px">
				</td>
			</tr>
		</table>
		</td>
		
 <TD style="padding:5px 15px 10px 40px">
<!--*******************************滚动公告开始*******************************-->
      <TABLE width="100%"  border=0 cellPadding=0 cellSpacing=0 >
	  <TBODY>
        <TR><!-- 1 -->
	          <TD >
	            <SPAN >
	            <P>通知公告</P>
	            </SPAN>
			  </TD>
		</TR>
        <TR><!-- 2 -->
	        <TD  align=left rowspan="2">
	        <MARQUEE onmouseover=if(document.all!=null){this.stop()} onmouseout=if(document.all!=null){this.start()} scrollAmount=1 scrollDelay=1 direction=up height=60>
	            <TABLE cellSpacing=0 cellPadding=0  border=0>
	              <TBODY>
	              	<c:forEach items="${pbg.list}" var="list">
						<TR>
			                <TD >
							<a href="${pageContext.request.contextPath}/servlet/findGuestBookAll"> ${ list.content1} </a>---${ list.addtime}<BR>
							</TD>
						 </TR>
					 </c:forEach>
			  	</TBODY>
			 </TABLE>
			 </MARQUEE>
		  </TD>
		</TR>
	</TBODY>
<!--*******************************滚动公告结束*******************************-->
	</TABLE>
</TD>
			</tr>
			</TABLE>
		</td>
	</table>
	</div>

	<div id="divcontent">
		<table width="900px" border="0" cellspacing="0">
			<tr>
				<td width="497"><img src="${pageContext.request.contextPath }/images/billboard.gif" width="497"
					height="38" />
					<table cellspacing="0" class="ctl">
					<c:forEach items="${news }" var="b">	
						<tr>
							<td>&middot;<a href="${pageContext.request.contextPath }/servlet/findNewsById?id=${b.id}" style="color:#000000">${b.newstitle }</a></td>
						</tr>
					</c:forEach>
						
					</table></td>
				<td style="padding:5px 15px 10px 40px"><table width="100%"
						border="0" cellspacing="0">
						<tr>
							<td><img src="${pageContext.request.contextPath }/images/hottitle.gif" width="126" height="29" />
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0">
						<tr>
						<c:forEach items="${pb.buss }" var="list">
							<td style="width:50; text-align:center"><a href="${pageContext.request.contextPath }/servlet/busInfoServlet?lid=${list.lid}"><img
									src="${pageContext.request.contextPath }/upload/${list.img_url}" width="102" height="130"
									border="0" /> </a><br /> <a href="${pageContext.request.contextPath }/servlet/busInfoServlet?lid=${list.lid}">${list.lname }<br />
									公司:${list.company }</a>
							</td>
						</c:forEach>	
						</tr>
					</table></td>
			</tr>
		</table>
	
	</div>



	<jsp:include page="foot.jsp"/>


</body>
</html>
