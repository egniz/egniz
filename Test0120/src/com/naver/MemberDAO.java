package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<MemberDTO> list() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from member2";
		ResultSet rs = null;
		try {
			con = dataFactory.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);

				list.add(new MemberDTO(id, name, age));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, con);

		}
		return list;
	}



	public MemberDTO login(String id, int age) {
		MemberDTO dto = null;
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "select * from member2 where id=? and age=? ";
		ResultSet rs = null;
		try {
			con = dataFactory.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, age);
			rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString(2);
				dto = new MemberDTO(id, name, age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, con);
		}
		return dto;
	}
}
