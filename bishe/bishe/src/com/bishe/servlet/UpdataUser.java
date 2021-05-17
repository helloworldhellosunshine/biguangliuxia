package com.bishe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.sql.MysqlUtil;



/**
 * Servlet implementation class UpdataUser
 */
@WebServlet("/UpdataUser")
public class UpdataUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		String account = request.getParameter("account");
		String name = request.getParameter("name");
		String passwordString  = request.getParameter("password");
		System.out.println(idString + "**" + account + "******" + name + "****" + passwordString);
		String sqlString = "";
		String updateString = "update user  set account = '"+account+"', name = '"+name+"' , password = '"+passwordString+"' where id= '"+idString+"'";
		int count= MysqlUtil.update(updateString);
		if(count == 1) {
			sqlString="{\"code\":200,\"message\":\"修改成功\"}";
		}else {
			sqlString="{\"code\":200,\"message\":\"修改失败\"}";
		}
	
		 response.getWriter().append(sqlString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
