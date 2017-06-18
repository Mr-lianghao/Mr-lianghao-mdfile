<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">

<script type="text/javascript">
	function ck(){
		var pointX=document.getElementById("pointX").value;
		var pointY=document.getElementById("pointY").value;
		var sname=document.getElementById("sname").value;
		var form1=document.getElementById("Form1");
		if(pointX==""||pointY==""||sname==""||sname==null){
			alert("请填写完整信息！");
		}else{
			if(pointX>125.80||pointX<123.76){
				alert("请输入合法的纬度！");
			}else{
				if(pointY>47.48||pointY<45.38){
					alert("请输入有效的经度值！")
				}else{
						form1.submit();		
				}
			}
		}
	return ;
	}
</script>
</HEAD>

<body>
	<form id="userAction_save_do" name="Form1" id="Form1"
		action="${pageContext.request.contextPath }/servlet/addStationServlet" method="post" onSubmit="return false">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="5"
					height="26"><strong><STRONG>添加站点</STRONG> </strong>
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">站点名称：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input type="text"
					name="sname" class="bg" id="sname"/><span><font color="#999999">请输入正确的站点名称</font></span>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">站点经度：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input type="text"
					name="pointX" class="bg" id="pointX"/><span><font color="#999999">范围：123.760986328125000-125.804443359375000</font></span>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">站点纬度：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input type="text"
					name="pointY" class="bg" id="pointY"/><span><font color="#999999">范围：45.383019278990638-47.487513008956569</font></span>
			</tr>
			
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					
					
						
					<input type="button" class="button_ok" value="确定" onclick="ck()">	
						
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					
					
					
					<input type="reset" value="重置" class="button_cancel">

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1">
					
					</span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>