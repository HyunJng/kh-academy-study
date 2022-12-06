package user.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.model.BoardVO;
import common.JDBCUtil;
import user.model.UserVO;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users where id = ? and password = ?";
	private final String USER_GETID = "select * from users where id = ?";

	public String existUserId(UserVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GETID);
			stmt.setString(1, vo.getId());
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString("ID");
			}
			
		} catch (SQLException e) {
			System.out.println("getUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
			
		return null;
	}

	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		System.out.println("---> JDBC getUser() start");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
			
		} catch (SQLException e) {
			System.out.println("getUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
			
		return user;
	}
}
