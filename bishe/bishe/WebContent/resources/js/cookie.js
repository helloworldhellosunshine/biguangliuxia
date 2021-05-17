// cookie信息存入
//cname:key
//cvalue:value
//exdays:存储的天数
function setCookie(cname,cvalue,exdays){
    var d = new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires = "expires="+d.toGMTString();
    document.cookie = cname+"="+cvalue+"; "+expires;
}
// cookie信息取出
function getCookie(cname){
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) { return c.substring(name.length,c.length); }
    }
    return "";
}
//检测 cookie 值的函数
function checkCookie(){
    var user=getCookie("account");
    if (user!=""){
    	//跳转页面
    	window.location.href = "/fengyeServlet/insert.html";
        //alert("欢迎 " + user + " 再次访问");
        
    }
}