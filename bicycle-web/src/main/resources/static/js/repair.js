//@sourceURL=js/repair.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
	el: "#repair",
	data: {
		pageInfo:{},	//车点分页
		pilePageInfo:{},	//车桩分页
		bicyclePageInfo:{},	//车辆分页	
		list: [],		//车点列表
		pileList: [],	//车桩列表
		bicycleList:[],	//车辆列表
		queryCondition: {}, // 保存查询条件
		pileQueryCondition: {}, // 保存查询条件
		bicycleQueryCondition:{},	// 保存查询条件
		stationId:0,	//选中的车点id
		bicycleDeploy:{},	//调配明细对象
		card:{},	//卡对象
		cardAvailable:true,	//输入的卡号是否可用
		isTo:false,	//是否为调入操作
		status:1,	//调出调入完成提示 1不显示 2成功 3失败
		tips:""	,	//操作完成提示
		
		CARD_TYPE_DEPLOY:5					//维修调度卡
	},
	
	methods:{
		//调出调入操作：验证卡号，判断调出调入
		fromTo:function(){
			this.$http.post("card/getCardByCardCode",this.card,{emulateJSON: true}).then(
				(resp) => {
					this.card=resp.body;
					if(this.card==null||this.card.cardType!=this.CARD_TYPE_DEPLOY){
						this.cardAvailable=false;
						this.card={};
						return;
					}
					if(!this.isTo){
						this.from();
					}else{
						this.to();
					}
						
				},
				(resp) => {
					
				}
			);
		},
		//选择车辆确认调入
		confirm:function(bicycleId){
			this.bicycleDeploy.bicycleId=bicycleId;
			this.bicycleDeploy.toCardId=this.card.cardId;
			this.$http.post("repair/to",this.bicycleDeploy,{emulateJSON: true}).then(
				(resp) => {
					var flag = resp.bodyText;
					//关闭窗口
					$("#bicycleModal").modal('hide');
					if(flag=="success"){
						//刷新当前页
						this.listPile(this.stationId,this.pilePageInfo.pageNum);
						this.status = 2;
						this.tips="车辆调入成功！";
					}else{
						this.status = 3;
						this.tips=flag;
					}
					setTimeout('vm.status = 1',3000);
					this.cleanCardCode();
				},
				(resp) => {
					
				}
			);
		},
		//调入
		to:function(){
			$("#cardModal").modal('hide');
			$("#bicycleModal").modal('show');
			this.listBicycle(1);
		},
		//调出
		from:function(){
			this.bicycleDeploy.fromCardId=this.card.cardId;
			this.$http.post("repair/from",this.bicycleDeploy,{emulateJSON: true}).then(
				(resp) => {
					var flag = resp.bodyText;
					//关闭窗口
					$("#cardModal").modal('hide');
					if(flag=="success"){
						//刷新当前页
						this.listPile(this.stationId,this.pilePageInfo.pageNum);
						this.status = 2;
						this.tips="车辆调出成功！";
					}else{
						this.status = 3;
						this.tips=flag;
					}
					setTimeout('vm.status = 1',3000);
					this.cleanCardCode();
				},
				(resp) => {
					
				}
			);
		},
		//关闭输入卡号窗口时，清空其中内容和提示
		cleanCardCode:function(){
			this.card={};
			this.cardAvailable=true;
		},
		//车辆调入车桩id
		bicycleDeployTo:function(pileId){
			this.cleanCardCode();
			this.bicycleDeploy.toPileId=pileId;
			this.isTo=true;
		},
		//车辆调出车桩id，车辆id
		bicycleDeployFrom:function(pileId,bicycleId){
			this.cleanCardCode();
			this.bicycleDeploy.fromPileId=pileId;
			this.bicycleDeploy.bicycleId=bicycleId;
			this.isTo=false;
		},
		//车桩列表
		listPile:function(stationId,pageNum){
			this.stationId=stationId;
			this.pileQueryCondition.pageNum = pageNum;
			this.pileQueryCondition.stationId = stationId;
			var params = {
				params:this.pileQueryCondition
			}
			this.$http.get("repair/listPile",params).then(
				(resp) => {
					this.pilePageInfo = resp.body;
					this.pileList = resp.body.list;
				},
				(resp) => {
					
				}
			);
		},
		//车辆列表
		listBicycle:function(pageNum){
			// 查询条件中携带要查询的页码
			this.bicycleQueryCondition.pageNum = pageNum;
			var params={
				params:this.bicycleQueryCondition
			}
//			console.log(params);
			this.$http.get("repair/listBicycle",params).then(
				(resp) => {
					this.bicyclePageInfo = resp.body;
					this.bicycleList = resp.body.list;
					//console.log(this.pageInfo);
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
			this.$http.get("repair/listStation",params).then(
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

