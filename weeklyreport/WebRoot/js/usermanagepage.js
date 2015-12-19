$(function(){
	$('#usertable').datagrid({
		rownumbers: true,
		fit: true,
		url: 'getusers.action',
		striped: true,
		pagination: true,
		pageSize: 3,
		pageList:[3, 6, 9],
		columns:[[
		          {
		        	  field: 'id',
		        	  title: '用户id',
		        	  checkbox: true,
		          },
		          {
		        	  field: 'loginName',
		        	  title: '登录名',
		          },
		          {
		        	  field: 'userName',
		        	  title: '姓名',
		          }
		          ]],
	});
	$('#usertable').datagrid('getPager').pagination({
		showPageList: false
	});
});