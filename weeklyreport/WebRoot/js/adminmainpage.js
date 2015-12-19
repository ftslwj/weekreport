$(function() {
	
	$('#openModifyPwd').click(function() {
		$('#oldpwd,#newpwd,#confirmpwd').textbox('setValue', '');
		$('#modifypwd').dialog('open');
	});
	
	$('#logout').click(function() {
		$.ajax({
			method: 'POST',
			url: 'logout.action',
			success: function(data) {
				location.href="/weeklyreport";
			},
			error: function() {
				location.href="/weeklyreport";
			},
		});
		
	});
	
	$('#oldpwd,#newpwd,#confirmpwd').validatebox({
		required: true,
		validType: 'length[6,10]',
	});
	
	$('#functions').accordion({
		fit: true,
		border: false,
	});
	
	$('#modifypwd').dialog({
		title: '修改密码',
		modal: true,
		buttons: [{
			text: '确定',
			iconCls: 'icon-ok',
			handler: function() {
				if(!$('#oldpwd').validatebox('isValid')) {
					$.messager.alert('提示', '请输入正确的原始密码', 'warning');
					return;
				}
				if(!$('#newpwd').validatebox('isValid')) {
					$.messager.alert('提示', '请输入正确的新密码', 'warning');
					return;
				}
				var oldpwd = $('#oldpwd').val();
				var newpwd = $('#newpwd').val();
				var confirmpwd = $('#confirmpwd').val();
				if(oldpwd == newpwd) {
					$.messager.alert('提示', '新密码不能和原始密码相同', 'warning');
					return;
				}
				if(newpwd != confirmpwd) {
					$.messager.alert('提示', '新密码和确认密码不同', 'warning');
					return;
				}
				$.ajax({
					method: 'POST',
					url: 'modifypwd.action',
					data: {
						oldpwd: oldpwd,
						newpwd: newpwd,
					},
					success: function(data) {
						if(typeof data == 'string') {
							data = JSON.parse(data);
						}
						if(data.retCode != 0) {
							$.messager.alert('提示', data.message, 'warning');
							return;
						}
						$.messager.alert('提示', '修改成功', 'info');
						$('#modifypwd').dialog('close');
					},
					error: function() {
						$.messager.alert('提示', '服务端处理错误', 'error');
					},
				});
			},
		}],
	});
	$('#modifypwd').dialog('close');
	
	$('#tabs').tabs({
		fit: true,
		border : false,
	});
	
	$('#functions p').click(function(e) {
		var _this = $(this);
		if($('#tabs').tabs('exists', _this.text())) {
			$('#tabs').tabs('select', _this.text());
			return;
		}
		$('#tabs').tabs('add', {
			title: _this.text(),
			closable: true,
			href: _this.attr('pageurl'),
		});
	});
});