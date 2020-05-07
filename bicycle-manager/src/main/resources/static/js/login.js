var vm = new Vue({
	el: "#login",
	data: {
		showInfo: false,	//用户名登录提示
		showInfo2:false,	//手机号登录提示
		syuser: {
			loginName:'',
			password:'',
			mobilePhone:'',
			verificationCode:''
		},
		message: "",		//用户名登录提示信息
		message2:"",		//手机号登录提示信息
		disabled: false,		//用户名登录防止重复提交
		disableGetCode:false,	//防止重复获取验证码
		disabled2:false			//手机号登录防止重复提交
	},
	computed:{
		//是否可以通过验证码登录
		checkVerificationCode:function(){
			var reg = /^[0-9]{4}$/;
			var verificationCode=this.syuser.verificationCode;
			if(!verificationCode || !reg.test(verificationCode)){
				return false;
			}
			return true;
		},
		//是否可以获取验证码
		checkPhone:function(){
			var reg = /^[1]([3-9])[0-9]{9}$/;
			var mobilePhone = this.syuser.mobilePhone;
			
			if(!mobilePhone || !reg.test(mobilePhone)){
				return false;
			}
			return true;
		},
		//标记是否可以用户名密码登录
		checkLoginName: function(){
			var reg = /^\S*$/;
			var loginName = this.syuser.loginName;
			var password = this.syuser.password;
			if(!loginName || !reg.test(loginName)){
				return false;
			}
			if(!password || !reg.test(password)){
				return false;
			}
			return true;
		}
	},
	
	methods:{
		//登出
		logout:function(){
			this.$http.post("logout",this.syuser,{emulateJSON:true}).then(
				(resp) => {
					sessionStorage.removeItem("name");
					location.href="/bicycle-manager/index.html";
				},
				(resp) => {
					
				}
			);
		},
		//手机验证码登录
		loginByPhone:function(){
			if(!this.checkPhone){
				this.message2 = "请填写正确的手机号码";
				this.showInfo2 = true;
				return;
			}
			if(!this.checkVerificationCode){
				this.message2 = "请填写正确的验证码";
				this.showInfo2 = true;
				return;
			}
			this.disabled2 = true;
			this.showInfo2 = false;
			this.$http.post("loginByVerificationCode",this.syuser,{emulateJSON:true}).then(
				(resp) => {
					if(resp.body == ""){
						this.showInfo2 = true;
						this.message2 = "该手机号码未注册或验证码错误";
						this.disabled2 = false;
					}else{
						//本地存储用户登录信息
						sessionStorage.setItem("name",resp.body.name);
						location.href="/main/index.html";
					}
				},
				(resp) => {
					
				}
			);
		},
		//获取验证码
		getCode:function(){
			if(!this.checkPhone){
				this.message2 = "请填写正确的手机号码";
				this.showInfo2 = true;
				return;
			}
			this.disableGetCode = true;
			this.showInfo2 = false;
			this.$http.post("getCode",this.syuser,{emulateJSON:true}).then(
				(resp) => {
					if(resp.bodyText=="error1"){
						this.showInfo2 = true;
						this.message2 = "获取验证码失败，请刷新后重试";
						this.disableGetCode = false;
						return;
					}
					if(resp.bodyText=="error2"){
						this.showInfo2 = true;
						this.message2 = "该手机号码未注册";
						this.disableGetCode = false;
						return;
					}
					if(resp.bodyText=="ok"){
						
					}
				},
				(resp) => {
					
				}
			);
		},
		
		//用户名密码登录
		loginByPassword: function(){
			if(!this.checkLoginName){
				this.message = "请填写完整的信息";
				this.showInfo = true;
			}else{
				this.disabled = true;
				this.showInfo = false;
				this.$http.post("login",this.syuser,{emulateJSON:true}).then(
					(resp) => {
						if(resp.body == ""){
							this.showInfo = true;
							this.message = "用户名不存在或者密码错误";
							this.disabled = false;
						}else{
							//本地存储用户登录信息
							sessionStorage.setItem("name",resp.body.name);
							location.href="/main/index.html";
						}
					},
					(resp) => {
						
					}
				);
			}
		}
	}
}); 