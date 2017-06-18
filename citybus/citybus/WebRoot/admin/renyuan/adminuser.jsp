<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML><HEAD><TITLE>后台操作区</TITLE>
<LINK href="${pageContext.request.contextPath}/admin/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath}/admin/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="${pageContext.request.contextPath}/images/Common.js"></SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
</HEAD>

<script type="text/javascript">

function checkUser33()
{
		//alert("aaa");
	 var username=document.getElementsByName("adminName")[0].value;
	//alert(username);
	var password=document.getElementsByName("adminPass")[0].value;
	var form1=document.getElementsByName("form1")[0];
	if(username=="")
	{
		alert("请输入登录名！ ");
		username.focus();
		return false;
	}
	if(password=="")
	{
		alert(" 请输入登陆密码！");
		password.focus();
		return false;
	}
	//alert("ccc");
	form1.submit(); 
}
function delPerson(id){
	if(confirm("确定要删除该管理员？")){
		window.location.href="${pageContext.request.contextPath}/servlet/delAdminById?id="+id;
	}

}
function fun1(req_msg){
//alert("bbb");
	if(req_msg!=null&&req_msg!=""){
	alert(req_msg);
	}
	var td1 = document.getElementById("td1");
	var ids = document.getElementsByName("map1")[0].value;
	if(ids==null&&ids==""){
		td1.style.display="block";
	}
}
</script>
<BODY onload=fun1('${req_msg }') oncontextmenu="return false;" onselectstart="return false;" leftMargin=0  topMargin=0 scroll=no marginheight="0" marginwidth="0">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY  >
  <TR>
    <TD align="left" vAlign=top >
	<form action=" ${pageContext.request.contextPath}/servlet/addAdmin" method="post" name="form1" onSubmit="return false">
       <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD height=23>序号</TD>
			<TD>用户名</TD>
			<TD>创建时间</TD>
			<TD>号码</TD>
			<TD>删除</TD>
		  </TR>
		    <c:forEach items="${list }" var="list">
		  <TR onClick=OnclikeTable(this) align="center" bgColor=#ffffff>
			<TD width="30" id=map1 name="map1">${list.id }</TD>
			<TD id=map>${list.adminName }</TD>
			<TD id=map>${list.registerTime}</TD>
			<TD id=map> ${list.phone } </TD>
			<TD id="id"><a href="#" onclick="delPerson('${list.id}')" >删除</a></TD>
		  </TR>
		  </c:forEach>
		  <TR align="center" bgColor=#ffffff id="td1" style="display:none;">
			<TD colspan=8 align=center id=map>当前还没有添加用户</TD>
		  </TR>
		  </TBODY>
	   </TABLE><br>
	   <TABLE width="40%" border=0 align="center" cellPadding=3 cellSpacing=1>
	   <TR><TD>
	   <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD height=23 colspan="2">增加用户</TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width="40%" align="right" id=map>用户名：</TD>
			<TD width="60%" align="left" id=map><input type="text" name="adminName" value="" maxlength="10" size="18" class=input  onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"/>&nbsp; </TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD align="right" id=map>登录密码：</TD>
			<TD align="left" id=map><input type="password" name="adminPass" maxlength="16" size="18" class=input  onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"/>&nbsp; </TD>
		  </TR>
		  <TR align="center" bgColor=#ffffff>
			<TD align="right" id=map>电话号码：</TD>
			<TD align="left" id=map><input type="text" name="phone" maxlength="16" size="18" class=input  onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"/>&nbsp; </TD>
		  </TR>
		  	<input type="hidden" id="nows" name="registerTime" value=""/>
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
				  document.getElementById("nows").value = today();
				  </script>	
		  <TR align="center" bgColor=#ffffff>
			<TD colspan="2" align="center" id=map><input type="button" onclick="checkUser33()" value="确定">&nbsp;&nbsp;<input type="reset" value="重填"></TD>
			</TR>
		  </TBODY>
	   </TABLE>
	   </TD></TR></table><br>
	   
	  </form>
    </TD>
  </TR>
  </TBODY>
</TABLE>
</BODY>
</HTML>
