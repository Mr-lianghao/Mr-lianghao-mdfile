function addArrow(line,b){ //绘制标注的函数  
	alert(b);
	var linePoint=line.getPath();//线的坐标串  
    var arrowCount=linePoint.length;  
    var start = new BMap.Marker(linePoint[0]);  // 创建标注  
    var end = new BMap.Marker(linePoint[linePoint.length-1]);  // 创建标注  
    map.addOverlay(start);  // 将标注添加到地图中  
    map.addOverlay(end);  
    end.setAnimation(BMAP_ANIMATION_DROP); //跳动的动画  
    start.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画  
    //节点图标
    var myIcon = new BMap.Icon("http://api0.map.bdimg.com/images/stop_icon.png", new BMap.Size(11,11));  
    for(var i =0;i<arrowCount;i++){ //在拐点处添加标注  
        var marker = new BMap.Marker(linePoint[i],{icon:myIcon});  // 创建标注  
        map.addOverlay(marker);              // 将标注添加到地图中  
        var label = new BMap.Label(""+b[i]+"",{offset:new BMap.Size(20,-10)});  
        label.setStyle({  
            color : "blue",  
            fontSize : "10px",  
            height : "15px",  
            lineHeight : "15px",  
            backgroundColor:"rgba(255, 255, 255, 0.8) none repeat scroll 0 0 !important",//设置背景色透明  
            border:"1px solid blue"  
        });  
        marker.setLabel(label);  
    }  
}  