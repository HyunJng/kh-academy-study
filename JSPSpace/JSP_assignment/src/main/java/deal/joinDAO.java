package deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import article.articleVO;
import common.JDBCUtil;

public class joinDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String GET_JOIN = "select * from (select row_number()over(order by seq desc)rn ,id,goods,goods_info,goods_img,cost,reg_date,customer,count,c_adr,seq from(select s.id,s.goods,s.goods_info,s.goods_img,s.cost,d.reg_date,d.customer,d.count,d.C_ADR,d.seq from deal_table d,seller_goods s where s.seq = d.GOODS_SEQ and customer= ?))\r\n"
			+ " where  rownum between ? and ?";
	private String GET_JOIN_COUNT = "select count(*) from deal_table ,seller_goods where seller_goods.seq = deal_table.GOODS_SEQ and customer = ?";
	public List<joinVO> getJoinList(joinVO vo ,int startRow, int endRow) {
		List<joinVO> boardList = new ArrayList<joinVO>();

		System.out.println("---> JDBC getJoinList() start");

		try {
			conn = JDBCUtil.getConnection();

			
				stmt = conn.prepareStatement(GET_JOIN);
				System.out.println(vo.getCustomer());
				stmt.setString(1, vo.getCustomer());
				stmt.setInt(2,startRow);
				stmt.setInt(3,endRow);
				System.out.println("DAOerroe1");
			rs = stmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				joinVO board = new joinVO();
				board.setId(rs.getString("id"));
				board.setGoods(rs.getString("goods"));
				board.setGoods_info(rs.getString("goods_info"));
				board.setGoods_img(rs.getString("goods_img"));
				board.setCost(rs.getInt("cost"));
				board.setReg_date(rs.getString("reg_date"));
				board.setCustomer(rs.getString("customer"));
				board.setC_adr(rs.getString("C_adr"));
				board.setSeq(rs.getInt("seq"));
				board.setCount(rs.getInt("count"));
			
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("getJoinList error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return boardList;
	}
	public int getJoinCount(joinVO vo){
		int count = 0;
		System.out.println("---> JDBC getJoinCount() start");
		try {
			conn = JDBCUtil.getConnection();
		
				stmt = conn.prepareStatement(GET_JOIN_COUNT);
			

				stmt.setString(1, vo.getCustomer());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("getJoinCount error");
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return count;
	}

}
