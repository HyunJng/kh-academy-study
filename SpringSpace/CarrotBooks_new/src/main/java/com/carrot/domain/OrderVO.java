package com.carrot.domain;

import java.sql.Date;
import java.util.List;

public class OrderVO {

	private String orderId;
	private String addressee;
	private int memberId;
	private String memberAddr1;
	private String memberAddr2;
	private String memberAddr3;
	private String orderState;
	private int deliveryCost;
	private int usePoint;
	private Date orderDate;
	
	/* 편의를 위한 변수*/
	private List<OrderItemVO> orders;
	private int orderSalePrice;
	private int orderSavePoint;
	private int orderFinalSalePrice;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberAddr1() {
		return memberAddr1;
	}
	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}
	public String getMemberAddr2() {
		return memberAddr2;
	}
	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}
	public String getMemberAddr3() {
		return memberAddr3;
	}
	public void setMemberAddr3(String memberAddr3) {
		this.memberAddr3 = memberAddr3;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public int getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderItemVO> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderItemVO> orders) {
		this.orders = orders;
	}
	public int getOrderSalePrice() {
		return orderSalePrice;
	}
	public void setOrderSalePrice(int orderSalePrice) {
		this.orderSalePrice = orderSalePrice;
	}
	public int getOrderSavePoint() {
		return orderSavePoint;
	}
	public void setOrderSavePoint(int orderSavePoint) {
		this.orderSavePoint = orderSavePoint;
	}
	public int getOrderFinalSalePrice() {
		return orderFinalSalePrice;
	}
	public void setOrderFinalSalePrice(int orderFinalSalePrice) {
		this.orderFinalSalePrice = orderFinalSalePrice;
	}
	
	public void getOrderPriceInfo() {
		/* 상품 비용 & 적립포인트 */
		for (OrderItemVO order : orders) {
			orderSalePrice += order.getTotalPrice();
			orderSavePoint += order.getTotalSavePoint();
		}
		/* 배송비용 */
		if (orderSalePrice >= 20000) {
			deliveryCost = 0;
		} else {
			deliveryCost = 3000;
		}
		/* 최종 비용(상품 비용 + 배송비 - 사용 포인트) */
		orderFinalSalePrice = orderSalePrice + deliveryCost - usePoint;
	}
	
	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", addressee=" + addressee + ", memberId=" + memberId + ", memberAddr1="
				+ memberAddr1 + ", memberAddr2=" + memberAddr2 + ", memberAddr3=" + memberAddr3 + ", orderState="
				+ orderState + ", deliveryCost=" + deliveryCost + ", usePoint=" + usePoint + ", orderDate=" + orderDate
				+ ", orders=" + orders + ", orderSalePrice=" + orderSalePrice + ", orderSavePoint=" + orderSavePoint
				+ ", orderFinalSalePrice=" + orderFinalSalePrice + "]";
	}
	
}
