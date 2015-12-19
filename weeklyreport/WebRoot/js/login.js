$(function() {
	
	var loginObj = {
		login : function() {
			if(!$('#loginname').validatebox('isValid')) {
				$.messager.alert('提示', '请输入账号', 'info');
			}
			if(!$('#password').validatebox('isValid')) {
				$.messager.alert('提示', '请输入密码', 'info');
			}
			$.ajax({
				method: 'POST',
				url: 'login.action',
				data: {
					loginName: $('#loginname').val(),
					password: $('#password').val(),
				},
				beforeSend: function() {
					$.messager.progress({
						text: '登录中...',
					});
				},
				success: function(data) {
					$.messager.progress('close');
					if(typeof data == 'string') {
						data = JSON.parse(data);
					}
					if('retCode' in data && data.retCode == 0) {
						location.href = '/weeklyreport';
						return;
					}
					if('message' in data) {
						$.messager.alert('提示', data.message, 'warning');
					} else {
						$.messager.alert('提示', '登陆失败', 'warning');
					}
				},
				error: function() {
					$.messager.progress('close');
					$.messager.alert('提示', '服务器处理错误', 'error');
				},
			});
		},
	};
	
	$('#loginname').textbox({
		height: 32,
		width: 230,
		prompt: '请输入账号',
	});
	
	$('#loginname').validatebox({
		required: true,
	});
	
	$('#password').textbox({
		height: 32,
		width: 230,
	});
	
	$('#password').validatebox({
		required: true,
	});
	
	$('#login').dialog({
		title: '登陆',
		buttons: [{
			text: '登陆',
			iconCls: 'icon-2012080412263',
			handler: function() {
				loginObj.login();
			},
		}],
	});
	
});