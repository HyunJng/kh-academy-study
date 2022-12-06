package user.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;
import user.model.UserVO;

// Data Access Object
public class UserDAO {
	private static Connection conn = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;

	private static final String USER_GET = "select * from users where id = ? and password = ?";
	private static final String USER_GETID = "select * from users where id = ?";

	public static String existUserId(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GETID);
			stmt.setString(1, vo.getId());

			rs = stmt.executeQuery();

			if (rs.next())
				return rs.getString("ID");
		} catch (Exception e) {
			System.out.println("getUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return null;
	}
	
	public static UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setLevel(rs.getString("ROLE"));
				user.setTel(rs.getString("TEL"));
				user.setName(rs.getString("NAME"));
			}
		} catch (Exception e) {
			System.out.println("getUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}
