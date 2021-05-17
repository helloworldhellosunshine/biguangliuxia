package com.bishe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.sql.MysqlUtil;

/**
 * Servlet implementation class UpdataServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");//后往前
		response.setContentType("text/html;charset=utf-8");//后往前
		
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String city = request.getParameter("city");
		String pm25 = request.getParameter("pm25");
		String pm10 = request.getParameter("pm10");
		String so2 = request.getParameter("so2");
		String co = request.getParameter("co");
		String no2 = request.getParameter("no2");
		String o3_8h = request.getParameter("o3_8h");
		String aqi = request.getParameter("aqi");
		String ycaqi = request.getParameter("ycaqi");
		String grade = request.getParameter("grade");
		
		/*String sql = "select * from beijing where id="+id;
		String[] colums = {"id","DATE","CITY","PM25","PM10","SO2","CO","NO2","O3_8h","AQI","YCAQI","GRADE","id"};
		String jsonString = MysqlUtil.getJsonBySql(sql, colums);
		
		//System.out.println(jsonString);
		response.getWriter().append(jsonString);*/
		
		String sql = "";
		if(city.equals("北京")) {	
			sql = "update beijing set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("长春")){
			sql = "update changchun set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("长沙")){
			
			sql = "update changsha set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("成都")){
			sql = "update chengdu set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("重庆")){
			sql = "update chongqing set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("福州")){
			sql = "update fuzhou set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("广州")){
			sql = "update guangzhou set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("贵阳")){
			sql = "update guiyang set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("哈尔滨")){
			sql = "update haerbin set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("杭州")){
			sql = "update hangzhou set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("合肥")){
			sql = "update hefei set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("济南")){
			sql = "update jinan set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("昆明")){
			sql = "update kunming set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("兰州")){
			sql = "update lanzhou set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("拉萨")){
			sql = "update lasa set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("南昌")){
			sql = "update nanchang set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("南京")){
			sql = "update nanjing set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("南宁")){
			sql = "update nanning set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("上海")){
			sql = "update shanghai set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("沈阳")){
			sql = "update shenyang set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("深圳")){
			sql = "update shenzhen set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("石家庄")){
			sql = "update shijiazhuang set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("太原")){
			sql = "update taiyuan set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("天津")){
			sql = "update tianjin set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("武汉")){
			sql = "update wuhan set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("乌鲁木齐")){
			sql = "update wulumuqi set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("西宁")){
			sql = "update xining set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("银川")){
			sql = "update yinchuan set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}else if (city.equals("郑州")){
			sql = "update zhengzhou set date = \""+date+"\",city=\""+city+"\",pm25=\""+pm25+"\",pm10 = \""+pm10+"\",so2=\""+so2+"\",co=\""+co+"\",no2=\""+no2+"\",o3_8h=\""+o3_8h+"\",aqi = \""+aqi+"\",ycaqi=\""+ycaqi+"\",grade=\""+grade+"\" where id = "+id;
			
		}
		int res = MysqlUtil.update(sql);
		String json = "";
		if(res==1) {
			 json = "{\"code\":"+res+",\"msg\":\"修改成功!\"}";
		}else {
			 json = "{\"code\":"+res+",\"msg\":\"修改失败!\"}";
		}
		response.getWriter().append(json);
	}

}
