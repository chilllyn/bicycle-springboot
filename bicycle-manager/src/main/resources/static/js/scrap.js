//# sourceURL=js/scrap.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
	el: "#scrap",
	data: {
		pageInfo:{},	//车辆分页
		list: [],		//车辆列表
		queryCondition: {}, // 保存查询条件
		repairRecord:{
			bicycleId:null,
			bicycleCode:null,
			recordId:null
		},				//维修明细对象
		status:1,	//调出调入完成提示 1不显示 2成功 3失败
		tips:""	,	//操作完成提示
		
	},
	
	methods:{
		//提交报废请求
		scrap:function(){
			console.log(this.repairRecord);
			this.$http.post("scrap/scrap",this.repairRecord,{emulateJSON: true}).then(
				(resp) => {
					var flag = resp.bodyText;
					//关闭窗口
					$("#confirmModal").modal('hide');
					if(flag=="success"){
						//刷新当前页
						this.goPage(this.pageInfo.pageNum);
						this.status = 2;
						this.tips="报废登记成功！";
					}else{
						this.status = 3;
						this.tips=flag;
					}
					setTimeout('vm.status = 1',3000);
				},
				(resp) => {
					
				}
			);
		},
		//弹出确认窗口,传入车辆id，车辆编号
		confirm:function(bicycleId,bicycleCode,recordId){
			this.repairRecord.bicycleId=bicycleId;
			this.repairRecord.bicycleCode=bicycleCode;
			this.repairRecord.recordId=recordId;
		},
		//主页面查询
		goPage: function(pageNum){
			// 查询条件中携带要查询的页码
			this.queryCondition.pageNum = pageNum;
			var params={
				params:this.queryCondition
			}
//			console.log(params);
			this.$http.get("scrap/listScrapBicycle",params).then(
				(resp) => {
					this.pageInfo = resp.body;
					this.list = resp.body.list;
					console.log(this.list);
				},
				(resp) => {
					
				}
			);
		}
	}
});
	
vm.goPage(1); // 显示第1页数据

