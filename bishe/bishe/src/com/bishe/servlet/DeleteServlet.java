package com.bishe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.sql.MysqlUtil;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		response.setCharacterEncoding("utf-8");		
		response.setContentType("application/json;charset=utf-8");//设置类型，设置字符集
						
		
		String id = request.getParameter("id");
		String city = request.getParameter("city");
		System.out.println("删除的id："+id+"删除的city:"+city);
		
		
		String sql = "";
		if(city.equals("北京")) {	
			
			sql = "delete from beijing where id = "+id;
		}else if (city.equals("长春")){
			
			sql = "delete from changchun where id = "+id;
		}else if (city.equals("长沙")){
			
			sql = "delete from changsha where id = "+id;
		}else if (city.equals("成都")){
			
			sql = "delete from chengdu where id = "+id;
		}else if (city.equals("重庆")){
			
			sql = "delete from chongqing where id = "+id;
		}else if (city.equals("福州")){
			
			sql = "delete from fuzhou where id = "+id;
		}else if (city.equals("广州")){
			
			sql = "delete from guangzhou where id = "+id;
		}else if (city.equals("贵阳")){
			
			sql = "delete from guiyang where id = "+id;
		}else if (city.equals("哈尔滨")){
			
			sql = "delete from haerbin where id = "+id;
		}else if (city.equals("杭州")){
			
			sql = "delete from hangzhou where id = "+id;
		}else if (city.equals("合肥")){
			
			sql = "delete from hefei where id = "+id;
		}else if (city.equals("济南")){
			
			sql = "delete from jinan where id = "+id;
		}else if (city.equals("昆明")){
			
			sql = "delete from kunming where id = "+id;
		}else if (city.equals("兰州")){
			
			sql = "delete from lanzhou where id = "+id;
		}else if (city.equals("拉萨")){
			
			sql = "delete from lasa where id = "+id;
		}else if (city.equals("南昌")){
			
			sql = "delete from nanchang where id = "+id;
		}else if (city.equals("南京")){
			
			sql = "delete from nanjing where id = "+id;
		}else if (city.equals("南宁")){
		
			sql = "delete from nanning where id = "+id;
		}else if (city.equals("上海")){
			
			sql = "delete from shanghai where id = "+id;
		}else if (city.equals("沈阳")){
			
			sql = "delete from shenyang where id = "+id;
		}else if (city.equals("深圳")){
			
			sql = "delete from shenzhen where id = "+id;
		}else if (city.equals("石家庄")){
			
			sql = "delete from shijiazhuang where id = "+id;
		}else if (city.equals("太原")){
			
			sql = "delete from taiyuan where id = "+id;
		}else if (city.equals("天津")){
			
			sql = "delete from tianjin where id = "+id;
		}else if (city.equals("武汉")){
		
			sql = "delete from wuhan where id = "+id;
		}else if (city.equals("乌鲁木齐")){
			
			sql = "delete from wulumuqi where id = "+id;
		}else if (city.equals("西宁")){
			
			sql = "delete from xining where id = "+id;
		}else if (city.equals("银川")){
			
			sql = "delete from yinchuan where id = "+id;
		}else if (city.equals("郑州")){
			
			sql = "delete from zhengzhou where id = "+id;
		}
		
		
		MysqlUtil.del(sql);
		String jsonString = "{\"code\":200,\"message\":\"删除成功！\"}";
		//System.out.println(jsonString);
		response.getWriter().append(jsonString);
	}

}
