<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="css/IconExtension.css" />
	<link rel="stylesheet" type="text/css" href="css/adminmainpage.css" />
  </head>
  
  <body class="easyui-layout" style="overflow-y: hidden">
  	<noscript>
		<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    		<img src="image/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
    <div region="north" style="height:50px;background:#29A7E1;">
    	<span class="logo">用户管理系统</span>
    	<span class="userinfo">您好，${sessionScope.user.userName }&nbsp;<a id="openModifyPwd" href="javascript:void(0);">修改密码</a>&nbsp;<a id="logout" href=" javascript:void(0);">安全退出</a></span>
    </div>
    <div region="west" title="导航菜单" split="true" style="width:200px;">
    	<div id="functions">
    		<div title="系统管理">
    			<p pageurl='usermanagepage.action'>用户管理</p>
    			<p pageurl='projectmanage.jsp'>项目管理</p>
    		</div>
    		<div title="其他">
    			<p pageurl='else.jsp'>其他</p>
    		</div>
    	</div>
    </div>
    <div region="center">
    	<div id="tabs">
    		<div title="主页" iconCls="icon-home" style="padding:0 10px;display:bolck;">
    			欢迎来到后台管理系统
    		</div>
    	</div>
    </div>
    <div region="south" style="height:25px;line-height:23px;text-align:center;color:#15428B;font-weight:bold;background:#D2E0F2;">
    	by wujie 85132130@qq.com
    </div>
    
    <div id="modifypwd">
    	<p>原始密码：<input id="oldpwd" type="password" class="easyui-textbox"/></p>
    	<p>新&nbsp;密&nbsp;码：<input id="newpwd" type="password" class="easyui-textbox"/></p>
    	<p>确认密码：<input id="confirmpwd" type="password" class="easyui-textbox"/></p>
    </div>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
   	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/adminmainpage.js"></script>
  </body>
</html>
