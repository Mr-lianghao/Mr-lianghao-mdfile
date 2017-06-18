<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="p" uri="http://www.itcast.cn/tag"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>公交系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<script type="text/javascript">
	function ckPassword(){
		//alert("aa");
		var password=document.getElementById("password").value;
		var repassword=document.getElementById("repassword").value;
		var form1 =document.getElementById("form");
		//alert(repassword.value);
		if(password==""|repassword==""|password!=repassword){
			alert("填写完整信息！");
		}else{
			form1.submit();
		}
	}
</script>
<script type="text/javascript" src="../js/jquery.js"></script>
	    <script type="text/javascript" src="../js/jquery.form.js"></script>
	    <script type="text/javascript" src="../js/ajaxfileupload.js"></script>
        <script type="text/javascript">
			function uploadImage() {
				$.ajaxFileUpload({
					url: "${pageContext.request.contextPath}/servlet/upload1",
					secureuri:false,
					fileElementId:"user_img",
					dataType:"content",
					error: function(data, status, e) {
						alert(e);
					},
					success: function(data, textStatus) {
					//alert("data="+data);
					var start = data.indexOf(">");  
			            if(start != -1) {  
			              var end = data.indexOf("<", start + 1);  
			              if(end != -1) {  
			                data = data.substring(start + 1, end);  
			               }  
			            } 
			          // alert("data:"+data);
						$("#touxiang").attr('src',"${pageContext.request.contextPath}/upload/"+data); 
						
					}
				});
			}
  
		</script>
</head>

<body class="main">
	<jsp:include page="/head.jsp" />

	<jsp:include page="/menu_search.jsp" />

<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%">
					<table width="100%" border="0" cellspacing="0"
						style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath }/user/modifyuserinfo.jsp">用户信息修改</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/servlet/findUserGuestBook?nickname=${user.username}">留言记录</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/servlet/userLoginout">用戶退出</a></td>
						</tr>
					</table>
				</td>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="myAccount.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改
					</div>




					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<form action="${pageContext.request.contextPath }/servlet/modifyUserInfo" id="form" method="post" onSubmit="return false" >
									<input type="hidden" name="id" value="${user.id }"/>
									<input type="hidden" name="regtime" value="${user.regtime }"/>
									<input type="hidden" name="username" value="${user.username }"/>
										<input type="hidden" name="user_img" value="${user.user_img }"/>
									<table width="100%" border="0" cellspacing="2" class="upline">
									<tr>
											<td style="text-align:right; width:20%">设置头像：</td>
								<td ><img id="touxiang" height="100"
									width="100" src="${pageContext.request.contextPath }/upload/${user.user_img}"><span
									style="visibility: hidden">重新上传</span> <a
									style="position:relative;display:block;width:100px;height:30px;background:#EEE;border:0px solid #999;text-align:center;"
									href="javascript:void(0);"> 浏览
										<form action="" method="post" enctype="multipart/form-data"
											id="upfrom">
											<input type="file" id="user_img" name="user_img1"
												onchange="uploadImage();"
												style="position:absolute;left:0;top:0;width:100px;height:100%;z-index:999;opacity:0;filter:alpha(opacity=0)">
										</form> </a></td>
										</tr>
										<tr>
											<td style="text-align:right; width:20%">会员邮箱：</td>
											<td><input type="text" name="email" class="textinput" value="${user.username }"/></td>
											<td><font color="#999999">请输入正确的邮箱格式</font></td>
										</tr>
										<tr>
											<td style="text-align:right">会员名：</td>
											<td ><input type="text" name="username" class="textinput" value="${user.username }"/></td>
											<td><font color="#999999">会员名设置至少6位</font></td>
										</tr>
										<tr>
											<td style="text-align:right">修改密码：</td>
											<td><input type="password" name="password" id="password"
												class="textinput" /></td>
											<td><font color="#999999">密码设置至少6位，请区分大小写</font></td>
										</tr>
										<tr>
											<td style="text-align:right">重复密码：</td>
											<td><input type="password" class="textinput" id="repassword"/></td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="text-align:right">性别：</td>
											<td colspan="2">&nbsp;&nbsp;<input type="radio"
												name="gender" value="男" ${user.gender== "男"? "checked='checked' ":"" } />
												男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
												type="radio" name="gender" value="女" ${user.gender==
												"女"? "checked='checked' ":"" } /> 女</td>
										</tr>
										<tr>
											<td style="text-align:right">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>





									<p style="text-align:center">

										<input type="image" src="${pageContext.request.contextPath }/images/botton_gif_025.gif" onclick="ckPassword()" border="0">

									</p>
									<p style="text-align:center">&nbsp;</p>
								</form>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="/foot.jsp" />


</body>
</html>
