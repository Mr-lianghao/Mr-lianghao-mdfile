<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/images/css.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
<SCRIPT language=JavaScript src="images/css/Common.js"></SCRIPT>
<script type="text/javascript">
 window.onload=function(){
 	var user_img = document.getElementsByName("user_img");
 	var req_msg=document.getElementById("req_msg");
 	var replaycontent = document.getElementsByName("replaycontent");
 	var replay = document.getElementsByName("replay");
 	for(var i=0;i<replay.length;i++){
 		//alert(replay[i].value);
 		if(replay[i].value!=""){
 		//alert("ture");
 		replaycontent[i].style.display="";
 		} 
 	}
 	//alert(req_msg.value);
 	if(req_msg.value=="发布成功！"){
 		alert(req_msg.value);
 	}
 	if(req_msg.value=="请您先进行登陆才能完成该操作！"){
 		
 		if(confirm("发表留言需先登陆，是否立即登陆？")){
 			window.location.href="${pageContext.request.contextPath }/login.jsp"
 		}
 	}
 	
 	/* if(replay==null){
 		replaycontent.style="display:none;";
 	} */
 	
 
 }

	function checkGUEST(){
		//alert("aaa");
		var form1 =document.getElementById("form1");
		//var nickname = document.getElementById("nickname").value;
		var email = document.getElementById("email1").value;
		var qq = document.getElementById("qq").value;
		var content1 = document.getElementById("content1").value;
		var today = document.getElementById("today").value;
		if(email==""||qq==""||content1==""){
			alert("请填写完整信息！");
		}else{
			form1.submit();
		}
		
	}
	
	
  
</script>
<script type="text/javascript" src="./js/jquery.js"></script>
	    <script type="text/javascript" src="./js/jquery.form.js"></script>
	    <script type="text/javascript" src="./js/ajaxfileupload.js"></script>
        <script type="text/javascript">
			function uploadImage() {
				$.ajaxFileUpload({
					url: "${pageContext.request.contextPath}/servlet/upload1",
					secureuri:false,
					fileElementId:"user_img",
					dataType:"content",
					error: function(data, status, e) {
						alert(e);
					},
					success: function(data, textStatus) {
					//alert("data="+data);
					var start = data.indexOf(">");  
			            if(start != -1) {  
			              var end = data.indexOf("<", start + 1);  
			              if(end != -1) {  
			                data = data.substring(start + 1, end);  
			               }  
			            } 
			          // alert("data:"+data);
						$("#touxiang").attr('src',"${pageContext.request.contextPath}/upload/"+data); 
						
					}
				});
			}
  
		</script>

</head>

<title>留言</title>

<body class="main">
<jsp:include page="head.jsp" />
<jsp:include page="menu_search.jsp" />
<DIV align=center id="divpagecontent">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD >
<TABLE class=dragTable height=28 cellSpacing=0 cellPadding=0 width=100% align=center background=images/head1.gif border=0>
  <TBODY>
  <TR>
    <TD> 
    <div style="text-align:left; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;留言投诉
					</div>
	</TD>
	</TR>
  </TBODY>
