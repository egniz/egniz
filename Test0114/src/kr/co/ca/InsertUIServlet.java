package kr.co.ca;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

/**
 * Servlet implementation class InsertUIServlet
 */
@WebServlet("/Insert")
public class InsertUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx =getServletContext();
		String driver = ctx.getInitParameter("driver");
		System.out.println(driver);
		
		
		
		String user = getInitParameter("user");
		System.out.println(user);
		String pw = getInitParameter("password");
		System.out.println(pw);
		
		RequestDispatcher dis =request.getRequestDispatcher("insert.html");
		dis.forward(request, response);
		
		PrintWriter out =response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<form action='insert'>");
		
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setCharacterEncoding("euc-kr");
//		
//		String id =request.getParameter("id");
//		String name =request.getParameter("name");
//		String sAge = request.getParameter("age");
//		
//		int age = -1;
//		if(sAge != null) {
//			age = Integer.parseInt(sAge);
//		}
//		
//		MemberDAO dao = new MemberDAO();
//		dao.insert(new MemberDTO(id, name, age));
//		
//		response.setContentType("text/html;charset=euc-kr");
//		PrintWriter out =response.getWriter();
//		
//		out.print("<html>");
//		out.print("<body>");
//		out.print(id);
//		out.print("<br>");
//		out.print(name);
//		out.print("<br>");
//		out.print(age);
//		out.print("<br>");
//		out.print("</form>");
//		out.print("</body>");
//		out.print("</html>");
		
	}

}
