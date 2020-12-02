//form序列化为json
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

//获取url后的参数值
function getUrlParam(key) {
	var href = window.location.href;
	var url = href.split("?");
	if(url.length <= 1){
		return "";
	}
	var params = url[1].split("&");
	
	for(var i=0; i<params.length; i++){
		var param = params[i].split("=");
		if(key == param[0]){
			return param[1];
		}
	}
}



//判断查询日期起始结束范围不能超过一个月
function checkDatelimit(startDate,endDate) {
var startTime =  new Date(startDate);
    var endTime =  new Date(endDate);
    var maxDateds = new Date(startTime.setMonth(startTime.getMonth() + 1));
    var yearMax = maxDateds.getFullYear();
    var monMax = maxDateds.getMonth() + 1;
    var dayMax = maxDateds.getDate();
    var sMax = yearMax + "-" + (monMax < 10 ? ('0' + monMax) : monMax) + "-" + (dayMax < 10 ? ('0' + dayMax) : dayMax);

    if((Date.parse(endTime)-Date.parse(sMax))>=0){
        return false;
    }
    return true;
}


// 设置最大可选的日期
function maxDate() {
    var now = new Date();
    return now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + (now.getDate()-1);
}
