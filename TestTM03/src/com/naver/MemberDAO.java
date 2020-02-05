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
			
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
		
		} catch (NamingException e) {

			e.printStackTrace();
		
		}
	
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
		try {
			
			if(rs != null) {
				
				rs.close();
			}
			
			if(pstmt != null) {
				
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	}
	
	public List<MemberDTO> list(){
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "select * from member";
		
		ResultSet rs = null;
		
		try {
			
			 conn = dataFactory.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 
				 String id = rs.getString("id");
				 String pw = rs.getString("pw");
				 String name = rs.getString("name");
				 String birthday = rs.getString("birthday");
				 int nkey = rs.getInt("nkey");
				 
				 list.add(new MemberDTO(id, pw, name, birthday, nkey));
				 
			 }
			 		
		} catch (Exception e) {

			e.printStackTrace();
		
		}finally {
			
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	public MemberDTO login(String id, String pw) {
		MemberDTO login = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select name from member where id=? and pw=?";
		ResultSet rs = null;
		
		try {
			
			 conn = dataFactory.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, id);
			 pstmt.setString(2, pw);
			 
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 
				 String name =  rs.getString("name");
				 login = new MemberDTO(id, pw, name, null, 0);
				 
			 }
			
		} catch (Exception e) {
		    
			e.printStackTrace();
		
		}finally {
		
			closeAll(rs, pstmt, conn);
		
		}
		
		return login;
	}

	public MemberDTO read(String id) {
		
		MemberDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "select * from member where id = ?";
		ResultSet rs = null;
		
		
		try {
			
			conn = dataFactory.getConnection();	
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
		
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 
				 String pw = rs.getString("pw");
				 String name = rs.getString("name");
				 String birthday = rs.getString("birthday");
				 int nkey = rs.getInt("nkey");
							 
				 dto = new MemberDTO(id, pw , name, birthday, nkey);
				 
			 }
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {
			
				closeAll(null, pstmt, conn);
				
		}
		
		return dto;
	}

	public MemberDTO updateui(String id) {
		
		MemberDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "select * from member where id = ?";
		ResultSet rs = null;
		
		
		try {
			
			conn = dataFactory.getConnection();	
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
		
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 

				 String name = rs.getString("name");
				 String birthday = rs.getString("birthday");
	
							 
				 dto = new MemberDTO(id, null , name, birthday, 0);
				 
			 }
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {
			
				closeAll(null, pstmt, conn);
				
		}
		
		return dto;
	}
	
	public void update(MemberDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update member set name=?, birthday=? where id =?";
		
		try {
			
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirthday());
			pstmt.setString(3, dto.getId());

		
			pstmt.executeUpdate();
			 
	
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {
			
				closeAll(null, pstmt, conn);
				
		}
				
	}

	public void delete(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where id =?";
		
		try {
			
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			 
	
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {
			
				closeAll(null, pstmt, conn);
				
		}
	}

	
	
}
