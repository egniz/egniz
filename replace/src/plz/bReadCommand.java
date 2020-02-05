package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO dto = new BoardDAO().read(num);
		
		request.setAttribute("dto", dto);
		return new CommandAction(false, "read.jsp");
	}

}
