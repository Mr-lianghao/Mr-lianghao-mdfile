<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>

</HEAD>

<body >
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath }/servlet/changeStationNameServlet" method="post">
	
	<input type="hidden" name="orde" value="${list.orde }"/>
	<input type="hidden" name="lname" value="${list.lname }"/>
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑站点</STRONG> </strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">站点名称：</td>
				<td colSpan="3" class="ta_01" bgColor="#ffffff"><input type="text"
					name="sname" class="bg"  value="${list.sname }" /></td>
				
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="取消" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>
</body>
</HTML>