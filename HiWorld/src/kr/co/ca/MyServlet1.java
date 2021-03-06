package kr.co.ca;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		name = toKor(name);
		value = toKor(value);
		response.setContentType("text/html; charset=EUC-KR");
		
		PrintWriter out =response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(name);
		out.print(value);
		out.print("</body>");
		out.print("</html>");
	}

	private String toKor(String name) {
		// TODO Auto-generated method stub
		try {
			return new String(name.getBytes("8859_1"),"euc-kr");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
