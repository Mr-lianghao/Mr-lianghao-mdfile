<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>公交系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="/head.jsp" />

	<jsp:include page="/menu_search.jsp" />


	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%"><table width="100%" border="0" cellspacing="0"
						style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath }/user/modifyuserinfo.jsp">用户信息修改</a></td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath }/servlet/findUserGuestBook?nickname=${user.username}">留言记录</a></td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/servlet/userLoginout">用戶退出</a>
							</td>
						</tr>
					</table></td>
				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="myAccount.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;欢迎
					</div>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td style="padding:20px"><p>
									<img src="${pageContext.request.contextPath }/ad/myad.jpg" width="631" height="436" />
								</p>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="${pageContext.request.contextPath }/images/logo1.png" width="195" height="50"
					style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2017 &copy; CityBus All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div>


</body>
</html>
