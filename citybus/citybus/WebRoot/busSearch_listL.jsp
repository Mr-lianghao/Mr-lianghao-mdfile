<%@ page language="java" import="java.util.*;import com.citybus.domain.LineString;" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>公交列表</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<link href="${pageContext.request.contextPath }/js/c.css" rel="stylesheet" type="text/css">
</head>
<script src="./js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	window.onload=function(){
		var sear = document.getElementById("count").value;
		var aa = document.getElementById("aa");
		if(sear==""||sear==null||sear==0||sear=="0"){
		//alert("aa");
			aa.style.display="";
			aa.innerHTML="<font color='red'size='4'>很抱歉，沒有找到符合的路线。</font>";
			
		}
	}

</script>
<body class="main">
<%
		List<LineString> list =(List<LineString>)request.getAttribute("list");
 %>
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
<div class="warp1">
	<div class="header">
		<div class="header-logo">
			<div class="title">查询结果</div>
		</div>
	<div class="clear"></div> 
	</div>
</div>
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:left; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公交查询&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;查询结果
					</div>

						<div class="l_main">
	
			<div class="z_content">
				<div class="v_text v_text2"><h1>搜索${searchname }的结果</h1></div>

		
				<div class="clear"></div>


				<div class="futit"></div>
				<div class="z_info">
				<%
	%>
	搜索<font color="red">${searchname }</font>共有
<%
	for(int i=0;i<list.size()-1;i++){

 %>
<font color="blue"><%=list.get(i).getLname() %></font>、

<%
	
	}
 %>
 <font color="blue"><%=list.get(list.size()-1).getLname() %></font>
 等<font color="red">${count }</font>趟公交车<br>

	<%
				for(int i=0;i<list.size();i++){
					String s = "";
					String s1="";
					String start="<a href='"+request.getContextPath()+"/servlet/findLineBySname?sname=" ;
					String center="'>";
					String end="</a>";
					String arrow="→";
					String stationlist = list.get(i).getStationlist();
					String[] station = stationlist.split("→");
					for(int j=0;j<station.length-1;j++){
				s+=start+station[j]+center+station[j]+end+arrow;
			}
			s=s+start+station[station.length-1]+center+station[station.length-1]+end;
			
			for(int j=station.length-1;j>0;j--){
				s1+=start+station[j]+center+station[j]+end+arrow;	
			}
			
				s1=s1+start+station[0]+center+station[0]+end;
 %>
				<table class="search-table">
	<thead><tr><th><%=list.get(i).getLname() %><a href="${pageContext.request.contextPath }/servlet/lineShow?lname=<%=list.get(i).getLname()%>" style="color:green;">查看地图</a></th></tr></thead>
	<tbody>
		<tr><td>市区线路&nbsp;票价1元,A/B/C/D卡有效&nbsp;6:30-20:00</td></tr>
		<tr><td>
	上行：<%=s%>
	</td></tr>
		<tr><td>
	下行：<%=s1 %>
	</td></tr>
		</tbody>
</table><br>
		<%
			s="";	
		}
			
			 %>				
									
			</div>

			</div>
			
		
		</div>
				</td>
			</tr>
		</table>
	</div>

	<jsp:include page="foot.jsp" />


</body>
</html>
