package com.bishe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.sql.MysqlUtil;



/**
 * Servlet implementation class SelectAllUser
 */
@WebServlet("/SelectAllUser")
public class SelectAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setCharacterEncoding("utf-8");
	     response.setContentType("application/json; charset=utf-8");
	    String pageIndexString = request.getParameter("page");
	    String pageSizeString = request.getParameter("limit");
	    
	    int  pageindex = Integer.parseInt(pageIndexString);
	    int pageSize = Integer.parseInt(pageSizeString);
		String  selectString = "select * from user ";
	    System.out.println("pageSize:" + pageSize + "  "+ "pageindex:"+pageindex);
	    if (pageSize !=0) {
			if (pageindex != 1) {
				selectString += " limit " + pageSize + " offset " + (pageindex -1) * pageSize;
			}else {
				selectString += " limit " + pageSize + " offset " + 0;
			}
		}
		String[] colums = {"id","account","name","password"};
		String jsonString = MysqlUtil.getLayuiBySql(selectString, colums);
		System.out.println(jsonString);
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
