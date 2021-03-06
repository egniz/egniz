package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ServletContext application =getServletContext();
//
//		
//		
//		String url = application.getInitParameter("url");
//		System.out.println(url);
//		
//		
//		String user = getInitParameter("user");
//		System.out.println(user);
//		
//		String pw =getInitParameter("password");
//		System.out.println(pw);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		
		String id =request.getParameter("id");
		String name =request.getParameter("name");
		String sAge = request.getParameter("age");
		
		int age = -1;
		if(sAge != null) {
			age = Integer.parseInt(sAge);
		}
		
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		
		response.setContentType("text/html;charset=euc-kr");
		
		ServletContext application =getServletContext();
		
		application.setAttribute("id", id);
		application.setAttribute("name", name);
		application.setAttribute("age", age);
		application.setAttribute("dto", new MemberDTO(id, name, age));
		
		response.sendRedirect("test.jsp");
	}

}
