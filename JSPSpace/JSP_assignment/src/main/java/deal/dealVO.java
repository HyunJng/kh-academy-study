package deal;

public class dealVO {
	private String reg_date;
	private String seller;
	private String customer;
	
	private int count;
	private int cost;
	private String C_adr;
	private int goods_seq;
	private int seq;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getGoods_seq() {
		return goods_seq;
	}
	public void setGoods_seq(int seq) {
		this.goods_seq = seq;
	}
	public String getC_adr() {
		return C_adr;
	}
	public void setC_adr(String c_adr) {
		C_adr = c_adr;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
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
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	
}
