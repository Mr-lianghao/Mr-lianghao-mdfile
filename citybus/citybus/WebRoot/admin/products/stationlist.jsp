<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/products/addStation.jsp";
	}
	function delBook(sid,sname){
		if(confirm("确定删除站点“"+sname+"”吗？")){
			window.location.href="${pageContext.request.contextPath}/servlet/deleteStationServlet?sid="+sid;
		}
		
	}
	
	function checkAll(){
		//获取checkAll
		var flag = document.getElementById("ckAll").checked;
		//alert(flag);
		
		//获取所有的check
		var ck = document.getElementsByName("ids");
		
		//循环遍历，进行赋值
		for(var i=0;i<ck.length;i++){
			ck[i].checked=flag;
		}
		
	}
	
	function batchDelete(){
		//获取所有ids
		var ck = document.getElementsByName("ids");
		
		var values = "";
		
		for(var i = 0;i<ck.length;i++){
			if(ck[i].checked){
				values+="ids="+ck[i].value+"&";
			}
		}
		values=values.substring(0,values.length-1);
		//alert(values);
		if(values!=""){
			if(confirm("确定删除选定的选项？")){
				window.location.href="${pageContext.request.contextPath}/servlet/batchDeleteServlet?"+values;
			}
		}else{
			alert("请选择需要删除的记录");
		}
		
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/servlet/findStationByManyCondition"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查
							询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="right" class="ta_01">
									站点编号</td>
								<td class="ta_01" ><input type="text"
									name="sid" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								

							<tr>
								<td height="22" align="right"  class="ta_01">
									站点名称：</td>
								<td class="ta_01" ><input type="text"
									name="sname" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								
							</tr>

							<tr>
								
							<td height="22" align="right"  class="ta_01">
									&nbsp;</td>
								<td align="left"  class="ta_01">
								
									<button type="submit" id="search" name="search"
										value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="reset" name="reset" value="&#37325;&#32622;"
									class="button_view" />
								</td>
							</tr>
							
						</table>
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="addProduct()">&#28155;&#21152;
						</button>
						<button class="button_add" type="button" id="batchdelete" name="bd" value=""
							 onclick="batchDelete()">批量删除
								</button>
						
					</td>
					
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="0" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="10%"><input type="checkbox" id = "ckAll"  onclick="checkAll()">全选/全不选</td>
								<td align="center" width="24%">序号</td>
								<td align="center" width="18%">站点名称</td>
								
								<td width="8%" align="center">编辑</td>
								<td width="8%" align="center">删除</td>
							</tr>	

			<c:forEach items="${station }" var="b">	
												
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td align="center" width="10%"><input type="checkbox" name="ids" value="${b.sid }"></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${b.sid }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${b.sname }</td>
									
									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="${pageContext.request.contextPath}/servlet/findStationByIdServlet?sid=${b.sid}">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>

									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="javascript:delBook('${b.sid }','${b.sname }')">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</td>
								</tr>
								<tr>
					</td>
				</tr>
					</c:forEach>	
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

