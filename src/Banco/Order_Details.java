package Banco;

import java.math.BigDecimal;

public class Order_Details {
	private int OrderID; // N�o nulo
	private int ProdutoID; // N�o nulo
	private String ProdutoName; // N�o nulo
	private java.math.BigDecimal UnitPrice; // N�o nulo
	private short Quantity; // N�o nulo
	private float Discount; // N�o nulo
	
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getProdutoID() {
		return ProdutoID;
	}
	public void setProdutoID(int produtoID) {
		ProdutoID = produtoID;
	}
	public java.math.BigDecimal getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(java.math.BigDecimal unitPrice) {
		UnitPrice = unitPrice;
	}
	public short getQuantity() {
		return Quantity;
	}
	public void setQuantity(short quantity) {
		Quantity = quantity;
	}
	public float getDiscount() {
		return Discount;
	}
	public void setDiscount(float discount) {
		Discount = discount;
	}
	
	
	public String getProdutoName() {
		return ProdutoName;
	}
	public void setProdutoName(String produtoName) {
		ProdutoName = produtoName;
	}
	public Order_Details() {
	
		OrderID = 0;
		ProdutoID = 0;
		UnitPrice =  new BigDecimal("0.0");
		Quantity = 0;
		Discount = 0;
	}
	
	
}
