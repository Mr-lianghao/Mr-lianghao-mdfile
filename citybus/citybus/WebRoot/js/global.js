function ignoreError() {
  return true;
}
window.onerror = ignoreError; 
function g(id) {
	return document.getElementById(id);
}

function in_array(needle, haystack) {
	if(typeof needle == 'string' || typeof needle == 'number') {
		for(var i in haystack) {
			if(haystack[i] == needle) {
					return true;
			}
		}
	}
	return false;
}
function isUndefined(variable) {
	return typeof variable == 'undefined' ? true : false;
}

var Ajaxs = new Array();
var AjaxStacks = new Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
var attackevasive = isUndefined(attackevasive) ? 0 : attackevasive;
function Ajax(recvType, waitId) {

	for(var stackId = 0; stackId < AjaxStacks.length && AjaxStacks[stackId] != 0; stackId++);
	AjaxStacks[stackId] = 1;

	var aj = new Object();
	

	aj.loading = 'Loading...';//public
	aj.recvType = recvType ? recvType : 'XML';//public
	aj.waitId = waitId ? g(waitId) : null;//public

	aj.resultHandle = null;//private
	aj.sendString = '';//private
	aj.targetUrl = '';//private
	aj.stackId = 0;
	aj.stackId = stackId;

	aj.setLoading = function(loading) {
		if(typeof loading !== 'undefined' && loading !== null) aj.loading = loading;
	}

	aj.setRecvType = function(recvtype) {
		aj.recvType = recvtype;
	}

	aj.setWaitId = function(waitid) {
		aj.waitId = typeof waitid == 'object' ? waitid : g(waitid);
	}

	aj.createXMLHttpRequest = function() {
		var request = false;
		if(window.XMLHttpRequest) {
			request = new XMLHttpRequest();
			if(request.overrideMimeType) {
				request.overrideMimeType('text/xml');
			}
		} else if(window.ActiveXObject) {
			var versions = ['Microsoft.XMLHTTP', 'MSXML.XMLHTTP', 'Microsoft.XMLHTTP', 'Msxml2.XMLHTTP.7.0', 'Msxml2.XMLHTTP.6.0', 'Msxml2.XMLHTTP.5.0', 'Msxml2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP'];
			for(var i=0; i<versions.length; i++) {
				try {
					request = new ActiveXObject(versions[i]);
					if(request) {
						return request;
					}
				} catch(e) {}
			}
		}
		return request;
	}

	aj.XMLHttpRequest = aj.createXMLHttpRequest();
	aj.showLoading = function() {
		if(aj.waitId && (aj.XMLHttpRequest.readyState != 4 || aj.XMLHttpRequest.status != 200)) {
			changedisplay(aj.waitId, '');
			aj.waitId.innerHTML = '<span><img src="' + IMGDIR + '/loading.gif"> ' + aj.loading + '</span>';
		}
	}

	aj.processHandle = function() {
		if(aj.XMLHttpRequest.readyState == 4 && aj.XMLHttpRequest.status == 200) {
			for(k in Ajaxs) {
				if(Ajaxs[k] == aj.targetUrl) {
					Ajaxs[k] = null;
				}
			}
			if(aj.waitId) changedisplay(aj.waitId, 'none');
			if(aj.recvType == 'HTML') {
				aj.resultHandle(aj.XMLHttpRequest.responseText, aj);
			} else if(aj.recvType == 'XML') {
				aj.resultHandle(aj.XMLHttpRequest.responseXML.lastChild.firstChild.nodeValue, aj);
			}
			AjaxStacks[aj.stackId] = 0;
		}
	}

	aj.get = function(targetUrl, resultHandle) {

		setTimeout(function(){aj.showLoading()}, 500);
		if(in_array(targetUrl, Ajaxs)) {
			return false;
		} else {
			Ajaxs.push(targetUrl);
		}
		aj.targetUrl = targetUrl;
		aj.XMLHttpRequest.onreadystatechange = aj.processHandle;
		aj.resultHandle = resultHandle;
		var delay = attackevasive & 1 ? (aj.stackId + 1) * 1001 : 100;
		if(window.XMLHttpRequest) {
			setTimeout(function(){
			aj.XMLHttpRequest.open('GET', aj.targetUrl);
			aj.XMLHttpRequest.send(null);}, delay);
		} else {
			setTimeout(function(){
			aj.XMLHttpRequest.open("GET", targetUrl, true);
			aj.XMLHttpRequest.send();}, delay);
		}

	}
	aj.post = function(targetUrl, sendString, resultHandle) {
		setTimeout(function(){aj.showLoading()}, 500);
		if(in_array(targetUrl, Ajaxs)) {
			return false;
		} else {
			Ajaxs.push(targetUrl);
		}
		aj.targetUrl = targetUrl;
		aj.sendString = sendString;
		aj.XMLHttpRequest.onreadystatechange = aj.processHandle;
		aj.resultHandle = resultHandle;
		aj.XMLHttpRequest.open('POST', targetUrl);
		aj.XMLHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		aj.XMLHttpRequest.send(aj.sendString);
	}
	return aj;
}

function changedisplay(obj, display) {
	if(display == 'auto') {
		obj.style.display = obj.style.display == '' ? 'none' : '';
	} else {
		obj.style.display = display;
	}
	return false;
}

