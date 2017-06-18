<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<html:base />
		<title>NewShow.jsp</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="/css/style.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
		<STYLE type=text/css>BODY {
	BACKGROUND-IMAGE: url(images/bg.gif); MARGIN: 0px
}
BODY {
	FONT-SIZE: 12px; LINE-HEIGHT: 21px; FONT-FAMILY: Arial
}
TD {
	FONT-SIZE: 12px; COLOR: #004b91; LINE-HEIGHT: 21px; FONT-FAMILY: Arial
}
</STYLE>
		<STYLE type=text/css>.style2 {
	COLOR: #ffffff
}
.style6 {
	COLOR: #cccccc
}
.style7 {
	COLOR: #999999
}
.style8 {
	COLOR: #ff0000
}
</STYLE>
		<SCRIPT src="/js/AC_RunActiveContent.js"
			type=text/javascript></SCRIPT>

	</head>
	<body bgcolor="#FFFFFF"  leftmargin="0"
		topmargin="0" marginwidth="0" marginheight="0" align=center>
		<jsp:include page="head.jsp"  />
	<jsp:include page="menu_search.jsp" />
		<TABLE cellSpacing=0 cellPadding=0 width=778 align=center border=0>
			
		
			<TR>
				<TD class=unnamed1>
					<table border=0 cellSpacing=0 cellPadding=0 width=778 height=500
						align=center>
							<tr>
								<th align="center" width=90%>
									<FONT size=5><b>${news.newstitle }</b>
									</FONT>
								</th>
							</tr>
							<tr>
								<td style="text-align:center;">
									发布人：${news.publisher }&nbsp;&nbsp;发布日期：
									${news.newstime}" 
								</td>
							</tr>
							<tr>
								<td >
									<font color="black" size="4">&nbsp;&nbsp;&nbsp;&nbsp;新闻正文 ${news.newscontent }</font>
								</td>
							</tr>
							<tr>
								<td style="text-align:center;">
									<hr color=green width=778>
									<br>
									【
									<A  href="javascript:history.go(-1);">返回上页</A>】
								</td>
							</tr>
					</table>
				</TD>
			</TR>

	</TABLE>
	<jsp:include page="foot.jsp" />
	</body>
</html>
