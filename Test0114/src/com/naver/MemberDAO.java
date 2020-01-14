package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class MemberDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "ca2";
	private static final String password = "ca2";
	
	public MemberDAO() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inster2(MemberDTO dto) {
		Connection con = null;
		Statement st = null;
		String sql = "insert into member2(id,name,age) values('"+dto.getId()+"','"+dto.getName()+"',"+dto.getAge()+")";
		
		try {
			con = DriverManager.getConnection(url,user,password);
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(st != null) {
					st.close();
				}
				if(con != null) con.close();
			} catch (Exception e2) {
			e2.printStackTrace();
			}
			
		}
	}
	
	
	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member2(id,name,age) values(?,?,?)";

		try {
			conn = DriverManager.getConnection(url, user, password);

			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

