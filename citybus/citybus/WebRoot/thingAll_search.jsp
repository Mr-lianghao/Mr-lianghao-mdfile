<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		
		<title>NewAll.jsp</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
		<STYLE type=text/css>BODY {
	BACKGROUND-IMAGE: url(images/bg.gif); MARGIN: 0px
}
BODY {
	FONT-SIZE: 12px; LINE-HEIGHT: 21px; FONT-FAMILY: Arial
}
TD {
	FONT-SIZE: 12px; COLOR: #004b91; LINE-HEIGHT: 21px; FONT-FAMILY: Arial
}
</STYLE>
		<STYLE type=text/css>.style2 {
	COLOR: #ffffff
}
.style6 {
	COLOR: #cccccc
}
.style7 {
	COLOR: #999999
}
.style8 {
	COLOR: #ff0000
}
</STYLE>
<script type="text/javascript">
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
			 window.location.href="${pageContext.request.contextPath}/servlet/findLostByName?currentPage="+baikuang;
			}
		}else{
			alert("请输入数字");
		}
	}
	
	function fsubmit(){
		var keyname = document.getElementById("keyname").value;
		//alert(keyname);
		 window.location.href="${pageContext.request.contextPath}/servlet/findLostByName?name="+keyname;
	}

</script>
	</head>
	<body bgcolor="#FFFFFF" background="${pageContext.request.contextPath }/images/login_bg.gif" leftmargin="0"
		topmargin="0" marginwidth="0" marginheight="0">
			<jsp:include page="head.jsp"  />
	<jsp:include page="menu_search.jsp" />
		<TABLE cellSpacing=0 cellPadding=0  align=center border=0>
			<TBODY>
				<TR>
					<TD background=  ${pageContext.request.contextPath } /images/main/bg2.gif>
					<TABLE cellSpacing=0 cellPadding=0  align=center border=0 style="background-color: #FCFDEF;border: 1px solid #CCCCCC;">
							<TBODY>
								<TR>
									<div style="text-align:left; margin:5px 10px 5px 0px">
						<a href=" ${pageContext.request.contextPath }/index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;<a href=" ${pageContext.request.contextPath }/servlet/findNewsAllServlet">公交新闻</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公交新闻查询
					</div>
								</TR>
												<TR>
													
													<TD vAlign=top width=777>
														<TABLE cellSpacing=0 cellPadding=0 width=777 align=center
															border=0>
															<TBODY>
																<TR>

																	<TD width=514>
																		
																			<TABLE cellSpacing=0 cellPadding=0 width=504 border=0>
																				<TBODY>
																					<TR>
																						<TD width=78>
																							<IMG height=34
																								src=" ${pageContext.request.contextPath }/images/main/gif60.gif" width=78>
																						</TD>
																						<TD align=right width=101>
																							搜索“<font color="red"> ${pbn.thing_name} </font>”的结果
																						</TD>
																						
																					</TR>
																				</TBODY>
																			</TABLE>
																		
																	</TD>
																</TR>

																<TR>
																	<TD>
																		<TABLE cellSpacing=0 cellPadding=0 width=514 border=0>
																			<TBODY>

																				<c:forEach items="${pbn.things }" var="news">
																						<TR>
																							<TD vAlign=center align=middle width="5%"
																								height=25>
																								<IMG height=8
																									src=" ${pageContext.request.contextPath }/images/main/gif15.gif" width=8>
																							</TD>
																							<TD class=xuxianxia height=25>
																								<A
																									href="${pageContext.request.contextPath }/servlet/FindLostByID?id=${news.ID}"
																									>${news.thing_name}</A>&nbsp;&nbsp;
																								<SPAN class=adate>${news.thing_date } </SPAN>
																								
																							</TD>
																						</TR>
																					</c:forEach>
																			</TBODY>
																		</TABLE>
																	</TD>
																</TR>
																<TR>
																	<TD height=40>
																		<TABLE cellSpacing=0 cellPadding=0 width=514 border=0>
																			<TBODY>
																				<TR>
																					<TD class=xian2 align=middle width=514 height=28>
																						<TABLE cellSpacing=0 cellPadding=0 width="95%"
																							border=0>
																							<TBODY>
																								<TR>
																									<TD vAlign=center align=middle>
																										<SPAN >第${pbn.currentPage }/ ${pbn.totalPage }页 每页 ${pbn.pageSize}条 <A
																											class=a01
																											href="${pageContext.request.contextPath }/servlet/findLostByName?currentPage=1&name=${pbn.thing_name}">首页</A>
																											<A class=a01
																											href="${pageContext.request.contextPath }/servlet/findLostByName?currentPage=${pbn.currentPage==1?1:pbn.currentPage-1}&name=${pbn.thing_name}">上一页</A>
																											<A class=a01
																											href="${pageContext.request.contextPath }/servlet/findLostByName?currentPage=${pbn.currentPage==pbn.totalPage?pbn.totalPage:pbn.currentPage+1}&name=${pbn.thing_name}">下一页</A>
																											<A class=a01
																											href="">末页</A>,转到:
																										</SPAN>
																										<INPUT class=baikuang id="baikuang" size=5
																											name=txtGO2>
																										<INPUT
																											onclick="ckNum()"
																											type=image height=18 width=53
																											src=" ${pageContext.request.contextPath }/images/main/gif66.gif"
																											align=absMiddle border=0 name=Submit2>
																											<input type="hidden" id="totalP" value="${pbn.totalPage}"/>
																									</TD>
																								</TR>
																							</TBODY>
																						</TABLE>
																					</TD>
																				</TR>
																			</TBODY>
																		</TABLE>
																	</TD>
																</TR>
															</TBODY>
														</TABLE>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
							</TBODY>
						</TABLE>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<jsp:include page="foot.jsp" />
	</body>
</html>
