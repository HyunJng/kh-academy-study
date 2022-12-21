package article;

import java.util.HashMap;

public class articleVO {
	private int seq;
	private String reg_date;
	private String id;
	private String goods;
	private String  goods_info;
	private String goods_img;
	private int count;
	private int cost;
	private int sell_count;
	public int getSell_count() {
		return sell_count;
	}
	public void setSell_count(int sell_count) {
		this.sell_count = sell_count;
	}
	private String getSearchCondition;
	private String getSearchKeyword;
	
	public String getGetSearchCondition() {
		return getSearchCondition;
	}
	public void setGetSearchCondition(String getSearchCondition) {
		this.getSearchCondition = getSearchCondition;
	}
	public String getGetSearchKeyword() {
		return getSearchKeyword;
	}
	public void setGetSearchKeyword(String getSearchKeyword) {
		this.getSearchKeyword = getSearchKeyword;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getGoods_info() {
		return goods_info;
	}
	public void setGoods_info(String goods_info) {
		this.goods_info = goods_info;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public HashMap<String, Integer> getList(int count,int pageSize,int currentPage) {
		HashMap<String, Integer> Info = new HashMap<String, Integer>();
		if(count > 0){
			// 총 페이지의 수
			int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
			// 한 페이지에 보여줄 페이지 블럭(링크) 수
			int pageBlock = 10;
			// 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
			int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
			int endPage = startPage + pageBlock - 1;
			
			Info.put("pageCount", pageCount);
			Info.put("pageBlock", pageBlock);
			Info.put("startPage", startPage);
			Info.put("endPage", endPage);
			
		
	}
		return Info;
	
}
}
