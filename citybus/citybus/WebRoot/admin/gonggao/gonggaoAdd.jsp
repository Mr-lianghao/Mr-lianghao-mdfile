<%@ page language="java" import="java.util.*"  contentType="text/html;charset=utf-8"%>


<HTML><HEAD><TITLE>后台操作区</TITLE>
<LINK href="${pageContext.request.contextPath}/admin/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath}/admin/images/style.css" type=text/css rel=stylesheet>


</HEAD>
<script type="text/javascript">
function sub()
{
	var newstitle=document.getElementById("newstitle").value;
	var newstime=document.getElementById("newstime").value;
	var publisher=document.getElementById("publisher").value;
	var newscontent=document.getElementById("newscontent").value;
	var form1=document.getElementById("form1");
	if(newstitle==""||publisher==""||newscontent==""){
		if(newstitle==""){
			alert("标题不能为空！");
		}
		else if(publisher==""){
			alert("出版者不能为空！")
		}
		else if(newscontent==""){
			alert("内容不能为空！")
		}
	}else{
	
		form1.submit();
	}
}
</script>

<BODY style="MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff"  >
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr>
  	<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加新闻</STRONG> </strong>
				</td>
  </tr>
  <TR>
    <TD align="left" vAlign=top >
    <form name="form1" id="form1" action="${pageContext.request.contextPath}/servlet/newsAdd" method="post"  onSubmit="return false" >
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
 
	
  <tr bgcolor='#FFFFFF'> 
    <td width='30%'><div align="right">新闻标题：</div></td><input type="hidden" name="newstime" id="newstime" value=""/>
    <td ><input name="newstitle" id ="newstitle" type="text" size="50" maxlength="100" value=""></td>
  </tr> 
  <tr bgcolor='#FFFFFF'> 
    <td width='30%'><div align="right">出版人：</div></td>
    <td ><input name="publisher" id="publisher" type="text" size="50" maxlength="100" value=""></td>
  </tr> 
   <tr bgcolor='#FFFFFF'> 
    <td width='30%'><div align="right">发布时间：</div></td>
    <td id="today"></td>
    <script type="text/javascript">
				  function today(){
					var today = new Date();
					var h=today.getFullYear();
					var m=today.getMonth()+1;
					var d=today.getDate();
					return h+"-"+m+"-"+d;
				  
				  }
				  document.getElementById("newstime").value = today();
				  document.getElementById("today").innerHTML = today();
				  </script>
  </tr> 
  <tr bgcolor='#FFFFFF'> 
    <td width='30%'><div align="right">新闻内容：</div></td>
    <td ><TEXTAREA  NAME="newscontent" id="newscontent" ROWS="8" COLS="50"></TEXTAREA></td>
  </tr> 
 
  <tr bgcolor='#FFFFFF'> 
      <td colspan="2" align="center"> 
        <input class=mmcinb type='button' name='button' value='提交数据' onclick='sub()'>
      </td>
    </tr>
    	
	
</table></form>
   </TD>
	</TR>
  </TBODY>
</TABLE>
</BODY>

</HTML>