</TABLE>
</TD>
</TR>
        <TR>
          <TD class=middle><br>
	<!--循环开始==============================================================-->
	
	<!-- 上面是进行分页并进行初始化 -->
	
	<TABLE class=guestbook cellSpacing=0 cellPadding=0 width="100%" 
            border=0>
           
              <TBODY>
               <c:forEach items="${pbg.list }" var="list">
               <input type="hidden" name="user_img" value="${list.user_img}"/>
              <TR>
                <TD class=Ftd align=middle width="18%" rowSpan=2>
                  <DIV class=icon><IMG height=80  src="${pageContext.request.contextPath }/upload/${list.user_img}" width=80 border=0></DIV>
                  <DIV class=name>用户：${list.nickname }</DIV></TD>
                <TD class=Ctd vAlign=top width="82%" height=75>
                  <TABLE style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=0 cellPadding=0 width="80%" border=0>
                    <TBODY>
                    <TR>
                      <TD class=content align=left  >
                      		
					  		${list.content1 }
                      
                     <!--  // if(!replay.isEmpty()){	 --> 
                       
                        <FIELDSET name="replaycontent" style="display:none;">
                        <input  type="hidden" name ="replay" value="${list.replaycontent }"/>
						<LEGEND>回复: </LEGEND> 
                       ${list.replaycontent } (署名 ${list.replayer }: /日期: ${list.replaytime})
						</FIELDSET>
					  </TD>
					 </TR>
					
					</TBODY>
				</TABLE>
				</TD>
				</TR>
              <TR>
                <TD class=Atd width="82%">
                时间： ${list.addtime }&nbsp;
					</TD>
			  </TR>
			   </c:forEach>
			  </TBODY>
			  
			  </TABLE>
			  

	<!--循环结束==================================================================-->        
          <br>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD style="text-align:right">
             <SPAN >第${pbg.currentPage }/ ${pbg.totalPage }页 每页 ${pbg.pageSize}条 <Aclass=a01href="${pageContext.request.contextPath }/servlet/findGuestBookAll?currentPage=1">首页</A>
			<A class=a01 href="${pageContext.request.contextPath }/servlet/findGuestBookAll?currentPage=${pbg.currentPage==1?1:pbg.currentPage-1}">上一页</A>
			<A class=a01	href="${pageContext.request.contextPath }/servlet/findGuestBookAll?currentPage=${pbg.currentPage==pbg.totalPage?pbg.totalPage:pbg.currentPage+1}">下一页</A>
			<A class=a01 href="">末页</A>
			</SPAN>
			</TD>
                </TR>
                </TBODY>
                </TABLE></TD></TR>
        <TR>
          <TD class=foot>
            <H3 class=L></H3>
            <H3 class=R></H3></TD></TR></TBODY></TABLE>
<TABLE class=dragTable height=28 cellSpacing=0 cellPadding=0 width=100% align=center border=0>
        <TBODY>
        <TR>
          <TD align=left class=head>&nbsp;留言投诉</TD></TR>
        <TR>
          <TD class=middle>
<STYLE type=text/css>.selected {
	BORDER-RIGHT: #ff9900 1px solid; BORDER-TOP: #ff9900 1px solid; FILTER: Alpha(opacity=100); BORDER-LEFT: #ff9900 1px solid; BORDER-BOTTOM: #ff9900 1px solid
}
.unselected {
	BORDER-RIGHT: #edf8dd 1px solid; BORDER-TOP: #edf8dd 1px solid; FILTER: Alpha(opacity=50); BORDER-LEFT: #edf8dd 1px solid; BORDER-BOTTOM: #edf8dd 1px solid
}
</STYLE>


<FORM name="form1" action="${pageContext.request.contextPath }/servlet/guestAdd"method="post" id="form1" onSubmit="return false" >
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <input type="hidden" id="req_msg" value="${req_msg }"/>
              <TR>
                <TD width="24%" style="text-align:right">昵&nbsp;&nbsp;&nbsp;&nbsp;称: </TD>
                <TD align=left><INPUT name=nickname id="nickname" maxlength=20 value="${user.username }" readonly> 联系Email: 
                <INPUT name=email id="email1" maxlength=20> QQ: <INPUT size=12 id="qq" name=qq maxlength=11>
                <input type="hidden" name="gid" value="${user.id}" /> 
                <input type="hidden" name="addtime" value="" id="today"/> 
				<script type="text/javascript">
				  function today(){
					var today = new Date();
					var h=today.getFullYear();
					var m=today.getMonth()+1;
					var d=today.getDate();
					return h+"-"+m+"-"+d;
				  
				  }
				  document.getElementById("today").value = today();
				  </script>
              </TD></TR>
             
              <TR>
                <TD width="24%" style="text-align:right">留言投诉:</TD>
                <TD align=left><TEXTAREA name=content1 id=content1 size=100 rows=7 cols=80></TEXTAREA> 
                </TD></TR>
              <TR>
                <TD width="24%">&nbsp;</TD>
                <TD align=left><INPUT type="button" value="提 交" onclick="checkGUEST()" name=Submit> 
            </TD></TR></TBODY></TABLE></FORM></TD></TR>
        <TR>
          <TD >
            <H3></H3>
            <H3></H3></TD></TR></TBODY></TABLE>
</DIV>
	<jsp:include page="foot.jsp" />
</body>
</html>