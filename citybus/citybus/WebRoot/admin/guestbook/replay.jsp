<%@ page language="java" import="java.util.*"  contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML><HEAD><TITLE>后台操作区</TITLE>
<LINK href="${pageContext.request.contextPath}/admin/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath}/admin/images/style.css" type=text/css rel=stylesheet>


</HEAD>

<BODY style="MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff"  >
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr>
  	<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26">回复留言
				</td>
  </tr>
  <TR>
    <TD align="left" vAlign=top >
    <form name="form1" action="${pageContext.request.contextPath}/servlet/guestbookReplay" method="post"   >
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
  <tr bgcolor='#FFFFFF'> 
    <td width='30%'><div align="right"> ${gb.nickname} ：</div></td>
    <td ><TEXTAREA  NAME="content1" disabled="disabled" ROWS="8" COLS="50" >${gb.content1 }</TEXTAREA></td>
  </tr>
  <tr bgcolor='#FFFFFF'> 
  <input type="hidden" name="id" value="${gb.gid }"/>
  <input type="hidden" name="username" value="${gb.nickname }"/>
  <input type="hidden" name="replayer" value="${admin.adminName }"/>
  	<input type="hidden" id="nows" name="replaytime" value=""/>
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
    <td width='30%'><div align="right">回复@  ${gb.nickname } ：</div></td>
    <td ><TEXTAREA  NAME="replaycontent" ROWS="8" COLS="50" > ${gb.replaycontent }</TEXTAREA></td>
  </tr> 
  <tr bgcolor='#FFFFFF'> 
      <td colspan="2" align="center"> 
        <input class=mmcinb type='submit' name='button' value='提交数据' ><input class=mmcinb type='button'onclick="history.go(-1)" name='button' value='返回' >
      </td>
    </tr>
	
</table></form>
   </TD>
	</TR>
  </TBODY>
</TABLE>
</BODY>

</HTML>
