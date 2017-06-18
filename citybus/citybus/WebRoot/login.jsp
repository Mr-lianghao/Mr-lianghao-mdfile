<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>公交系统</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<script type="text/javascript">
		function formcheck(){
			var username=document.getElementsByName("username")[0].value;
			var password=document.getElementsByName("password")[0].value;
			var form1=document.getElementById("form1");
			if(username==""||password==""){
				alert("输入的用户名或密码不能为空！");
			}else{
				form1.submit();
			}
		
		}
	
</script>
</head>

<body class="main">
	<%
		String names="";
		String pwd="";
		Cookie[] c1 = request.getCookies();
		for(int i=0;i<c1.length;i++){
			if("users1".equals(c1[i].getName())){
				//存储数据：用户名+密码
				names=c1[i].getValue().split("-")[0];
				pwd=c1[i].getValue().split("-")[1];
			}
		}
 %>
<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />
	
	<div id="divcontent">
		<form action="${pageContext.request.contextPath }/servlet/userLogin" id="form1" onSubmit="return false" method="post">
			<table width="900px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
					<div style="height:470px">
							<b>&nbsp;&nbsp;首页&nbsp;&raquo;&nbsp;个人用户登录</b>
							<div>
								<table width="100%" border="0" cellspacing="0" >
									<tr>
										<td>
											<div id="logindiv">
												<table width="100%" border="0" cellspacing="0" >
													<tr>
														<td style="text-align:center; padding-top:20px"><img
															src="${pageContext.request.contextPath }/images/logintitle.gif" width="150" height="30" />
														</td>
													</tr>
													<tr>
														<td style="text-align:center;padding-top:20px;"><font
															color="#ff0000">${requestScope["user_msg"]}</font>
														</td>
													</tr>
													<tr>
														<td style="text-align:center">
															<table width="80%" border="0" cellspacing="0"
																style="margin-top:15px ;margin-left:auto; margin-right:auto">
																<tr>
																	<input type="hidden" name ="lasttime" id="today" value=""/>
																		<script type="text/javascript">
																		  function today(){
																			var today = new Date();
																			var y=today.getFullYear();
																			var m=today.getMonth()+1;
																			var d=today.getDate();
																			var h=today.getHours()+1;
																			var min=today.getMinutes()+1;
																			return y+"-"+m+"-"+d+" "+h+":"+min;
																		  
																		  }
																		  document.getElementById("today").value = today();
																		  </script>	
																	<td
																		style="text-align:right; padding-top:5px; width:25%"><font style="font-family: '微软雅黑';font-size: 1em;font-weight: bold;">用户名：</font></td>
																	<td style="text-align:left"><input name="username" value="<%=names %>"
																		type="text" style="width: 15em;padding: 0.5em 1em;border: 1px solid #bbb;" />
																	</td>
																</tr>
																<tr>
																	<td style="text-align:right; padding-top:5px"><font style="font-family: '微软雅黑';font-size: 1em;font-weight: bold;">密&nbsp;&nbsp;&nbsp;&nbsp;码：</font></td>
																	<td style="text-align:left"><input name="password" value="<%=pwd %>"
																		type="password" style="width: 15em;padding: 0.5em 1em;border: 1px solid #bbb;" />
																	</td>
																</tr>
																<tr>
																	<td colspan="2" style="text-align:center"><input
																		type="checkbox" name="ck" />
																		记住我一周&nbsp;&nbsp; 
																</tr>
																<tr>
																	<td colspan="2"
																		style="padding-top:10px; text-align:center"><input
																		name="image" type="button" onclick="formcheck()"
																		value="登陆" style="width: 8em;height: 2em;background-color: #62ab00;border-radius: 4px;border: 0px;color: #fff;font-family:"微软雅黑";font-size: 1em;font-weight: bold;" />
																	</td>
																</tr>

																<tr>
																	<td colspan="2" style="padding-top:10px"><img
																		src="${pageContext.request.contextPath }/images/loginline.gif" width="241" height="10" />
																	</td>
																</tr>
																<tr>
																	<td colspan="2"
																		style="padding-top:10px; text-align:center"><a
																		href="${pageContext.request.contextPath }/register.jsp"><input type="button" name="button"
																			value="马上注册" style="width: 8em;height: 2em;background-color: #FF7B10;border-radius: 4px;border: 0px;color: #fff;font-family:"微软雅黑";font-size: 1em;font-weight: bold;"/>
																	</a></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div></td>
											<td style="text-align:left; padding-top:30px; width:60%"><h1 style="text-align:center;font-size:17px; font-style:italic;">您还没有注册？</h1>
											<p style=" font-size:17px; font-style:italic;">赶快免费注册一个吧！</p>
											<p style="text-align:left">
												<a href="${pageContext.request.contextPath }/register.jsp"><input type="button" name="button"
																			value="马上注册" style="width: 8em;height: 2em;background-color: #FF7B10;border-radius: 4px;border: 0px;color: #fff;font-family:"微软雅黑";font-size: 1em;font-weight: bold;"/>
																	 </a>
											</p>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
