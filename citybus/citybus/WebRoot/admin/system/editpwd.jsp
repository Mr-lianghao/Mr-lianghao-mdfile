<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>后台操作区</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="${pageContext.request.contextPath}/admin/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="  ${pageContext.request.contextPath}/admin/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="${pageContext.request.contextPath}/admin/images/Common.js"></SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
</STYLE>
<script type="text/javascript">
		function ckPwd(){
			var oldpwd =document.getElementsByName("oldpwd")[0].value;
			var newpwd =document.getElementsByName("newpwd")[0].value;
			var repwd =document.getElementsByName("repwd")[0].value;
			var form1 =document.getElementsByName("form1")[0];
			if(oldpwd==""){
				alert("请输入旧密码");
			}else if(newpwd==""){
				alert("请输入新密码");
			}else if(repwd==""){
				alert("请确认新密码");
			}else if(oldpwd==newpwd){
				alert("新密码不能与原密码相同");
			}else if(newpwd!=repwd){
				alert("输入的两次密码不一致！");
			}else{
				form1.submit();
			}
			
			
		}
		
	window.onload=function(){
		var ckcode_msg=document.getElementsByName("ckcode_msg")[0].value;
		if(ckcode_msg!=""){
			alert(ckcode_msg);
		}
	}

</script>
<META content="MSHTML 6.00.2900.3243" name=GENERATOR></HEAD>

<BODY oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 
 topMargin=0 scroll=no 
marginheight="0" marginwidth="0"><br><br><br>
<TABLE align="center" height="100%" cellSpacing=0 cellPadding=0 width="40%" border=0>
  <TBODY>
  <TR>
    <TD vAlign=top height="50%">
	<form action="${pageContext.request.contextPath }/servlet/adminEditInfo" method="post" name="form1" onSubmit="return false">
		 <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
			<TBODY>
			<TR class=head>
			<TD colSpan=2 height=23 style="background-color: #AFD1F3;"><font color="black">修改后台登录密码 当前用户：</font><FONT color="red"></FONT>&nbsp;&nbsp;<font color="black">（密码为6-16位之间）</font></TD></TR>
			<TR bgColor=#ffffff>
			<TD width="50%" align="right" id=map>旧 密 码：<input type="hidden" name="ckcode_msg" value="${ckcode_msg }"/></TD>
			<TD width="50%" align="left" id=map><input type="password" name="oldpwd" size="20" maxlength=16  class=input onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"></TD></TR>
			<TR bgColor=#ffffff>
			<TD width="50%" align="right" id=map>新 密 码：</TD>
			<TD width="50%" align="left" id=map><input type="password" name="newpwd" size="20" maxlength=16 class=input onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"></TD>
			</TR>
			<TR bgColor=#ffffff>
			<TD width="50%" align="right" id=map>确认密码：</TD>
			<TD width="50%" align="left" id=map><input type="password" name="repwd" size="20" maxlength=16 class=input onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"></TD>
			</TR>
			<TR bgColor=#ffffff>
			<TD colspan="2" align="center" id=map><input type="button" value="确定" onclick="ckPwd()">&nbsp;&nbsp;<input type="reset" value="重填"></TD>
			</TR>
			</TBODY>
		</TABLE>
	</form>
   </TD></TR>
</TBODY></TABLE>
</BODY>
</HTML>
