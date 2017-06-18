<%@ page language="java" import="java.util.*;import com.citybus.domain.LineString;import com.citybus.domain.TransInfo;" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>公交列表</title>
<%--导入css --%>
</head>
<style type="text/css">
html{height:100%;}
body{height:100%;margin:0px;padding:0px;}
#aside{position:absolute;top:146px;width:159px;border-right:1px solid #bbb;background:#ddd;}
#dituContent{margin-left:160px;}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=V6RjjChFXrifV2z41z0sYQEO"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/arrow.js"></script>
 <script type="text/javascript">
 	function searc(){
 		var va = document.getElementById("va").value;
 		if(va==""){
 			alert("请输入线路名称！");
 		}else{
 			window.location.href="${pageContext.request.contextPath}/servlet/lineShow?lname="+va;
 		}
 		return;
 	}
 </script>  
<body class="main" onload="fun('${list1}','${listS}')">
		<jsp:include page="head.jsp" />
		<jsp:include page="menu_search.jsp" />
<div id="main">
    <div id="aside">
    <input type="text" value="${lname }" id="va"/><br>
    <input type="button" value="线路搜索" onclick="searc()"/> 
    
    </div>
    <div id="dituContent"></div>
</div></body>
<script type="text/javascript">
function fun(arr,arr1){
	  	var h = document.documentElement.clientHeight;
	    document.getElementById('aside').style.height = h - 80 + "px";
	    document.getElementById('dituContent').style.height = h - 80 + "px";
		// createMap();//创建地图  
		var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图  
        var point = new BMap.Point(125.099953,46.595395);//定义一个中心点坐标  
        map.centerAndZoom(point,13);//设定地图的中心点和坐标并将地图显示在地图容器中  
        window.map = map;//将map变量存储在全局  
        // setMapEvent();//设置地图事件  
 		map.enableDragging();//启用地图拖拽事件，默认启用(可不写)  
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小  
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)  
        map.enableKeyboard();//启用键盘上下左右键移动地图  
         // addMapControl();//向地图添加控件  
         //向地图中添加缩放控件  
        var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});  
        map.addControl(ctrl_nav);  
        //向地图中添加比例尺控件  
        var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});  
        map.addControl(ctrl_sca);
        /* for(var i=0;i<arr.length;i++){
    		alert(arr[i]);
    	}   */
    	
        //标注线数组  
    	var a = arr.split(",");
    	a[0] = a[0].toString().substring(1);
   		 a[a.length-1] = a[a.length-1].toString().substring(0,a[a.length-1].length-2);
    	/* for(var i=0;i<a.length;i++){
    		alert(a[i]);
    	} */
            var points = [];  
            for(var j=0;j<a.length;j++){  
                var p1 = a[j].split("|")[0];  
                var p2 = a[j].split("|")[1];  
                points.push(new BMap.Point(p1,p2));  
            }  
            var b = arr1.split(",");
            b[0] = b[0].toString().substring(1);
   		 b[b.length-1] = b[b.length-1].toString().substring(0,b[b.length-1].length-1);
            
            var line = new BMap.Polyline(points,{strokeWeight:6,strokeColor:"red",strokeOpacity:0.6});  
            map.addOverlay(line);  
            addArrow(line,b); 
}

</script>

</html>
