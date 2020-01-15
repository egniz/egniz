package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "ca2";
	private static final String password = "ca2";
	
	public MemberDAO() {
	try {
		Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	private void closeAll(ResultSet rs,PreparedStatement ps, Connection con) {
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void insert(MemberDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into member2(id,name,age) values(?,?,?)";
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeAll(null, ps, con);
		}
	}
	public List<MemberDTO> select() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from member2";
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, con);
		}
		return list;
	}
}

