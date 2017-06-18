<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>citybus注册页面</title>
<%--导入css --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
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
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/servlet/checkImgServlet?time="+ new Date().getTime();
	}
	function ckValue() {
		//alert("aa");
		var theEmail=document.getElementsByName("email")[0].value;
		var username=document.getElementsByName("username")[0].value;
		var password=document.getElementsByName("password")[0].value;
		var repassword=document.getElementsByName("repassword")[0].value;
		var gender=document.getElementsByName("gender")[0].value;
		var ckcode=document.getElementsByName("ckcode")[0].value;
		var form1=document.getElementById("form1");
		 var Email = theEmail.toLowerCase();
    
    var count = 0;
    var fullEmail;
    if (Email.length!=0 && Email.indexOf('@') != -1 && Email.indexOf('.') != -1 && (Email.indexOf('.') - Email.indexOf('@') > 1)){
        //开头不能有@和点 & 结尾不能有@和点
        if ((Email.length-1) != Email.indexOf('@') && (Email.length-1) !=Email.indexOf('.') && Email.indexOf('@')!=0 && Email.indexOf('.')!=0){
            for (var i=0;i<Email.length;i++){
            fullEmail=Email.charAt(i);
              if ((fullEmail>= 'a' && fullEmail<= 'z') || (fullEmail >= 0 && fullEmail<= 9) || (fullEmail == '-') || (fullEmail == '@') || (fullEmail == '.')){
                  if (fullEmail == '@'){
                     count++;
                  }
              }else{
               alert("你的邮箱存在非法字符！");
              }
          }
          if((Email.indexOf('@')+1)<3 || (Email.indexOf('@')+1)>45){
           alert("‘@'符号左边至少3为最多45位字符！");
                }
               //不能有两个"@" 
                if (count != 1){
                alert("邮箱不能有两个‘@’");
               }
        }else{
         alert("邮箱开头不能有‘@’或‘.’ 并且结尾不能有‘@’或 '.'！");
        }
    }else{
      alert("请正确填写你常用的邮箱地址！");
    }
		if(theEmail==""||username==""||username.length<6){
			alert("请填写完整信息！");
		}else if(password==""||repassword==""||password!=repassword){
			alert("请填写完整信息！");
		}else if(ckcode==""){
			alert("请填写完整信息！");
		}else{
			form1.submit();
		}
	}
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/myJS.js">
</script>
<script type="text/javascript">
			function ckUserName(){
				var username = document.getElementsByName("username")[0].value;
				//alert(username);
					//创建XMLHttpRequest对象
				var xhr = getXMLHttpRequest();
				//处理结果
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){//请求一切正常
						if(xhr.status==200){//服务器响应一切正常
							//alert(xhr.responseText);//得到响应结果
							var msg = document.getElementById("msg1");
							if(xhr.responseText=="true"){
								msg.innerHTML =  "<font color='red' id='yes'>该名称已被占用</font>";
								//msg.innerText = "<font color='red'>用户名已存在</font>";
							}else{
								msg.innerHTML = "<font color='green' id='no'>√ 可以使用</font>";
							}
						}
					}
				}
			//alert(name);
			//创建连接
			xhr.open("get","${pageContext.request.contextPath }/servlet/ckUserName?username="+username+"&time="+new Date().toString());
			//发送请求
			xhr.send(null);
			}
			
	
</script>
</head>


<body class="main">
	<%--导入头 --%>
	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />
	<div id="divcontent">
		<form id="form1"
			action="${pageContext.request.contextPath}/servlet/userRegister"
			method="post" onSubmit="return false" >
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>新用户注册 ${user_msg }</h1>

						<table width="70%" border="0" cellspacing="2" class="upline">
							<td style="text-align:right; width:20%">设置头像：</td>
								<td ><img id="touxiang" height="100"
									width="100" src="images/update_pic.png"><span
									style="visibility: hidden">重新上传</span> <a
									style="position:relative;display:block;width:100px;height:30px;background:#EEE;border:0px solid #999;text-align:center;"
									href="javascript:void(0);"> 浏览
										<form action="" method="post" enctype="multipart/form-data"
											id="upfrom">
											<input type="file" id="user_img" name="user_img1"
												onchange="uploadImage();"
												style="position:absolute;left:0;top:0;width:100px;height:100%;z-index:999;opacity:0;filter:alpha(opacity=0)">
										</form> </a></td>
							</tr>
							<tr>
								<td style="text-align:right; width:20%">会员邮箱：</td>
								<td style="width:40%"><input type="text" class="textinput"
									name="email" /></td>
								<td><font color="#999999" name="ckEmail">请输入有效的邮箱地址</font>
								</td>
								<input type="hidden" name="user_img" value="img/update_pic.png"/>
							</tr>
							<tr>
								<td style="text-align:right">会员名：</td>
								<td><input type="text" class="textinput" name="username" onblur="ckUserName()"/>
								</td>
								<td><span id="msg1"><font color="#999999">用户名设置至少6位</font></span></td>
							</tr>
							<tr>
								<td style="text-align:right">密码：</td>
								<td><input type="password" class="textinput"
									name="password" /></td>
								<td><font color="#999999">密码设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">重复密码：</td>
								<td><input type="password" class="textinput"
									name="repassword" /></td>
								<input type="hidden" name="regtime" id="regtime" value="" />
								<script type="text/javascript">
									  function today(){
										var today = new Date();
										var h=today.getFullYear();
										var m=today.getMonth()+1;
										var d=today.getDate();
										return h+"-"+m+"-"+d;
									  
									  }
									  document.getElementById("regtime").value = today();
									  </script>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right">性别：</td>
								<td colspan="2">&nbsp;&nbsp;<input type="radio"
									name="gender" value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
									name="gender" value="女" /> 女</td>
							</tr>


						</table>



						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input type="text" class="textinput"
									name="ckcode" />
								</td>
								<td>${ckcode_msg }</td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/servlet/checkImgServlet"
									width="180" height="30" class="textinput" style="height:30px;"
									id="img" />&nbsp;&nbsp; <a href="javascript:void(0);"
									onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>

						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input
									type="image"
									src="${pageContext.request.contextPath }/images/signup.gif"
									name="submit" onclick="ckValue()" border="0">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="${pageContext.request.contextPath }/images/logo1.png"
					width="195" height="50" style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2017 &copy; CityBus All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div>


</body>
</html>
