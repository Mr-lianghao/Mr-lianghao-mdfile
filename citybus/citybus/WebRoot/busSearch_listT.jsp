<%@ page language="java" import="java.util.*;import com.citybus.domain.LineString;import com.citybus.domain.TransInfo;" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>公交列表</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<link href="${pageContext.request.contextPath }/js/c.css" rel="stylesheet" type="text/css">
</head>
<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
<div>
<div id="BAIDU_DUP_fp_wrapper" style="position: absolute; left: -1px; bottom: -1px; z-index: 0; width: 0px; height: 0px; overflow: hidden; visibility: hidden; display: none;"><iframe id="BAIDU_DUP_fp_iframe" src="about:blank" style="width: 0px; height: 0px; visibility: hidden; display: none;"></iframe></div>

<div class="warp2">
	<div class="left_side">
		 <div style="text-align:left; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公交查询&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;查询结果
					</div><div class="l_main">
			<div class="z_content">
				<div class="v_text v_text2"><h1>${sname1 }到 ${sname2 } 一次换乘乘车方案</h1></div>

		
				<div class="clear"></div>


				<div class="futit"></div>
				<div class="z_info">

<b>可换乘线路列表</b><br>

<table class="mtable">
<tbody>
<%
		String sname1=(String)request.getAttribute("sname1");
		String sname2=(String)request.getAttribute("sname2");
		//获取list
		List<TransInfo> list = (List)request.getAttribute("list");
		for(int i=0;i<list.size();i++){
			int sOrde=list.get(i).getOrdeS();
			int eOrde=list.get(i).getOrdeE();
			int mOrde1=list.get(i).getOrde1();
			int mOrde2=list.get(i).getOrde2();
			int max=Math.abs(sOrde-mOrde1)+Math.abs(mOrde2-eOrde);
 %>
	<tr>
		<td width="3%"><%=i+1 %></td>
		<td width="10%">最少<font color="#1B8EC4" 5=""><%=max %></font>站</td>
		<td width="87%"><%=sname1 %>&nbsp;坐&nbsp;
		<a href="#" target="_blank"><%=list.get(i).getLname1() %></a>
				&nbsp;在
		<a href="#" target="_blank"><%=list.get(i).getSname1() %></a>		&nbsp;下车转乘
		<a href="#" target="_blank"><%=list.get(i).getLname2() %></a>&nbsp;
		到<%=sname2 %></td>
	</tr>
	<%
		}
	 %>
</tbody></table><br>


<b>更多信息</b><br>

	<%
	for(int i=0;i<list.size();i++){
			List<String> line=list.get(i).getLineString();
			int sOrde=list.get(i).getOrdeS();
			int eOrde=list.get(i).getOrdeE();
			int mOrde1=list.get(i).getOrde1();
			int mOrde2=list.get(i).getOrde2();
			String sname3=list.get(i).getSname1();
			int max=Math.abs(sOrde-mOrde1)+Math.abs(mOrde2-eOrde);
					String s = "";
					String s1="";
					String start="<a  href='"+request.getContextPath()+"/servlet/findLineBySname?sname=" ;
					String start1="<a style='color:red;' href='"+request.getContextPath()+"/servlet/findLineBySname?sname=" ;
					String start2="<a style='color:#00A650;' href='"+request.getContextPath()+"/servlet/findLineBySname?sname=" ;
					String center="'>";
					String end="</a>";
					String arrow="→";
					String stationlist1 = line.get(0);
					String stationlist2 = line.get(1);
					String[] station = stationlist1.split("→");
					String[] station1 = stationlist2.split("→");
					for(int k=0;k<station.length;k++){
					if(station[k].equals(sname1)||station[k].equals(sname2)){
						s+=start1+station[k]+center+station[k]+end+arrow;
					}else if(station[k].equals(sname3)){
						s+=start2+station[k]+center+station[k]+end+arrow;
					}else{
						s+=start+station[k]+center+station[k]+end+arrow;
						}
					}
					s=s.substring(0, s.length()-2);
					
					for(int k=0;k<station1.length;k++){
					if(station1[k].equals(sname1)||station1[k].equals(sname2)){
						s1+=start1+station1[k]+center+station1[k]+end+arrow;
					}else if(station1[k].equals(sname3)){
						s1+=start2+station1[k]+center+station1[k]+end+arrow;
					}else{
						s1+=start+station1[k]+center+station1[k]+end+arrow;
						}
					}
					s1=s1.substring(0, s1.length()-2);

 %>
 <table class="search-table by-middle">
	<thead>
	<tr><th><font color="blue"><%=sname1 %></font>乘<a href=""><font color="blue"><%=list.get(i).getLname1() %></font></a>在<font color="blue"><%=list.get(i).getSname1() %></font>/下车,转乘<a href=""><font color="blue"><%=list.get(i).getLname2() %></font></a>到<font color="blue"><%=sname2 %></font>→(<font color="green">最少<%=max %>站</font>)
	</th></tr>
	</thead>
	<tbody>
	<tr><td>
		<span style="font-size:16px;color:green;">先乘:<%=list.get(i).getLname1() %>&nbsp;</span>
			<%=s %><span style="color:green;"><a href="${pageContext.request.contextPath }/servlet/lineShow?lname=<%=list.get(i).getLname1()%>" style="color:green;">查看地图</a></span>
			</td></tr>
	<tr><td>
		<span style="font-size:16px;color:green;">再乘:<%=list.get(i).getLname2() %>&nbsp;</span>
		<%=s1 %><span style="color:green;"><a href="${pageContext.request.contextPath }/servlet/lineShow?lname=<%=list.get(i).getLname2()%>" style="color:green;">查看地图</a></span>
		</td></tr>
	</tbody>
	</table><br>
	<%
	s="";	
	s1="";
	}
	 %>

				</div>

			</div>
		</div>
		<div class="l_bottom"></div>
	
	</div>
	<div class="clear"></div>
</div>

<div class="warp3">
<div class="clear"></div>

</div>

<div class="clear"></div>
</div>
<jsp:include page="foot.jsp" />


</body>
</html>
