function load(url){
	$("#page-wrapper").load(url);// 将url请求后响应的代码 放在#page-wrapper层中
}

$.ajaxSetup ({ 
    cache: false //关闭AJAX相应的缓存 
});