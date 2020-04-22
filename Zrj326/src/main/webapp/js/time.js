// JavaScript Document
	   function showTime(){
	       var t=document.getElementById("topleft");
	       var date=new Date();
	       var year=date.getFullYear();
	       var m = date.getMonth()+1;
	       var month=setT(m);
	       var d = date.getDate();
	       var day=setT(d);
	       var h = date.getHours();
	       var hour=setT(h);
	       var mi = date.getMinutes();
	       var minutes=setT(mi);
	       var s = date.getSeconds();
	       var second=setT(s);
	       var week=date.getDay();
	       var mycars=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
		   var time = year+"年"+month+"月"+day+"日 "+mycars[week]+" "+hour+":"+minutes+":"+second;
		   t.innerHTML = time;
		   setTimeout("showTime()",1000);
	   }
	   function setT(t){
	   		if(t>=0 && t<=9){
	   			t = "0" + t ;
	   		}
	   		return t;
	   }
	   
	   
	function rechar(){
   					var amount =document.getElementsByName("amount")[0].value;
   					if(isNaN(amount)){
   						alert("充值金额请输入数字格式!");
   						return false;
   					}
   					if(amount<0){
   						alert("充值金额不能为负值!");
   						return false;
   					}
   					if(amount==""){
   						alert("请输入充值金额!");
   						return false;
   					}
   					if(amount>0){
   						alert("充值成功！");
   					}
   }