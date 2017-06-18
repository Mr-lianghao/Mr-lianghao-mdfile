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
				<div class="v_text v_text2"><h1>${sname1 }到 ${sname2 } 乘车方案</h1></div>
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
 %>
<tr>
		<td width="3%"><%=i+1 %></td>
		<td width="10%">最少<font color="#1B8EC4" 5=""><%=Math.abs(list.get(i).getOrdeE()-list.get(i).getOrdeS()) %></font>站</td>
		<td width="87%"><font color="red">${sname1}</font>&nbsp;坐&nbsp;
		<a href="#" target="_blank"><%=list.get(i).getLname1() %></a>到<font color="red">${sname2 }</font></td>
	</tr>

<%
	}	

 %>
 </tbody>
</table><br>
<b>更多信息</b><br>

<%
for(int i=0;i<list.size();i++){
			List<String> line=list.get(i).getLineString();
					String s = "";
					String s1="";
					String start="<a  href='"+request.getContextPath()+"/servlet/findLineBySname?sname=" ;
					String start1="<a style='color:red;' href='"+request.getContextPath()+"/servlet/findLineBySname?sname=" ;
					String center="'>";
					String end="</a>";
					String arrow="→";
	for(int j=0;j<line.size();j++){
					String stationlist = line.get(j);
					String[] station = stationlist.split("→");
					for(int k=0;k<station.length;k++){
					if(station[k].equals(sname1)||station[k].equals(sname2)){
						s+=start1+station[k]+center+station[k]+end+arrow;
					}else{
						s+=start+station[k]+center+station[k]+end+arrow;
						}
					}
					s=s.substring(0, s.length()-2);

 %>
 <table class="search-table by-middle">
	<thead><tr><th><font color="blue">${sname1 }</font>乘<a href="http://www.8684.com.cn/zhengzhou/l0ded550abdebce32.html"><font color="blue"><%=list.get(i).getLname1() %></font></a>
	到<font color="blue">${sname2 }</font>→(<font color="green">最少<%=Math.abs(list.get(i).getOrdeE()-list.get(i).getOrdeS()) %>站</font>)
	</th></tr></thead>
	<tbody>
	<tr><td>
		<span style="font-size:16px;color:green;">乘坐:<%=list.get(i).getLname1() %>&nbsp;</span>
		<%=s%>
		</td></tr>
	
	</tbody>
	</table><br>
	<%	
		s="";	
		}
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
