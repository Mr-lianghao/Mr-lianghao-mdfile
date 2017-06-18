<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<title>dealVip.jsp</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath }/admin/css/style1.css">
		<link href="${pageContext.request.contextPath }/admin/css/addChance.css" rel="stylesheet"
			type="text/css">
		<link href="${pageContext.request.contextPath }/admin/css/Admin.css"
			rel="stylesheet" type="text/css">

		<script src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script
			src='${pageContext.request.contextPath }/dwr/interface/SpotBiz.js'></script>
		<script type="text/javascript">
		   		var widthDiv;
               function show(obj){
	               	widthDiv = obj.offsetWidth;//文本框的宽度，层随此宽度
	                var uname = obj.value;
	                SpotBiz.findByPartWord(uname,huiDao1);	
         	 	}
		    function huiDao1(args){
		      var content = "<table width=100% height=50%>";
			   for(var i in args){
			    content+="<tr width=\"100%\" onmouseover=\"this.style.background='#CCCCCC'\" onmouseout=\"this.style.background=''\">";
			    content+="<td onclick='sel(this)' style='cursor:hand'>";//添加点击事件和手形样式
			    content+=args[i].spotName;//内容
			    content+="</td></tr>";
			   }
			    content += "</table>";
			   document.getElementById("show").style.display="block";//显示层
			   document.getElementById("show").style.width=widthDiv;//设定层的宽度和文本框同宽
			   document.getElementById("show").innerHTML=content;
			}
			function sel(obj){
			   document.getElementById("spot").value=obj.innerHTML;//把点击选中的内容赋值给文本框
			   document.getElementById("show").style.display="none";//层隐藏

		   }
		   function loseFocus(listStation,listOrde)
		   {
		     document.getElementById("change").blur();
		     
		   }
		   
		</script>
	</head>

	<body onload="loseFocus('${listStation}','${listOrde }');">
		<table width="100%" border="0" align="left" cellpadding="0"
			cellspacing="0" bordercolor="#E2E2E1" bgcolor="#FFFFFF">
			<tr>
				<td width="100%" valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						background="">
						<tr>
							<TD width="2%" height=33>
								<DIV align=center>
									<IMG src="/images/sy.gif">
								</DIV>
							</TD>
							<td class="place" colspan="9">
								公交管理&gt;站点线路管理&gt;修改
							</td>
						</tr>
						<tr>
					</table>
				<td>
			</tr>
			<tr>
				<td>
					<br>
					<form method="post" action="${pageContext.request.contextPath }/servlet/insertLineStationServlet">
						<table width="100%" border="0" cellpadding="6" cellspacing="1"
							bgcolor="#C0CCDD" id="content">
							<tr class="top">
								<td height="25" align="center">
									<div align="right">
										<font size=+1><b>基本信息</b>
										</font>
									</div>
									<br>
								</td>
								<td height="25" align="left" colspan=3>

									<br>
								</td>
							</tr>
							<tr>

								<td class="gray" colspan=4 align="left">
									<font color=red size=+1><b>${line.lname }</b>
									</font><font size=+1>线路站点修改：</font>
									<br>
								</td>
							</tr>
							<tr>
								<td width="25%">
									<div align="right">
										线路类型：
									</div>
								</td>
								<td class="gray" colspan=3>
									${line.type }
							</tr>
							<tr>
								<td width="25%">
									<div align="right">
										所属公司:
									</div>
								</td>
								<td class="gray" colspan=3>
									${line.company }
								</td>
							</tr>
							<tr>
								<td width="25%">
									<div align="right">
										线路负责人：
									</div>
								</td>
								<td class="gray" colspan=3>
									${line.people }
									<br>
								</td>
							</tr>
							<tr>
								<td width="25%">
									<div align="right">
										联系方式：
									</div>
								</td>
								<td class="gray" colspan=3>
									${line.tel }
									<br>
								</td>
							</tr>
							<tr>
								<td width="25%">
									<div align="right">
										选择站点:
									</div>
								</td>
								<td class="gray">
									所有站点:
									<br>
									<input type="text" name="spot" id="spot" size="25"
										onkeyup="show(this)" onclick="unfocusLeftNode();"
										class="FormBase" onfocus="this.className='FormFocus';"
										onblur="this.className='FormBase';" />
									<input type="button" name="" value="OK"
										onclick="selectInputData(spot.value);" class="anybutton" />
									<div
										style="border:1px; width:150px;background-color:#0099CC;position:absolute;z-index:1;display:none;overflow:scroll;"
										id="show"></div>

									<select name="listLeft" id="listLeft" size="6"
										multiple="multiple" style="width:180px"
										ondblclick="removeOne(listLeftnode,listRightnode);">
										<c:forEach items="${listStation}" var="listStation">
											<option value="${listStation.sname}">
													${listStation.sname}
												</option>
										</c:forEach>
									</select>
								</td>
								<td>
									<div>
										<input type="button" name="allRightMove" id="allRightMove"
											value=" >> " class="anybutton"
											onclick="removeAll(listLeftnode,listRightnode);" />
										<br />
										<input type="button" name="rightMove" id="rightMove"
											 value="  > " class="anybutton"
											onclick="removeOne(listLeftnode,listRightnode);" />
										<br />
										<input type="button" name="leftMove" id="leftMove"
											value="  < " class="anybutton"
											onclick="removeOne(listRightnode,listLeftnode);" />
										<br />
										<input type="button" name="allLeftMove" id="allLeftMove"
											value=" << " class="anybutton"
											onclick="removeAll(listRightnode,listLeftnode);" />
										<br />
										<input type="button" value=" ↑ "
											onclick="shiftUp(listRightnode);" class="anybutton" />
										<br />
										<input type="button" value=" ↓ "
											onclick="shiftDown(listRightnode);" class="anybutton" />

									</div>
								</td>
								<td>
									最终站点：
									<br>
									<select name="stationOrde" size="7" multiple="multiple"
										style="width:180px" id="listRight"
										ondblclick="removeOne(listRightnode,listLeftnode);">
										<c:forEach items="${listOrde}" var="listOrde">
											<option value="${listOrde.sname}">
													${listOrde.sname}
												</option>
										</c:forEach>
									</select>
									<input type="hidden" name="lid" value="${line.lid }" />
									<input type="hidden" name="lname" value="${line.lname }" />
									<br>
								</td>
							</tr>

							<tr>
								<td class="gray" colspan=4 align="center">
									<input type="submit" name="change" value="修改" class="anybutton"
										onclick="selectall();" />
									<input type="reset" name="Submit2" value="重填" class="anybutton" />
									<input type="button" name="stus" value="返回" class="anybutton"
										onClick="javascript:history.go(-1);" />
									<br>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
 var listLeftnode = document.getElementById("listLeft");
 var listRightnode = document.getElementById("listRight");
 var btallRightMove = document.getElementById("allRightMove");
 var btRightMove = document.getElementById("rightMove");
 var btLeftMove = document.getElementById("leftMove");
 var btallLeftMove = document.getElementById("allLeftMove");
 function selectall()
{
  for (i=0;i<listRightnode.options.length;i++)
   {
   listRightnode.options[i].selected=true;
   }

}
function unfocusLeftNode()
{
  for (i=0;i<listLeftnode.options.length;i++)
   {
   listLeftnode.options[i].selected=false;
   }

}
function selectInputData(obj)
{

  for (i=0;i<listLeftnode.options.length;i++)
   {
   if(listLeftnode.options[i].text==obj)
   {
   listLeftnode.options[i].selected=true;
   removeOne(listLeftnode,listRightnode);
   }
   }

}
 function isEmpty()
 {
  if(listLeftnode.options.length<1)
  {
   btallRightMove.setAttribute("disabled","disabled");
   btRightMove.setAttribute("disabled","disabled");
  }
  else
  {
   btallRightMove.removeAttribute("disabled");
   btRightMove.removeAttribute("disabled");  
  } 
  if(listRightnode.options.length<1)
  {
   btallLeftMove.setAttribute("disabled","disabled");
   btLeftMove.setAttribute("disabled","disabled");
  }
  else
  { 
   btallLeftMove.removeAttribute("disabled");
   btLeftMove.removeAttribute("disabled");   
  } 
 }
 
 function removeOne(beginList, endList)
 {
  var flag=false;
  for(i=beginList.options.length-1; i>=0; i--)
  { 
   if(beginList.options[i].selected)
   {   flag=true;
    var tempOption = beginList.options[i];
    if(!OptionExists(endList,beginList.options[i].text,beginList.options[i].value)){
    beginList.remove(i);
    endList.add(tempOption, endList.last);
    }
   }
  }
  if(!flag)
  {
   alert("您没有选择，不能移动！！");
  }
  
    
 }
 
 function removeAll(beginList,endList)
 {
  for(i=beginList.options.length-1; i>=0; i--)
  {   
   var tempOption = beginList.options[i];
   if(OptionExists(endList,beginList.options[i].text,beginList.options[i].value))
    {
      alert("目标对象中已经存在该选项！！");
    }
   if(!OptionExists(endList,beginList.options[i].text,beginList.options[i].value)){
   beginList.remove(i);
   endList.add(tempOption, endList.first);
   }
  }
   
 }
 //上移   
 function shiftUp(oListbox) {   
        if(oListbox.selectedIndex > 0){   
            var oOption = oListbox.options[oListbox.selectedIndex];   
            var oPrevOption = oListbox.options[oListbox.selectedIndex-1];   
            oListbox.insertBefore(oOption,oPrevOption);   
        }   
    }   
    //下移   
 function shiftDown(oListbox){   
        if(oListbox.selectedIndex < oListbox.options.length-1){   
            var oOption = oListbox.options[oListbox.selectedIndex];   
            var oNextOption = oListbox.options[oListbox.selectedIndex+1];   
            oListbox.insertBefore(oNextOption,oOption);   
        }   
    }   
 
 
 function OptionExists(list, optText, optValue) 
{ 
var i = 0; 
var find = false; 

//按值进行重复值检查 
for (i=0; i<list.options.length; i++) 
{ 
if (list.options[i].value == optValue) 
{ 
find = true; 
break; 
} 
} 
return find; 
} 
 
</script>
	</body>
</html>