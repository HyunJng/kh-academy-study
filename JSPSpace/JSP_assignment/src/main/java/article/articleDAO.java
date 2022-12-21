package article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import USER.UserVO;

import common.JDBCUtil;

public class articleDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String INSERT_GOODS = "insert into seller_goods (seq,reg_date,id,goods,goods_info,goods_img,count,cost) values((SELECT NVL(MAX(seq), 0) + 1 FROM seller_goods),\r\n"
			+ "TO_CHAR(SYSDATE,'YYYY-MM-DD'),?,?,?,?,?,?)";
	private final String BOARD_LIST = "select * from seller_goods order by seq desc";
	private final String BOARD_LIST_TITLE = "select * from \r\n"
			+ "        (select row_number() over(order by seq desc) rn,seller_goods.*\r\n"
			+ "        from seller_goods) where rn between ? and ? and goods like  '%' || ? || '%'";
	private final String BOARD_LIST_CONTENT = "select * from board where goods_info like '%' || ? || '%' order by seq desc" ;
	private final String GET_BOARD = "select* from seller_goods where seq = ?";
	private final String BOARD_LIST_PAGING = "select * from \r\n"
			+ "        (select row_number() over(order by seq desc) rn,seller_goods.*\r\n"
			+ "        from seller_goods) where rn between ? and ?";
	private final String GET_COUNT = "select count(*) from seller_goods";
	private final String GET_COUNT_TITLE = " select count(*) from seller_goods where goods like '%' || ? || '%'";
	private final String UPDATE_BOARD = "update seller_goods set goods = ?,goods_info = ?, goods_img = ? , count = ?, cost = ? where seq = ?";
	private final String DELETE_GOODS = "delete from seller_goods where seq = ?";
	public void insertGoods(articleVO vo) {
		System.out.println("---> JDBC insertGoods() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(INSERT_GOODS);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getGoods());
			stmt.setString(3, vo.getGoods_info());
			stmt.setString(4, vo.getGoods_img());
			stmt.setInt(5, vo.getCount());
			stmt.setInt(6, vo.getCost());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertGoods error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void DeleteGoods(int num) {
		System.out.println("---> JDBC DeleteGoods() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(DELETE_GOODS);
			stmt.setInt(1, num);
		
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DeleteGoods error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	
	public void updateGoods(articleVO vo) {
		System.out.println("---> JDBC updateGoods() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_BOARD);
			
			stmt.setString(1, vo.getGoods());
			stmt.setString(2, vo.getGoods_info());
			stmt.setString(3, vo.getGoods_img());
			stmt.setInt(4, vo.getCount());
			stmt.setInt(5, vo.getCost());
			stmt.setInt(6,vo.getSeq());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateGoods error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public articleVO getBoard(articleVO vo) {
		articleVO board = null;

		System.out.println("---> JDBC getBoard() start");

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_BOARD);
			stmt.setInt(1, vo.getSeq());
			System.out.println("error1");
			rs = stmt.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				board = new articleVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setReg_date(rs.getString("reg_date"));
				board.setId(rs.getString("id"));
				board.setGoods(rs.getString("goods"));
				board.setGoods_info(rs.getString("goods_info"));
				board.setGoods_img(rs.getString("goods_img"));
				board.setCount(rs.getInt("count"));
				board.setCost(rs.getInt("cost"));

			}
		} catch (SQLException e) {
			System.out.println("getBoard error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return board;
	}

	public List<articleVO> getGoodsList(articleVO vo) {
		List<articleVO> boardList = new ArrayList<articleVO>();

		System.out.println("---> JDBC getGoodsList() start");

		try {
			conn = JDBCUtil.getConnection();

			if (vo.getGetSearchCondition() == null) {
				stmt = conn.prepareStatement(BOARD_LIST_PAGING);
			} else {
				if (vo.getGetSearchCondition().equals("TITLE")) {
					stmt = conn.prepareStatement(BOARD_LIST_TITLE);
				} else if (vo.getGetSearchKeyword().equals("CONTENT")) {
					stmt = conn.prepareStatement(BOARD_LIST_CONTENT);
				}
				stmt.setString(1, vo.getGetSearchKeyword());
			}

			rs = stmt.executeQuery();

			while (rs.next()) {
				articleVO board = new articleVO();

				board.setSeq(rs.getInt("SEQ"));
				board.setReg_date(rs.getString("reg_date"));
				board.setId(rs.getString("id"));
				board.setGoods(rs.getString("goods"));
				board.setGoods_info(rs.getString("goods_info"));
				board.setGoods_img(rs.getString("goods_img"));
				board.setCount(rs.getInt("count"));
				board.setCost(rs.getInt("cost"));

				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("getGoodsList error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return boardList;
	}

	public List<articleVO> getGoodsPaging(articleVO vo, int startRow, int endRow) {
		List<articleVO> boardList = new ArrayList<articleVO>();

		System.out.println("---> JDBC getGoodsPaging() start");

		try {
			conn = JDBCUtil.getConnection();
			if (vo.getGetSearchKeyword() == null) {
				stmt = conn.prepareStatement(BOARD_LIST_PAGING);
			} else {
				if (vo.getGetSearchKeyword()!=null) {
					stmt = conn.prepareStatement(BOARD_LIST_TITLE);
				} 

				stmt.setString(3, vo.getGetSearchKeyword());
			}
			stmt.setInt(1,startRow);
			stmt.setInt(2,endRow);
			System.out.println("error1");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				articleVO board = new articleVO();
				board = new articleVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setReg_date(rs.getString("reg_date"));
				board.setId(rs.getString("id"));
				board.setGoods(rs.getString("goods"));
				board.setGoods_info(rs.getString("goods_info"));
				board.setGoods_img(rs.getString("goods_img"));
				board.setCount(rs.getInt("count"));
				board.setCost(rs.getInt("cost"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("getBoard error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return boardList;
		}
	public int getCount(articleVO vo){
		int count = 0;
		System.out.println("---> JDBC getCount() start");
		try {
			conn = JDBCUtil.getConnection();
			if (vo.getGetSearchKeyword() == null) {
				stmt = conn.prepareStatement(GET_COUNT);
			} else {
				if (vo.getGetSearchKeyword()!=null) {
					stmt = conn.prepareStatement(GET_COUNT_TITLE);
				} 

				stmt.setString(1, vo.getGetSearchKeyword());
			}
			rs = stmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("getCount error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return count;
	}

}
