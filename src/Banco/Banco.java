package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Banco {

	private Connection conexao;

	public Banco() {
		this.conexao = null;
	}

	public Connection getConexao() {
		return this.conexao;
	}

	public void conexao() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;database=Northwind;integratedSecurity=true";
		this.conexao = DriverManager.getConnection(url);

	}

	public Cliente buscaCliente(String ClienteId) throws SQLException {
		Cliente cli = null;
		String SQL = "SELECT * FROM Customers WHERE CustomerID = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, ClienteId);
		ResultSet result = ps.executeQuery();

		if (result.next()) {
			cli = new Cliente();
			cli.setCustomerID(result.getString("CustomerID"));
			cli.setNome(result.getString("CompanyName"));
			cli.setContact_name(result.getString("ContactName"));
			cli.setContact_title(result.getString("ContactTitle"));
			cli.setAddress(result.getString("Address"));
			cli.setCity(result.getString("City"));
			cli.setRegion(result.getString("Region"));
			cli.setPostal_code(result.getString("PostalCode"));
			cli.setCountry(result.getString("Country"));
			cli.setPhone(result.getString("Phone"));
			cli.setFax(result.getString("Fax"));
			cli.tratarNulo();
		}
		return cli;
	}

	public Boolean inserirCliente(Cliente Cli) throws SQLException {

		Cliente cli = null;
		String SQL = "INSERT INTO Customers " + "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, Cli.getCustomerID());
		ps.setString(2, Cli.getNome());
		ps.setString(3, Cli.getContact_name());
		ps.setString(4, Cli.getContact_title());
		ps.setString(5, Cli.getAddress());
		ps.setString(6, Cli.getCity());
		ps.setString(7, Cli.getRegion());
		ps.setString(8, Cli.getPostal_code());
		ps.setString(9, Cli.getCountry());
		ps.setString(10, Cli.getPhone());
		ps.setString(11, Cli.getFax());

		if (ps.executeUpdate() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean updateCliente(Cliente Cli) throws SQLException {

		Cliente cli = null;
		String SQL = "UPDATE Customers " + "SET CompanyName = ?, ContactName = ?, ContactTitle = ?, Address = ?,"
				+ "City = ?, Region = ?, PostalCode = ?, Country = ?, Phone = ?, Fax = ? " + "WHERE CustomerID = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, Cli.getNome());
		ps.setString(2, Cli.getContact_name());
		ps.setString(3, Cli.getContact_title());
		ps.setString(4, Cli.getAddress());
		ps.setString(5, Cli.getCity());
		ps.setString(6, Cli.getRegion());
		ps.setString(7, Cli.getPostal_code());
		ps.setString(8, Cli.getCountry());
		ps.setString(9, Cli.getPhone());
		ps.setString(10, Cli.getFax());
		ps.setString(11, Cli.getCustomerID());

		if (ps.executeUpdate() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean DeleteCliente(String ClienteId) throws SQLException {

		Cliente cli = null;
		String SQL = "DELETE FROM Customers WHERE CustomerID = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, ClienteId);

		if (ps.executeUpdate() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public Orders buscaPedido(String PedidoId) throws SQLException {
		Orders order = null;
		Order_Details OD[] = null;
		String SQL = "SELECT O.OrderID, O.CustomerID, C.CompanyName, O.EmployeeID, E.FirstName ,E.LastName, O.OrderDate, O.RequiredDate, O.ShippedDate, O.ShipVia, "
				+ "O.Freight, O.ShipName " + "FROM Orders O " + "join Customers C on C.CustomerID = O.CustomerID "
				+ "join Employees E on E.EmployeeID = O.EmployeeID WHERE O.OrderID = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, PedidoId);
		ResultSet result = ps.executeQuery();

		if (result.next()) {
			order = new Orders();
			order.setOrderID(result.getInt("OrderID"));
			order.setCustomerID(result.getString("CustomerID"));
			order.setCustomerName(result.getString("CompanyName"));
			order.setEmployeeID(result.getInt("EmployeeID"));

			String prim_nome = result.getString("FirstName");
			String last_nome = result.getString("LastName");
			order.setEmployeeName(prim_nome + " " + last_nome);

			order.setOrderDate(result.getDate("OrderDate"));
			order.setRequiredDate(result.getDate("RequiredDate"));
			order.setShippedDate(result.getDate("ShippedDate"));
			order.setShipVia(result.getInt("ShipVia"));
			order.setFreight(result.getBigDecimal("Freight"));
			order.setShipName(result.getString("ShipName"));

			order.tratarNulo();

			OD = getOrderDeatils(PedidoId);
			order.setOrders_detail(OD);
		}
		return order;
	}

	public Order_Details[] getOrderDeatils(String pedido_id) throws SQLException {
		Order_Details OD[] = null;
		Order_Details od = new Order_Details();
		int i = 0;

		String SQL = "SELECT COUNT(*) AS rows " + "FROM [Order Details] OD "
				+ "join Products P ON P.ProductID = OD.ProductID WHERE OrderID = ?";

		PreparedStatement ps_linhas = this.conexao.prepareStatement(SQL);
		ps_linhas.setString(1, pedido_id);
		ResultSet result_linhas = ps_linhas.executeQuery();

		if (result_linhas.next()) {

			int rows = result_linhas.getInt("rows");
			OD = new Order_Details[rows];
			SQL = "SELECT OD.OrderID, OD.ProductID, P.ProductName, OD.UnitPrice, OD.Quantity, OD.Discount "
					+ "FROM [Order Details] OD " + "join Products P ON P.ProductID = OD.ProductID WHERE OrderID = ?";

			PreparedStatement ps = this.conexao.prepareStatement(SQL);
			ps.setString(1, pedido_id);
			ResultSet result = ps.executeQuery();

			if (result.next()) {

				do {
					od = new Order_Details();
					od.setOrderID(result.getInt("OrderID"));
					od.setProdutoID(result.getInt("ProductID"));
					od.setProdutoName(result.getString("ProductName"));
					od.setUnitPrice(result.getBigDecimal("UnitPrice"));
					od.setQuantity(result.getShort("Quantity"));
					od.setDiscount(result.getFloat("Discount"));
					OD[i] = od;
					i++;
				} while (result.next());
			}

		} else {
			return null;
		}

		return OD;
	}

	public boolean existeEmpregado(String Empregado) throws SQLException {
		boolean existe = false;
		String SQL = "SELECT * FROM Employees WHERE EmployeeID = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, Integer.parseInt(Empregado));
		ResultSet result = ps.executeQuery();

		if (result.next()) {
			existe = true;
		}
		return existe;
	}

	public boolean existeProduto(String produto) throws SQLException {
		boolean existe = false;
		String SQL = "SELECT * FROM Products WHERE ProductID = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, Integer.parseInt(produto));
		ResultSet result = ps.executeQuery();

		if (result.next()) {
			existe = true;
		}
		return existe;
	}
	
	public Boolean inserirPedidoItem(Orders Order, int order_id) throws SQLException {
		
		Order_Details od[] = Order.getOrders_detail();
		
		String SQL = "INSERT INTO [Order Details] (OrderID, ProductID, UnitPrice, Quantity, Discount ) " 
			       + "VALUES( ?, ?, ?, ?, ?)";
		
			
		for(int i = 0; i < od.length; i++) {
			PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
			ps.setInt(1, order_id);
			ps.setInt(2, od[i].getProdutoID());
			ps.setBigDecimal(3, od[i].getUnitPrice());
			ps.setShort(4, od[i].getQuantity());
			ps.setFloat(5, od[i].getDiscount());
			if (!(ps.executeUpdate() > 0)) {
				return false;
			}
		}


		return true;
	}

	public int inserirPedido(Orders Order) throws SQLException {
		String generatedColumns[] = { "ID" };
		int order_id = 0;

		String SQL = "INSERT INTO Orders (CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName ) " 
				       + "VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = this.conexao.prepareStatement(SQL,generatedColumns);
		ps.setString(1, Order.getCustomerID());
		ps.setInt(2, Order.getEmployeeID());
		ps.setDate(3, Order.getOrderDate());
		ps.setDate(4, Order.getRequiredDate());
		ps.setDate(5, Order.getShippedDate());
		ps.setInt(6, Order.getShipVia());
		ps.setBigDecimal(7, Order.getFreight());
		ps.setString(8, Order.getShipName());

		if (ps.executeUpdate() > 0) {
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
			    order_id = rs.getInt(1);
				boolean suscess = inserirPedidoItem(Order, order_id);
				if(suscess == false) {
					order_id = 0;
				}
			}
		} 
		
		return order_id;

	}
	
	public ArrayList<Relatorio> execRelatorio(String primName, String lastName) throws SQLException {
		ArrayList<Relatorio> rel = new ArrayList<Relatorio>();
		
		int i = 0;

		String SQL = "{call relatorio(?, ?)}";

		PreparedStatement ps = conexao.prepareStatement(SQL);
		ps.setString(1, primName);
		ps.setString(2, lastName);
		
		if (ps.execute()) {
			ResultSet result = ps.getResultSet();
			if (result.next()) {

				do {
					Relatorio o_rel = new Relatorio();
				   	String Produto   =  result.getString("ProductName");
		        	Short qty        =  result.getShort("Qty");
		        	o_rel.setProduto(Produto);
		        	o_rel.setQty(qty);
					rel.add(o_rel);
				} while (result.next());
			}

		}else {
			
			return null;
		}
		return rel;
	}
	
	public boolean existeEmpregadoNome(String PrimNome, String LastNome) throws SQLException {
		boolean existe = false;
		String SQL = "SELECT * FROM Employees WHERE FirstName = ? AND LastName = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, PrimNome);
		ps.setString(2, LastNome);
		ResultSet result = ps.executeQuery();

		if (result.next()) {
			existe = true;
		}
		return existe;
	}

}
