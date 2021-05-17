package com.bishe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.sql.MysqlUtil;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
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
		int page= Integer.parseInt(request.getParameter("page"))-1;
		int limit= Integer.parseInt(request.getParameter("limit"));
		//System.out.println("查询的城市："+city+";);
		
		String sql = "";
		if(city.equals("北京")) {	
			
			sql = "select * from beijing";
		}else if (city.equals("长春")){
			
			sql = "select * from changchun";
		}else if (city.equals("长沙")){
			
			sql = "select * from changsha";
		}else if (city.equals("成都")){
			
			sql = "select * from chengdu";
		}else if (city.equals("重庆")){
			
			sql = "select * from chongqing";
		}else if (city.equals("福州")){
			
			sql = "select * from fuzhou";
		}else if (city.equals("广州")){
			
			sql = "select * from guangzhou";
		}else if (city.equals("贵阳")){
			
			sql = "select * from guiyang";
		}else if (city.equals("哈尔滨")){
			
			sql = "select * from haerbin";
		}else if (city.equals("杭州")){
			
			sql = "select * from hangzhou";
		}else if (city.equals("合肥")){
			
			sql = "select * from hefei";
		}else if (city.equals("济南")){
			
			sql = "select * from jinan";
		}else if (city.equals("昆明")){
			
			sql = "select * from kunming";
		}else if (city.equals("兰州")){
			
			sql = "select * from lanzhou";
		}else if (city.equals("拉萨")){
			
			sql = "select * from lasa";
		}else if (city.equals("南昌")){
			
			sql = "select * from nanchang";
		}else if (city.equals("南京")){
			
			sql = "select * from nanjing";
		}else if (city.equals("南宁")){
		
			sql = "select * from nanning";
		}else if (city.equals("上海")){
			
			sql = "select * from shanghai";
		}else if (city.equals("沈阳")){
			
			sql = "select * from shenyang";
		}else if (city.equals("深圳")){
			
			sql = "select * from shenzhen";
		}else if (city.equals("石家庄")){
			
			sql = "select * from shijiazhuang";
		}else if (city.equals("太原")){
			
			sql = "select * from taiyuan";
		}else if (city.equals("天津")){
			
			sql = "select * from tianjin";
		}else if (city.equals("武汉")){
		
			sql = "select * from wuhan";
		}else if (city.equals("乌鲁木齐")){
			
			sql = "select * from wulumuqi";
		}else if (city.equals("西宁")){
			
			sql = "select * from xining";
		}else if (city.equals("银川")){
			
			sql = "select * from yinchuan";
		}else if (city.equals("郑州")){
			
			sql = "select * from zhengzhou";
		}
		
		sql = sql+ " ORDER BY DATE DESC";
		
		if(limit!=0) {
			if(page!=0) {
				sql += " limit "+limit*page+","+limit;
			}else{
				sql += " limit 0,"+limit;
			}
		};
		
		System.out.println(sql);
		String[] colums = {"DATE","CITY","PM25","PM10","SO2","CO","NO2","O3_8h","AQI","YCAQI","GRADE","id"};
		String jsonString = MysqlUtil.getLayuiBySql(sql, colums);
		
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
