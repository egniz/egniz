package kr.co.ca;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet3
 */
@WebServlet("/MyServlet3")
public class MyServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] hb = request.getParameterValues("hb");
//		hb = toKor(hb);
		response.setContentType("text/html; charset=EUC-KR");
		
		PrintWriter out =response.getWriter();
		out.print("<html>");
		out.print("<body>");
		for (int i = 0; i < hb.length; i++) {
			out.print(hb[i]=toKor(hb[i])+ "<br>");
		}
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
