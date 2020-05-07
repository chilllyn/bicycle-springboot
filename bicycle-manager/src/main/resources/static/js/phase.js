//@ sourceURL=js/phase.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#phase",
		data: {
			pageInfo:{},
			list: [],
			isUpdate: false, // 标记是否是修改操作
			msPhase: {}, // 保存新增和修改的数据对象
			queryCondition: {}, // 保存查询条件
			type: 1, //1不显示 2成功 3失败
			valid: [true,true],//记录表单数据校验结果 默认都是通过的
			flag: true //标记是否可以提交数据 默认可以
		},
		
		methods:{
			goPage: function(pageNum){
				// 查询条件中携带要查询的页码
				this.queryCondition.pageNum = pageNum;
				var params = {
						params:this.queryCondition
				}
				this.$http.get("msphase/select",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			// 点击新增权限按钮
			addDiv: function(){
				this.isUpdate = false;
				this.msPhase = {};//清空表单数据
				this.valid = [true,true];
				this.flag = true;
			},
			// 点击保存按钮操作
			save: function(){
				// 数据校验
				var urlOk = /^\/[a-zA-Z]{1,199}$/.test(this.msPhase.url);
				var descOk = /^[\u4e00-\u9fa5]{2,50}$/.test(this.msPhase.description);
				
				if(urlOk && descOk){
					this.flag = true;
				}else{
					this.flag = false;
				}
				this.valid = [urlOk,descOk];
				
				
				
				
				
				if(this.flag){// 可以提交
					if(this.isUpdate){
						url = "msphase/update";
					}else{
						url = "msphase/insert";
					}
				
					this.$http.post(url,this.msPhase,{emulateJSON: true}).then(
							(resp) => {
								var r = resp.bodyText;
								//关闭窗口
								$("#optDiv").modal('hide');
								if(r == "success"){
									//刷新当前 页
									if(this.isUpdate){
										this.goPage(this.pageInfo.pageNum);
									}
									this.type = 2;
								}else{
									this.type = 3;
								}
								setTimeout('vm.type = 1',3000);
								this.msPhase = {};
							},
							(resp) => {
								
							}
					);
					
				}
				
				
				
			}
		}
	});
	
	vm.goPage(1); // 显示第1页数据