function createSelect(id,arrText,arrValue) {
	arrValue= typeof arrValue == 'undefined'? arrText : arrValue;
	var selectObj = document.getElementsByTagName("SELECT");
	var selectObjNow = selectObj[id];
	selectObjNow.length = 0;
	var selectLength = arrText.length;
	var optionObj;
	for (i=0; i<selectLength; i++){
		optionObj = document.createElement("OPTION");
		optionObj.text=arrText[i];
		optionObj.value=arrValue[i];
		selectObjNow.options.add(optionObj);
	}
	return true;
}
function jsSelectItemByValue(objSelect,objItemValue){
    for(var i=0;i<objSelect.options.length;i++){
        if(objSelect.options[i].value == objItemValue){
            objSelect.options[i].selected = true;
            break;
        }
    }      
}
function s(st,ct){
	var url;
	var urlAdd;
	if(st==1){
		var k=g('k1').value;
		if(k=='' || k=='例:某路'){
			alert('路线不能为空!');
			g('k1').value='';
			g('k1').focus();
			return false;
		}
	}
	else if(st==2){
		var k=g('k2').value;
		if(k=='' || k=='例:站点'){
			alert('站点不能为空!');
			g('k2').value='';
			g('k2').focus();
			return false;
		}
	}
	else if(st==3){
		var k1=g('k31').value;
		var k2=g('k32').value;
		if(k1=='' || k1=='例:起点站'){
			alert('起点站不能为空!');
			g('k31').value='';
			g('k31').focus();
			return false;
		}
		if(k2=='' || k2=='例:终点站'){
			alert('终点站不能为空!');
			g('k32').value='';
			g('k32').focus();
			return false;
		}
	}
	else{
		return false;
	}
	return true;
}
function mcopy(id){
	var obj=g(id);
	var t=obj.value;
	clipboardData.setData('Text',t);
	alert('已复制');
}
/**获取cookie值*/
function getCookie(cookiename){
	var thebigcookie = document.cookie;
	var firstchar = thebigcookie.indexOf(cookiename);
	if (firstchar != -1) {
	firstchar += cookiename.length + 1;
	lastchar = thebigcookie.indexOf(";",firstchar);
	if(lastchar == -1) lastchar = thebigcookie.length;
	return unescape(thebigcookie.substring(firstchar, lastchar));
	}
	return "";
}
/**设置cookie值*/
function setCookie(cookiename,cookievalue,expiryday,domainname){
	var dt=new Date(); 
	dt.setTime(dt.getTime()+(expiryday*86400000)); 
	document.cookie = cookiename + "=" + cookievalue
	+ "; domain=" + domainname
	+ "; path=" + "/"
	+ "; expires=" + dt.toGMTString();
	
}
function ewaveholder_show(obj){
	var holder=obj.attr('ewaveholder');
	if(typeof obj!='object' || obj.val()!='' || holder===undefined || holder == '') {
		ewaveholder_hide(obj);
		return;
	}
	var id=obj[0].tagName+'_'+obj.attr('name')+'_'+(obj.attr('id')!=undefined?obj.attr('id'):'');
	if($('#'+id).length>0) $('#'+id).remove();
	var html = '<div style="position:absolute;color:#ccc;z-index:9999;font-size:14px;margin:0;padding:0;border:0;white-space:nowrap;display:none;" id="'+id+'">'+holder+'</div>';
	$(document.body).append(html);
	var left=parseInt(obj.offset().left)+9;
	var top=parseInt(obj.offset().top)+8;
	$('#'+id).css({left:left,top:top}).show();
	$('#'+id).one('click',function(){
		var iid=$(this).attr('id');
		var iids=iid.split('_');
		var type=iids[0];
		var name=iids[1];
		var id=type;
		if(iids[2]){
			id+='#'+iids[2];
		}
		id+='[name="'+name+'"]';
		$('#'+iid).remove();
		$(id).focus();
	});
}
function ewaveholder_hide(obj){
	var id=obj[0].tagName+'_'+obj.attr('name')+'_'+(obj.attr('id')!=undefined?obj.attr('id'):'');
	$('#'+id).remove();
}
function ewaveholder(){
	try{
		var eachholder=function(){
			$('input[ewaveholder]').each(function(k,v){
				ewaveholder_show($(v));
			});
			$('textarea[ewaveholder]').each(function(k,v){
				ewaveholder_show($(v));
			});
		}
		$('input[ewaveholder]').focus(function(){
			ewaveholder_hide($(this));
		}).blur(function(){
			ewaveholder_show($(this));
		});
		$('textarea[ewaveholder]').focus(function(){
			ewaveholder_hide($(this));
		}).blur(function(){
			ewaveholder_show($(this));
		});
		eachholder();
		if($.browser.msie && parseInt($.browser.version)==6){
			var t=0;
			window.onresize=function(){
				var now = new Date();
				now = now.getTime();
				 if (now - t > 300) {
					 t = now;
					 setTimeout(function(){eachholder();},200);
				 }
			};
		}
		else{
			$(window).resize(function(){eachholder();});
		}
	}
	catch(e){}
}
function topic_submit(){
	var form = $('form[name="topic"]');
	var data = form.serializeArray();
	$.post('/topic.php',data,function(result){
		if(result==1){
			alert('最多只能输入140个字！');
			$('textarea[name="content"]',form).focus();
		}
		else{
			alert('发布成功，感谢您的评论，我们将尽快为您审核。');
			$('textarea[name="content"]',form).val('');		
		}
	});
	return false;
}
