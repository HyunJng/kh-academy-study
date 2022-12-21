package deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import USER.UserVO;
import article.articleVO;
import common.JDBCUtil;

public class dealDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String BUY_GOODS = "insert into deal_table(reg_date,seller,customer,C_adr,count,cost,goods_seq,seq) values\r\n"
			+ "(TO_CHAR(SYSDATE,'YYYY-MM-DD'),?,?,?,?,?,?,(SELECT NVL(MAX(seq), 0) + 1 FROM deal_table))";
	private final String BOARD_UPDATE_CNT = "update seller_goods set count=?,sell_count=? where seq = ?";
	private final String GET_DEAL_PAGING = "select * from \r\n"
			+ "        (select row_number() over(order by seq) rn,deal_table.*\r\n"
			+ "        from deal_table where customer= ?) where  rn between ? and ?";
	private final String GET_DEAL_COUNT = " select count(*) from deal_table where customer= ?";
	private final String GET_DEAL_SELLER_PAGING = "select * from \r\n"
			+ "        (select row_number() over(order by seq desc) rn,seller_goods.*from seller_goods where id= ?) \r\n"
			+ "        where  rn between ? and ?";
	private final String GET_DEAL_SELLER_COUNT = " select count(*) from seller_goods where id= ?";
	private final String GET_SUM = "select sum(cost) from seller_goods where id = ?";
	private final String DELETE_GOODS = "delete from deal_table  where seq = ?";
	public void insertDeal(dealVO vo,articleVO Avo) {
		
		System.out.println("---> JDBC insertDeal() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BUY_GOODS);
			stmt.setString(1, vo.getSeller());
			stmt.setString(2, vo.getCustomer());
			stmt.setString(3, vo.getC_adr());
			
			stmt.setInt(4, vo.getCount());
			stmt.setInt(5, vo.getCost());
			stmt.setInt(6, vo.getGoods_seq());
			
			
			stmt.executeUpdate();	
			stmt = conn.prepareStatement(BOARD_UPDATE_CNT);
			System.out.println(vo.getCount() + "DAO");
			stmt.setInt(1, Avo.getCount()-vo.getCount());
			stmt.setInt(2, vo.getCount());
			stmt.setInt(3, Avo.getSeq());
			stmt.executeUpdate();	
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertDeal error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	//customer
	public List<dealVO> getCustomerDealList(dealVO vo ,int startRow, int endRow) {
		List<dealVO> boardList = new ArrayList<dealVO>();

		System.out.println("---> JDBC getCustomerDealList() start");

		try {
			conn = JDBCUtil.getConnection();

			
				stmt = conn.prepareStatement(GET_DEAL_PAGING);
				stmt.setInt(2,startRow);
				stmt.setInt(3,endRow);
				stmt.setString(1, vo.getCustomer());
			

			rs = stmt.executeQuery();

			while (rs.next()) {
				dealVO board = new dealVO();

				
				board.setReg_date(rs.getString("reg_date"));
				board.setSeller(rs.getString("seller"));
				board.setCustomer(rs.getString("customer"));
				board.setCount(rs.getInt("count"));
				board.setCost(rs.getInt("cost"));
				board.setGoods_seq(rs.getInt("goods_seq"));
				board.setC_adr("C_adr");
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("getCustomerDealList error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return boardList;
	}
	public int getDealCount(dealVO vo){
		int count = 0;
		System.out.println("---> JDBC getDealCount() start");
		try {
			conn = JDBCUtil.getConnection();
		
				stmt = conn.prepareStatement(GET_DEAL_COUNT);
			
			

				stmt.setString(1, vo.getCustomer());
			
			rs = stmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("getDealCount error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return count;
	}
	
public void dealeteGOods(int num) {
		
		System.out.println("---> JDBC dealeteGOods() start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(DELETE_GOODS);
			stmt.setInt(1, num);
			
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dealeteGOods error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// seller
	public List<articleVO> getsellerDealList(articleVO vo ,int startRow, int endRow) {
		List<articleVO> boardList = new ArrayList<articleVO>();

		System.out.println("---> JDBC getsellerDealList() start");

		try {
			conn = JDBCUtil.getConnection();

			
				stmt = conn.prepareStatement(GET_DEAL_SELLER_PAGING);
				stmt.setInt(2,startRow);
				stmt.setInt(3,endRow);
				stmt.setString(1, vo.getId());
			

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
				System.out.println(rs.getInt("cost"));
				board.setSell_count(rs.getInt("sell_count"));
				System.out.println(rs.getInt("sell_count"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("getsellerDealList error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return boardList;
	}
	public int getDealSellerCount(articleVO vo){
		int count = 0;
		System.out.println("---> JDBC getDealSellerCount() start");
		try {
			conn = JDBCUtil.getConnection();
		
				stmt = conn.prepareStatement(GET_DEAL_SELLER_COUNT);
			
			

				stmt.setString(1, vo.getId());
			
			rs = stmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("getDealSellerCount error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return count;
	}
	public int getSum(UserVO vo){
		int sum = 0;
		System.out.println("---> JDBC getSum() start");
		try {
			conn = JDBCUtil.getConnection();
		
				stmt = conn.prepareStatement(GET_SUM);
			
			

				stmt.setString(1, vo.getId());
				System.out.println(vo.getId() + "sql");
			rs = stmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				sum = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("getSum error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return sum;
	}
}

