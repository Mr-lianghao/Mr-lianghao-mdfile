<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<html:base />

	<title>addVip.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<SCRIPT language=JavaScript src="/js/meizzDate.js"></SCRIPT>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/css/style.css">
	<link href="${pageContext.request.contextPath }/css/addChance.css"
		rel="stylesheet" type="text/css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
</head>

<body>
			<jsp:include page="head.jsp"  />
	<jsp:include page="menu_search.jsp" />
	<table width="100%" border="0" align="left" cellpadding="0"
		cellspacing="0" bordercolor="#E2E2E1" bgcolor="#FFFFFF">
		<tr>
			<td width="100%" valign="top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					background="">
					<tr>
						<td class="place" colspan="4">
							失物管理&gt;招领物品查看
						</td>
					</tr>
					<tr>
				</table>
			<td>
		</tr>
		<tr>
			<td>
				<br>
				<form method="post" action="/doChangeThings.do?flag=2">
					<table width="100%" border="0" cellpadding="6" cellspacing="1"
						 id="content">
						<tr class="top">
							<td height="20" align="center">
								<div align="right">
									<font size=+1><b>基本信息</b>
									</font>
								</div>
								<br>
							</td>
							<td height="20" align="left">

								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									<font color="blue">物品名:</font>
								</div>
							</td>
							<td class="gray">
								${things.thing_name }
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									<font color="blue">拾到日期:</font>
								</div>
							</td>
							<td class="gray">
								${things.thing_date}
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									<font color="blue">拾到者:</font>
								</div>
							</td>
							<td class="gray">
								${things.thing_people }
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									<font color="blue">拾到者联系方式:</font>
								</div>
							</td>
							<td class="gray">
								${things.thing_peoplePhone }

								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									<font color="blue">所在车次:</font>
								</div>
							</td>
							<td class="gray">
								${things.thing_routeNum }
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									<font color="blue">详细说明:</font>
								</div>
							</td>
							<td class="gray">
								${things.thing_detail }
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%" colspan="2">
								<div style="text-align:center;" >
									丢失者请尽快联系本站相关人员或拾到者！
								</div>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
<jsp:include page="foot.jsp" />
</body>
