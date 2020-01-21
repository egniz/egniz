package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeAll(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
