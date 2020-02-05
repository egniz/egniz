package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		
		
		MemberDAO dto = new MemberDAO();
		dto.update(new MemberDTO(id, null, name, birthday, 0));
		
		return new CommandAction(true, "read.do?id=" + id);
		
	}

}
