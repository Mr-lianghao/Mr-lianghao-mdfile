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
					height="26"><strong><STRONG>编辑新闻</STRONG> </strong>
				</td>
  </tr>
  <TR>
    <TD align="left" vAlign=top >
    <form name="form1" action="${pageContext.request.contextPath}/servlet/newsEdit" method="post"   >
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
 
	
  <tr bgcolor='#FFFFFF'> <input type="hidden"  value=""> <input type="hidden" name="id" value="${news.id }">
    <td width='30%'><div align="right">信息标题：</div></td>
    <td ><input name="newstitle" type="text" size="50" maxlength="100" value="${news.newstitle }"></td>
  </tr> 
  <tr bgcolor='#FFFFFF'>
    <td width='30%'><div align="right">出版者：</div></td>
    <td ><input name="publisher" type="text" size="50" maxlength="100" value="${news.publisher }"></td>
  </tr>
  <tr bgcolor='#FFFFFF'> <input type="hidden" name="newstime" value="${news.newstime }"> 
    <td width='30%'><div align="right">出版时间：</div></td>
    <td > ${news.newstime }</td>
  </tr>
  <tr bgcolor='#FFFFFF'> 
    <td width='30%'><div align="right">新闻内容：</div></td>
    <td ><TEXTAREA  NAME="newscontent" ROWS="8" COLS="50" >${news.newscontent }</TEXTAREA></td>
  </tr> 
  <tr bgcolor='#FFFFFF'> 
      <td colspan="2" align="center"> 
        <input class=mmcinb type='submit' name='button' value='提交数据' ><input class=mmcinb type='button' name='button' value='返回' >
      </td>
    </tr>
	
</table></form>
   </TD>
	</TR>
  </TBODY>
</TABLE>
</BODY>

</HTML>
