<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>

</HEAD>
<script type="text/javascript">
	//设置类别的默认值
	function abc(a,b,c){
		var type=document.getElementById("type");
		var company=document.getElementById("company");
		type.selected=""
		if(c!=null&&c!=""){
			alert(c);
		}
		var ops = type.options;//得到下拉列表中的所有option标签数组
		for ( var i = 0; i < ops.length; i++) {

			if (ops[i].value == a) {//判断哪一个option选项中的value值与t(当前书的类名称)相等
				ops[i].selected = true;//相等则把selected=selected加上
			}
		}
		var ops1 = company.options;//得到下拉列表中的所有option标签数组
		for ( var i = 0; i < ops1.length; i++) {

			if (ops1[i].value == b) {//判断哪一个option选项中的value值与t(当前书的类名称)相等
				ops1[i].selected = true;//相等则把selected=selected加上
				return;
			}
		}
	}
</script>
<body onload="abc('${line.type}','${line.company }','${admin_msg }')">
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath }/servlet/updateLineServlet" method="post">
	
	<input type="hidden" name="lid" value="${line.lid }"/>
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="6"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">线路名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="lname" class="bg" value="${line.lname }" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">线路类型：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="type"
					id="type">
						<option value="" selected="selected">--选择线路类型--</option>
						<option value="城区专线">城区专线</option>
						<option value="郊区专线">郊区专线</option>
						<option value="其他">其他</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">公交公司：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="company"
					id="company">
						<option value="" selected="selected">--选择公司--</option>
						<option value="公交一公司">公交一公司</option>
						<option value="公交二公司">公交二公司</option>
						<option value="公交三公司">公交三公司</option>
						<option value="公交四公司">公交四公司</option>
						<option value="公交五公司">公交五公司</option>
				</select>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">负责人：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
				name="people" class="bg"  value="${line.people }" /></td>
				
			</tr>
		<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">联系方式：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="tel" class="bg"  value="${line.tel }" /></td>
		</tr>

		
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>




</body>
</HTML>