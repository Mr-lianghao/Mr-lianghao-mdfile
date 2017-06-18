<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>公交查询系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/servlet/checkImgServlet?time="+ new Date().getTime();
	}
	function ckLogin(){
	//alert("aaa");
		var adminName=document.getElementById("adminName").value;
		var adminPass=document.getElementById("adminPass").value;
		var ckcode=document.getElementById("ckcode").value;
		var form1=document.getElementById("form1");
		
		if(adminName==""||adminPass==""||ckcode==""){
			alert("请填写完整信息！");
			
		}else{
		
			form1.submit();
		}
	}
	
</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="${pageContext.request.contextPath}/images/top02.gif"><img src="${pageContext.request.contextPath}/images/top03.jpg" width="776" height="147" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="${pageContext.request.contextPath}/images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="${pageContext.request.contextPath}/images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td>
    <form action="${pageContext.request.contextPath }/servlet/adminLogin" method="post" id="form1" onSubmit="return false">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">用户名称：<br /></td>
        <td width="69%"><input name="adminName" id="adminName" type="text" size="30" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密　码：<br /></td>
        <td><input name="adminPass" id="adminPass" type="password" size="30" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">验证图片：<br /></td>
        <td><img src="${pageContext.request.contextPath}/servlet/checkImgServlet" width="180" height="30" id="img" /> <a href="javascript:void(0);" onclick="changeImage()" class="login-text03">看不清楚，换张图片</a></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">请输入验证码：</td>
        <td><input  name="ckcode" id="ckcode"  type="text" size="15" /></td>
      </tr>
      <tr>
        <td height="35"><font color="red">${ckcode_msg }</font></td>
        <td><input name="Submit2" type="button" class="right-button01" value="确认登陆" onClick="ckLogin()" />
         <a href="${pageContext.request.contextPath }/index.jsp"> <input name="Submit232" type="button" class="right-button02" value="取消" /></a></td>
      </tr>
    </table>
    </form>
    </td>
  </tr>
</table>
</body>
</html>