<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML><HEAD><TITLE>后台操作区</TITLE>
<LINK href="${pageContext.request.contextPath}/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath}/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="${pageContext.request.contextPath}/images/Common.js"></SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
</HEAD>
<script  language="javascript" >

function ckNum(){
		var baikuang = document.getElementById("baikuang").value;
		var totalPage = document.getElementById("totalP").value;
		//alert(baikuang.value);
		 if(!isNaN(baikuang)){
			//alert("输入的值是数字类型！");
			if(baikuang>totalPage){
				alert("不能超过总页数！");
			}else if(baikuang<0){
				alert("请输入合法值");
			}else{
			 window.location.href="${pageContext.request.contextPath}/servlet/findNewsAll?currentPage="+baikuang;
			}
		}else{
			alert("请输入数字");
		}
 
}


window.onload = function(){
	var ckcode_msg =document.getElementById("ckcode_msg").value;
	if(ckcode_msg!=""){
		alert(ckcode_msg);
	}
}

function delNews(){
	var id =document.getElementById("newsid").value;
	if(confirm("确定要删除该行数据？")){
		window.location.href="${pageContext.request.contextPath}/servlet/delNewById?id="+id;
	}

}
</script>
	

<BODY oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 
background=/images/MainBg.gif topMargin=0 scroll=yes 
marginheight="0" marginwidth="0">
<TABLE  cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr>
  	<td bgcolor='#afd1f3' style="text-align:center"> 新闻列表</td>
  </tr>
  <TR>
  	<input type="hidden" id="ckcode_msg" value="${ckcode_msg }"/>
    <TD align="left" vAlign=top > <form action="News.shtml?method=DELNEWS" method="post" name="pageform">
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#afd1f3' class="tablewidth">
     <tr class="head"> 
      <td width="5%" align="center">ID </td>
      <td  align="center">标题</td> 
      <td  align="center">发布时间</td> 
      <td  align="center">修改</td>
      <td  align="center">选择</td>
    </tr>
   <c:forEach items="${pbn.news }" var="list" varStatus="vs"><input type="hidden" id="newsid" value="${list.id }"/>
	<tr  class="trA" onMouseOver="this.className='trB'" onMouseOut="this.className='trA'"> 
      <td width='5%' align="center" style="border-bottom:1px dotted ;">  ${list.id }</td> 
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;">${list.newstitle } </td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;">${list.newstime }</td> 
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><a href="${pageContext.request.contextPath}/servlet/newFindById?id=${list.id}" >修改</a> </td>
      <td align="center" bgcolor="#FFFFFF"  style="border-bottom:1px dotted #ccc;"><a href="#" onclick="delNews()" >删除</a> </td>
    </tr>
	</c:forEach>
	 
	 </TABLE></form>
	</td>
	</tr>
	<tr bgcolor='#FFFFFF'>
	<td colspan='10' align='right'>
	<TABLE width="100%" border=0 align="right" cellPadding=0 cellSpacing=0>
     <TBODY>
     <TR align="right" >
	 <TD >
	 <form action="" method="post" name="form3">	
	 <input type="hidden" name="pageCount" value="" /><!--//用于给上面javascript传值-->
	 <input type="hidden" name="page" value="" /><!--//用于给上面javascript传值-->         
					<a href="${pageContext.request.contextPath }/servlet/findNewsAll?currentPage=1" ><img src="${pageContext.request.contextPath }/admin/images/first.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/servlet/findNewsAll?currentPage=${pbn.currentPage==1?1:pbn.currentPage-1}" ><img src="${pageContext.request.contextPath }/admin/images/pre.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
		 共 ${pbn.count }条记录,共   ${pbn.totalPage } 页,当前第  ${pbn.currentPage }页&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/servlet/findNewsAll?currentPage=${pbn.currentPage==pbn.totalPage?pbn.totalPage:pbn.currentPage+1}" ><img src="${pageContext.request.contextPath }/admin/images/next.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
		<a href="#" ><img src="${pageContext.request.contextPath }/admin/images/last.gif" border="0" /></a>
	 第<input name="busjump" type="text" id="baikuang" size="3" />页<a href="#" onClick="ckNum()"><img src="${pageContext.request.contextPath }/admin/images/jump.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
	 <input type="hidden" id="totalP" value="${pbn.totalPage}"/>
	 </form>
           </TD>
           </TR>
</table>
   </TD>
	</TR> 
  </TBODY>
</TABLE>
</BODY>

</HTML>
