package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String sAge = request.getParameter("age");
		int age = -1;
		if(sAge != null) {
			age = Integer.parseInt(sAge);
		}
		
		dao.login(id,age);
		
		
		return new CommandAction(true, "list.do");
	}

}
