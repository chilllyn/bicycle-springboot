/**
 * 判断一个对象是否为空
 * @param obj
 * @returns
 */
function isEmpty(obj){
	for(var i in obj){
		return false;
	}
	return true;
}