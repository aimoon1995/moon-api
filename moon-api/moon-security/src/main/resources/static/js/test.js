function showTestSelect(id, tip, all) {
	var tips = getTest(tip);
	var select = $("#" + id);
	select.empty();

	if (all != undefined && all) {
		select.append("<option value=''>全部</option>");
	};

	return tips;
}

function getTest(tip) {
	var vt = sessionStorage[tip];
	if (vt == null || vt == "") {
		$.ajax({
			type : 'get',
			url : '/tests?tip=' + tip,
			async : false,
			success : function(tips) {
				vt = {};
				$.each(tips);

				sessionStorage[tip] = JSON.stringify(vt);
			}
		});
	}

	return JSON.parse(sessionStorage[tip]);
}
