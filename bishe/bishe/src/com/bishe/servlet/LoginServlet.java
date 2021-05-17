package com.bishe.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.sql.MysqlUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String type = request.getParameter("type");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println(account+" "+password+" "+type);
		
		String sql = "";
		if(type.equals("用户")) {
			System.out.println("进来啦");
			sql = "select * from user where account=\""+account+"\" and password=\""+password+"\"";
			String[] colums = {"id","name","account","password"};
			ArrayList<String[]> res = MysqlUtil.showUtil(sql, colums);//res是一个数组（线性的列表）
			String json = "";
			if(res.size()>=1) {
				json = "{\"code\":"+res.size()+",\"msg\":\"登录成功!\"}";
			}else {
				json = "{\"code\":"+res.size()+",\"msg\":\"登录失败!\"}";
			}
			response.getWriter().write(json);
		}else if(type.equals("管理员")) {
			//sql = "select * from manager where account='\"+account+\"' and password='\"+password+\"'";
			sql = "select * from manager where account = \""+account+"\" and password= \""+password+"\"";
			String[] colums = {"id","name","account","password"};
			ArrayList<String[]> res = MysqlUtil.showUtil(sql, colums);//res是一个数组（线性的列表）
			String json = "";
			if(res.size()>=1) {
				json = "{\"code\":"+res.size()+",\"msg\":\"登录成功!\"}";
			}else {
				json = "{\"code\":"+res.size()+",\"msg\":\"登录失败!\"}";
			}
			response.getWriter().write(json);
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
