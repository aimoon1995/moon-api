//获取域名端口
function getDomain() {

	var pro = window.location.protocol;
	var host = window.location.host;
	var domain = pro + "//" + host;
	
	return domain;
}

function upLoadPic(){
	//上传图片
	layui.use('upload', function(){
		var upload = layui.upload;
		upload.render({
		    elem: '#test1' //绑定元素
		    ,accept: 'file' //允许上传的文件类型
		    ,url: '/pic' //上传接口
		    ,done: function(res, index, upload){
		    	layer.msg("上传成功", {shift: -1, time: 1000}, function(){
		    		 //显示图片
					var src = getDomain() + "/statics" + res.url;
					u = "<img width='70' height='70' src='" + src + "'></img>";
					$("#veiwImg").attr("href",src);
					$("#veiwImg").html(u);
               });
		    }
		  });
	});
}