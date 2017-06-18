<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
<head>
	<html:base />

	<title>发布失物招领</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language=javascript>
		function findNameNotExit()
		{
			var name = document.getElementById('depart.departName').value;
			DepartBiz.checkDepart(name,NameNotExit);
		}
		function NameNotExit(result)
		{
			if(result)	
			{
				alert("对不起该部门已经存在!");
				 document.getElementById("depart.departName").value="";
				 document.getElementById("depart.departName").focus();
				 return false;
			}
		}
	</script>
	<style type="text/css">
<!--
.select * {
  margin: 0;
  padding: 0;
}
.select {
  border:1px solid #cccccc;
  float: left;
  display: inline;
  }
.select div {
  border:1px solid #f9f9f9;
  float: left;
}
/* 子选择器，在FF等非IE浏览器中识别 */
.select>div {
  width:120px;
  height: 17px;
  overflow:hidden;
  }
  
/* 通配选择符，只在IE浏览器中识别 */
* html .select div select {
  display:block;
  float: left;
  margin: -2px;
}
.select div>select {
  display:block;
  width:124px;
  float:none;
  margin: -2px;
  padding: 0px;
}
.select:hover {
  border:1px solid #666666; //鼠标移上的效果 
}
.select select>option {
  text-indent: 2px; //option在FF等非IE浏览器缩进2px
}
-->
</style>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<link href="${pageContext.request.contextPath }/js/c.css" rel="stylesheet" type="text/css">
<script src="/js/jquery.js" type="text/javascript"></script>
<body>
	<jsp:include page="/head.jsp" />
	<jsp:include page="/menu_search.jsp" />
	<table width="100%" border="0" align="left" cellpadding="0"
		cellspacing="0"  >
		<tr>
			<td width="100%" valign="top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					background="">
					<tr>
						<TD width="2%" height=33>
							<DIV align=center>
								
							</DIV>
						</TD>
						<td class="place" colspan="4">
							失物管理&gt;招领物品添加
						</td>
					</tr>
					<tr>
				</table>
			<td>
		</tr>
		<tr>
			<td>
				<br>
				<form method="post" action="${pageContext.request.contextPath}/servlet/addThing?flag=1">
					<table width="100%" border="0" cellpadding="6" cellspacing="1"
						 id="content">
						<tr class="top">
							<td height="36" align="center">
								<div align="right">
									<font size=+1><b>基本信息</b>
									</font>
								</div>
								<br>
							</td>
							<td height="36" align="left">

								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									物品名:
								</div>
							</td>
							<td class="gray">
								<input type="text" name="thingName" size="30"
									maxlength="12" class="FormBase"
									onfocus="this.className='FormFocus';"
									onblur="this.className='FormBase';" />
								<span class="red" id="dictType">*</span>
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									拾到日期:
								</div>
							</td>
							<td class="gray">
								<input type="text" name="thingDate" size="30"
									maxlength="12" onfocus="setday(this)" class="FormBase"
									onfocus="this.className='FormFocus';"
									onblur="this.className='FormBase';" />
								<span class="red" id="dictType">*</span>
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									拾到者:
								</div>
							</td>
							<td class="gray">
								<input type="text" name="thingPeople" size="30"
									maxlength="12" class="FormBase"
									onfocus="this.className='FormFocus';"
									onblur="this.className='FormBase';" />
								<span class="red" id="dictType">*</span>
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									拾到者联系方式:
								</div>
							</td>
							<td class="gray">
								<input type="text" name="thingPeoplePhone" size="30"
									maxlength="12" class="FormBase"
									onfocus="this.className='FormFocus';"
									onblur="this.className='FormBase';" />
								<span class="red" id="dictType">*</span>
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									所在车次:
								</div>
							</td>
							<td class="gray">
								<div class="select">
									<div>
										<select name="busRoute">
											<logic:present name="route">
												<option value="0">
													--请选择--
												</option>
												<logic:iterate id="rout" name="route">
													<option value="${rout.id}">
														${rout.routeName}
													</option>
												</logic:iterate>
											</logic:present>
										</select>
									</div>
								</div>
								<br>
							</td>
						</tr>
						<tr>
							<td width="25%">
								<div align="right">
									详细说明:
								</div>
							</td>
							<td class="gray">
								<textarea rows="5" cols="70" name="thingDetail"
									class="FormBase" onfocus="this.className='FormFocus';"
									onblur="this.className='FormBase';"></textarea>
								<span class="red" id="dictType">*</span>
								<br>
							</td>
						</tr>

						<tr>
							<td class="gray" colspan=2 style="text-align:center;">
								<input type="submit" name="Submit" value="添加"  />
								<input type="reset" name="Submit2" value="重填"  />
								<input type="button" name="stus" value="返回" 
									onClick="javascript:history.go(-1);" />
								<br>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
		<jsp:include page="/foot.jsp" />
	
</body>
</html:html>
