<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>公交列表</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
</head>
<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:left; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公交列表&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公交列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<hr />
								<h1>公交列表</h1>&nbsp;&nbsp;&nbsp;&nbsp;
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="${pageContext.request.contextPath }/images/buslist.jpg" width="100%" height="38" />
								</div>

								
							
								<table cellspacing="0" class="booklist">
									<tr>
									<c:forEach items="${pb.buss }" var="b">
										<td>

											<div class="divbookpic">
												<p>
													<a href="${pageContext.request.contextPath }/servlet/busInfoServlet?lid=${b.lid}"><img src="${pageContext.request.contextPath }/upload/${b.img_url}" width="115" height="129"
														border="0" /> </a>
												</p>
											</div>

											<div class="divlisttitle">
												<a href="${pageContext.request.contextPath }/servlet/busInfoServlet?lid=${b.lid}">线路名:${b.lname }<br />公交公司:${b.company } </a>
											</div></td>
									</c:forEach>
									</tr>
								</table>



								<div class="pagination">
									<ul>


										<li class="disablepage">&lt;&lt;首页</li>
										<li class="nextPage"><a href="${pageContext.request.contextPath }/servlet/buspageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}">&lt;&lt;上一页</a></li>

										
										
										<li>第${pb.currentPage }页/共${pb.totalPage }页</li>

										<li class="nextPage"><a href="${pageContext.request.contextPath }/servlet/buspageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}">下一页&gt;&gt;</a></li>


									</ul>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
