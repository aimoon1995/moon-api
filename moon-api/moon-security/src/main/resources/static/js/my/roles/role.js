function initRoles() {
	$.ajax({
		type : 'get',
		url : '/roles/all',
		async : false,
		success : function(data) {
			var r = $("#roles");
			var currentUser = getCurrentUser();
			for (var i = 0; i < data.length; i++) {
				var d = data[i];
				var id = d['id'];
				var name = d['name'];
				if(currentUser.username=='admin'){
					var t = "<label><input type='checkbox' value='" + id + "'>"
						+ name + "</label> &nbsp&nbsp";

				}else if(name!="ADMIN"){
					var t = "<label><input type='checkbox' value='" + id + "'>"
						+ name + "</label> &nbsp&nbsp";
				}

				r.append(t);
			}
		}
	});
}

function getCurrentUser (){
	var currentUser;
	var token = localStorage.getItem("token");
	if (token != null && token.trim().length != 0) {
		$.ajax({
			type: 'get',
			async:false,
			url: '/users/current?token=' + token,
			success: function (data) {
				currentUser = data;
			},
			error: function (xhr, textStatus, errorThrown) {
				var msg = xhr.responseText;
				var response = JSON.parse(msg);
				var code = response.code;
				var message = response.message;
				if (code == 401) {
					localStorage.removeItem("token");
				}
			}
		});
		return currentUser ;
	}
}

function getCheckedRoleIds() {
	var ids = [];
	$("#roles input[type='checkbox']").each(function() {
		if ($(this).prop("checked")) {
			ids.push($(this).val());
		}
	});

	return ids;
}

function initRoleDatas(userId) {
	$.ajax({
		type : 'get',
		url : '/roles?userId=' + userId,
		success : function(data) {
			var length = data.length;
			for (var i = 0; i < length; i++) {
				$("input[type='checkbox']").each(function() {
					var v = $(this).val();
					if (v == data[i]['id']) {
						$(this).attr("checked", true);
					}
				});
			}
		}
	});
}