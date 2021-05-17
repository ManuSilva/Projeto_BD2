package Banco;

import java.math.BigDecimal;
import java.sql.Date;

public class Orders {
	
	private int OrderID;       // Não nulo
	private String CustomerID;
	private String CustomerName;
	private int EmployeeID;
	private String EmployeeName;
	private Date OrderDate;
	private Date RequiredDate;
	private Date ShippedDate;
	private int ShipVia;
	private String ShipName;
	private java.math.BigDecimal Freight;
	private Order_Details orders_detail[];
	
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Date getRequiredDate() {
		return RequiredDate;
	}
	public void setRequiredDate(Date requiredDate) {
		RequiredDate = requiredDate;
	}
	public Date getShippedDate() {
		return ShippedDate;
	}
	public void setShippedDate(Date shippedDate) {
		ShippedDate = shippedDate;
	}
	public int getShipVia() {
		return ShipVia;
	}
	public void setShipVia(int shipVia) {
		ShipVia = shipVia;
	}
	public java.math.BigDecimal getFreight() {
		return Freight;
	}
	public void setFreight(java.math.BigDecimal freight) {
		Freight = freight;
	}

	public String getShipName() {
		return ShipName;
	}
	public void setShipName(String shipName) {
		ShipName = shipName;
	}
	public Orders() {

		OrderID = 0;
		CustomerID = "";
		CustomerName = "";
		EmployeeID = 0;
		EmployeeName = "";
		OrderDate = null;
		RequiredDate = null;
		ShippedDate= null;
		ShipVia = 0;
		Freight = new BigDecimal("0.0");
		orders_detail = null;
	}
	public Order_Details[] getOrders_detail() {
		return orders_detail;
	}
	public void setOrders_detail(Order_Details[] orders_detail) {
		this.orders_detail = orders_detail;
	}
	
	public void tratarNulo() {
		
		if (CustomerID == null) {
			CustomerID = "";
		}

		if (CustomerName == null) {
			CustomerName = "";
		}
		if (EmployeeName == null) {
			EmployeeName = "";
		}

	}
	
	
}
