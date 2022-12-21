package user.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.model.BoardVO;
import common.JDBCUtil;
import user.model.UserVO;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users where id = ? and password = ?";
	private final String USER_GETID = "select * from users where id = ?";
	private final String USER_UPDATE = "update users set password = ?, email = ?, tel = ? where id = ?";
	private final String USER_INSERT = "insert into users (name, id, password, email, tel, role) values(?, ?, ?, ?, ?, ?)";
	private final String USER_DELETE = "delete from users where id = ?";
	private final String USER_LIST = "select * from users order by role desc";

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
				user.setEmail(rs.getString("EMAIL"));
				user.setTel(rs.getString("TEL"));
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
	
	public void updateSignup(UserVO vo) {
		System.out.println("---> JDBC updateSignup() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getTel());
			stmt.setString(4, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateUser error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void insertSignup(UserVO vo) {
		System.out.println("---> JDBC insertBoard() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getId());
			stmt.setString(3, vo.getPassword());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getTel());
			stmt.setString(6, vo.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertUser error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void deleteUser(UserVO vo) {
		System.out.println("---> JDBC deleteUser() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("deleteUser error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public List<UserVO> getUserList(UserVO vo) {
		List<UserVO> userList = new ArrayList<UserVO>();
		
		System.out.println("---> JDBC getUserList() start");
		try {
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				UserVO user = new UserVO();
				
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setTel(rs.getString("TEL"));
				user.setRole(rs.getString("ROLE"));
				
				userList.add(user);
			}
		} catch (SQLException e) {
			System.out.println("getUserList error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return userList;
	}
	
}
