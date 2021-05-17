package com.bishe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.sql.MysqlUtil;

/**
 * Servlet implementation class FutureServlet
 */
@WebServlet("/FutureServlet")
public class FutureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FutureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");//后往前
		response.setContentType("text/html;charset=utf-8");//后往前
		
		String city = request.getParameter("city");
		String datestart = request.getParameter("datestart");
		String dateend = request.getParameter("dateend");
		
		System.out.println("查询的城市："+city+"; 查询的开始日期为："+datestart+";查询的结束日期为："+dateend);
		
		String sql = "";
		if(city.equals("北京")) {	
			sql = "select * from beijing where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("长春")){
			sql = "select * from changchun where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("长沙")){
			sql = "select * from changsha where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("成都")){
			sql = "select * from chengdu where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("重庆")){
			sql = "select * from chongqing where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("福州")){
			sql = "select * from fuzhou where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("广州")){
			sql = "select * from guangzhou where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("贵阳")){
			sql = "select * from guiyang where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("哈尔滨")){
			sql = "select * from haerbin where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("杭州")){
			sql = "select * from hangzhou where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("合肥")){
			sql = "select * from hefei where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("济南")){
			sql = "select * from jinan where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("昆明")){
			sql = "select * from kunming where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("兰州")){
			sql = "select * from lanzhou where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("拉萨")){
			sql = "select * from lasa where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("南昌")){
			sql = "select * from nanchang where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("南京")){
			sql = "select * from nanjing where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("南宁")){
			sql = "select * from nanning where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("上海")){
			sql = "select * from shanghai where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("沈阳")){
			sql = "select * from shenyang where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("深圳")){
			sql = "select * from shenzhen where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("石家庄")){
			sql = "select * from shijiazhuang where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("太原")){
			sql = "select * from taiyuan where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("天津")){
			sql = "select * from tianjin where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("武汉")){
			sql = "select * from wuhan where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("乌鲁木齐")){
			sql = "select * from wulumuqi where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("西宁")){
			sql = "select * from xining where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("银川")){
			sql = "select * from yinchuan where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}else if (city.equals("郑州")){
			sql = "select * from zhengzhou where DATE >= '"+datestart+"' and DATE <= '"+dateend+"'";
		}
		
		//String sql = "select * from shenyang where DATE= '2020-04-01';";
		System.out.println(sql);
		String[] colums = {"DATE","CITY","PM25","PM10","SO2","CO","NO2","O3_8h","AQI","YCAQI","GRADE"};
		String jsonString = MysqlUtil.getJsonBySql(sql, colums);
		
		//System.out.println(jsonString);
		response.getWriter().append(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
