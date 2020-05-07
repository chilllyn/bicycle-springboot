//@ sourceURL=js/utilizationRate.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
	el: "#utilizationRate",
	data: {
		pageInfo:{},	//车点分页
		list: [],		//车点列表
		queryCondition: {}, // 保存查询条件
		utilizationRate:{
			stationId:null,
			stationCode:null,
			stationName:null,
			bicyclePileNum:null,
			avgBorrow:null,
			avgReturn:null,
			avgFrom:null,
			avgTo:null,
			avgRepairFrom:null,
			avgRepairTo:null
		}	//	使用率数据对象
	},
	
	methods:{
		//数据详情
		detail:function(stationId,stationCode,stationName,bicyclePileNum){
			this.utilizationRate.stationId=stationId;
			this.utilizationRate.stationCode=stationCode;
			this.utilizationRate.stationName=stationName;
			this.utilizationRate.bicyclePileNum=bicyclePileNum;
//			console.log(this.utilizationRate);
			var params={
				params:this.utilizationRate
			};
			this.$http.get("utilizationRate/detail",params).then(
				(resp) => {
					this.utilizationRate = resp.body;
				},
				(resp) => {
					
				}
			);
			
		},
		//车点列表
		goPage: function(pageNum){
			// 查询条件中携带要查询的页码
			this.queryCondition.pageNum = pageNum;
			var params={
				params:this.queryCondition
			}
//			console.log(params);
			this.$http.get("utilizationRate/listStation",params).then(
				(resp) => {
					this.pageInfo = resp.body;
					this.list = resp.body.list;
					//console.log(this.pageInfo);
				},
				(resp) => {
					
				}
			);
		}
	}
});
	
vm.goPage(1); // 显示第1页数据

