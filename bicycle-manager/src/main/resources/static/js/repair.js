//@ sourceURL=js/repair.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
	el: "#repair",
	data: {
		pageInfo:{},	//车辆分页
		list: [],		//车辆列表
		queryCondition: {}, // 保存查询条件
		repairPartValid:true,	//修理部位验证
		feeValid:true,			//修理费用验证
		repairRecord:{
			bicyleId:0,
			bicycleCode:null,
			repairType:1,
			repairPart:null,
			repairResult:1,
			fee:null,
			remark:null
		},				//维修记录对象
		status:1,	//调出调入完成提示 1不显示 2成功 3失败
		tips:""	,	//操作完成提示
		
	},
	
	methods:{
		//保存修理记录
		save:function(){
			this.checkValid();
			if(!this.repairPartValid||!this.feeValid){
				return;
			}
			this.$http.post("repair/repairRecord",this.repairRecord,{emulateJSON: true}).then(
				(resp) => {
					var flag = resp.bodyText;
					//关闭窗口
					$("#inputModal").modal('hide');
					if(flag=="success"){
						//刷新当前页
						this.goPage(this.pageInfo.pageNum);
						this.status = 2;
						this.tips="维修登记成功！";
					}else{
						this.status = 3;
						this.tips=flag;
					}
					setTimeout('vm.status = 1',3000);
					this.cleanInputRecord();
				},
				(resp) => {

				}
			);
			
		},
		//判断修理部位和修理费用是输入是否合法
		checkValid:function(){
			if(/^[\u4e00-\u9fa5]+(\u3001[\u4e00-\u9fa5]+)*$/.test(this.repairRecord.repairPart)){
				this.repairPartValid=true;
			}else{
				this.repairPartValid=false;
			}
			if(Number(this.repairRecord.fee)>0&&Number(this.repairRecord.fee)<10000){
				this.feeValid=true;
			}else{
				this.feeValid=false;
			}
		},
		//关闭输入窗口时，清空其中内容和提示
		cleanInputRecord:function(){
			this.repairRecord={
				bicyleId:0,
				bicycleCode:null,
				repairType:1,
				repairPart:null,
				repairResult:1,
				fee:null,
				remark:null
			};
			this.repairPartValid=true;
			this.feeValid=true;
		},
		//弹出维修登记窗口,传入车辆id，车辆编号
		inputRecord:function(bicycleId,bicycleCode){
			this.repairRecord.bicycleId=bicycleId;
			this.repairRecord.bicycleCode=bicycleCode;
		},
		//主页面查询
		goPage: function(pageNum){
			// 查询条件中携带要查询的页码
			this.queryCondition.pageNum = pageNum;
			var params={
				params:this.queryCondition
			}
//			console.log(params);
			this.$http.get("repair/listBicycle",params).then(
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

