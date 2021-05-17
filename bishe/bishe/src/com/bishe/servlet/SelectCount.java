package com.bishe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectCount
 */
@WebServlet("/SelectCount")
public class SelectCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");//后往前
		response.setContentType("text/html;charset=utf-8");//后往前
		System.out.println("------------------------------------");
		String city = request.getParameter("city");
		String sql = "";
		if(city.equals("北京")) {	
			sql = "select count(*) from beijing";
		}else if (city.equals("长春")){
			
			sql = "select count(*) from changchun";
		}else if (city.equals("长沙")){
			
			sql = "select count(*) from changsha";
		}else if (city.equals("成都")){
			
			sql = "select count(*) from chengdu";
		}else if (city.equals("重庆")){
			
			sql = "select count(*) from chongqing";
		}else if (city.equals("福州")){
			
			sql = "select count(*) from fuzhou";
		}else if (city.equals("广州")){
			
			sql = "select count(*) from guangzhou";
		}else if (city.equals("贵阳")){
			
			sql = "select count(*) from guiyang";
		}else if (city.equals("哈尔滨")){
			
			sql = "select count(*) from haerbin";
		}else if (city.equals("杭州")){
			
			sql = "select count(*) from hangzhou";
		}else if (city.equals("合肥")){
			
			sql = "select count(*) from hefei";
		}else if (city.equals("济南")){
			
			sql = "select count(*) from jinan";
		}else if (city.equals("昆明")){
			
			sql = "select count(*) from kunming";
		}else if (city.equals("兰州")){
			
			sql = "select count(*) from lanzhou";
		}else if (city.equals("拉萨")){
			
			sql = "select count(*) from lasa";
		}else if (city.equals("南昌")){
			
			sql = "select count(*) from nanchang";
		}else if (city.equals("南京")){
			
			sql = "select count(*) from nanjing";
		}else if (city.equals("南宁")){
		
			sql = "select count(*)from nanning";
		}else if (city.equals("上海")){
			
			sql = "select count(*) from shanghai";
		}else if (city.equals("沈阳")){
			
			sql = "select count(*) from shenyang";
		}else if (city.equals("深圳")){
			
			sql = "select count(*) from shenzhen";
		}else if (city.equals("石家庄")){
			
			sql = "select count(*) from shijiazhuang";
		}else if (city.equals("太原")){
			
			sql = "select count(*) from taiyuan";
		}else if (city.equals("天津")){
			
			sql = "select count(*) from tianjin";
		}else if (city.equals("武汉")){
		
			sql = "select count(*) from wuhan";
		}else if (city.equals("乌鲁木齐")){
			
			sql = "select count(*) from wulumuqi";
		}else if (city.equals("西宁")){
			
			sql = "select count(*) from xining";
		}else if (city.equals("银川")){
			
			sql = "select count(*) from yinchuan";
		}else if (city.equals("郑州")){
			
			sql = "select count(*) from zhengzhou";
		}
		System.out.println("SelectCountBycity:"+ sql);
		
		int count = com.bishe.sql.MysqlUtil.getCount(sql);
		System.out.println(count);
		 String jsonString = "{\"code\":\"200\",\"count\":"+count+"}";
		//返回数据
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
