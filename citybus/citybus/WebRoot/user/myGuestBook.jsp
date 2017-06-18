<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的留言</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<script type="text/javascript">
	window.onload=function(){
		var replay=document.getElementsByName("replay");
		var replaycontent=document.getElementsByName("replaycontent");
		for(var i=0;i<replay.length;i++){
			if(replay[i].value!=""){
				replaycontent[i].style.display="";
			}
		}
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
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/findUserGuestBook?nickname=${user.username}">留言记录</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/servlet/userLoginout">用戶退出</a></td>
						</tr>
					</table>
				</td>
				<td>
					<div style="text-align:left; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="myAccount.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改
					</div>

				

	<TABLE class="infocontent" cellSpacing=0 cellPadding=0 width="100%" 
            border=0>
           
              <TBODY>
               <c:forEach items="${pbg.list }" var="list">
              <TR>
                <TD class=Ftd align=middle width="18%" rowSpan=2>
                  <DIV class=icon><IMG height=80  src="${pageContext.request.contextPath }/upload/${list.user_img }" width=80 border=0></DIV>
                  <DIV class=name>${list.nickname }</DIV></TD>
                <TD class=Ctd vAlign=top width="82%" height=75>
                  <TABLE style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=0 cellPadding=0 width="80%" border=0>
                    <TBODY>
                    <TR>
                      <TD class=content align=left  >
                      		
					  		${list.content1}
                      
                     <!--  // if(!replay.isEmpty()){	 --> 
                       
                        <FIELDSET name="replaycontent" style="display:none;">
                        <input  type="hidden" name ="replay" value="${list.replaycontent }"/>
						<LEGEND>回复: </LEGEND> 
                       ${list.replaycontent } (署名 ${list.replayer }: /日期: ${list.replaytime})
						</FIELDSET>
					  </TD>
					 </TR>
					
					</TBODY>
				</TABLE>
				</TD>
				</TR>
              <TR>
                <TD class=Atd width="82%">
                时间： ${list.addtime }&nbsp;
					</TD>
			  </TR>
			   </c:forEach>
			  </TBODY>
			  
			  </TABLE>
			   <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD style="text-align:right">
             <SPAN >第${pbg.currentPage }/ ${pbg.totalPage }页 每页 ${pbg.pageSize}条 <Aclass=a01href="${pageContext.request.contextPath }/servlet/findUserGuestBook?nickname=${user.username}&currentPage=1">首页</A>
			<A class=a01 href="${pageContext.request.contextPath }/servlet/findUserGuestBook?nickname=${user.username}&currentPage=${pbg.currentPage==1?1:pbg.currentPage-1}">上一页</A>
			<A class=a01	href="${pageContext.request.contextPath }/servlet/findUserGuestBook?nickname=${user.username}&currentPage=${pbg.currentPage==pbg.totalPage?pbg.totalPage:pbg.currentPage+1}">下一页</A>
			<A class=a01 href="">末页</A>
			</SPAN>
			</TD>
                </TR>
                </TBODY>
                </TABLE></TD></TR>
			</tr>
		</table>
	</div>



	<jsp:include page="/foot.jsp" />


</body>
</html>