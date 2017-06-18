<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/admin/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/admin/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/dtree.js"></script>
	<script type="text/javascript">
	
		<!--
		d = new dTree('d');
		d.add(0,-1,'系统菜单树');
		//第一个参数：当前节点，第二个参数：父级节点
		d.add(1,0,'公交管理','${pageContext.request.contextPath}/servlet/lineListServlet','','mainFrame');
		
		
		//子目录添加
		d.add(2,1,'线路管理','${pageContext.request.contextPath}/servlet/lineListServlet','','mainFrame');
		d.add(3,1,'站点管理','${pageContext.request.contextPath}/servlet/stationListServlet','','mainFrame');
		d.add(4,1,'线路站点管理','${pageContext.request.contextPath}/servlet/lineStationListServlet','','mainFrame');
		
		//子目录添加
		d.add(5,0,'新闻管理','${pageContext.request.contextPath}/servlet/findNewsAll','','mainFrame');
		d.add(6,5,'新闻列表','${pageContext.request.contextPath}/servlet/findNewsAll','','mainFrame');
		d.add(7,5,'新闻添加','${pageContext.request.contextPath}/admin/gonggao/gonggaoAdd.jsp','','mainFrame');
		
		//子目录添加
		d.add(8,0,'留言管理','${pageContext.request.contextPath}/servlet/guestbookList','','mainFrame');
		d.add(9,8,'留言管理','${pageContext.request.contextPath}/servlet/guestbookList','','mainFrame');
		//子目录添加
		d.add(10,0,'用户管理','','','mainFrame');
		d.add(11,10,'普通用户管理','${pageContext.request.contextPath}/servlet/findPersonAll','','mainFrame');
		d.add(12,10,'系统用户管理','${pageContext.request.contextPath}/servlet/findAdminAll','','mainFrame');
		//子目录添加
		d.add(13,0,'编辑个人信息','','','mainFrame');
		d.add(14,13,'修改登陆密码','${pageContext.request.contextPath}/admin/system/editpwd.jsp','','mainFrame');
		d.add(15,13,'查看信息','','','mainFrame');
		
		
		
	
		document.write(d);
		
		
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
