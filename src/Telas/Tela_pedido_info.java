package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Banco.Banco;
import Banco.Cliente;
import Banco.Orders;
import Banco.Order_Details;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.JTextArea;

public class Tela_pedido_info extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel tl_titulo;
	private JTextField tf_pedido_Id;
	private JTextField tf_cliente_id;
	private JTextField tf_cliente_nome;
	private JTextField tf_empl_id;
	private JTextField tf_empl_nome;
	private JTextField tf_data_pedido;
	private JLabel tl_data_pedido;
	private JTextField tf_data_requerida;
	private JLabel tl_data_requerida;
	private JLabel tl_data_envio;
	private JTextField tf_data_envio;
	private JTextField tf_expedidor_nome;
	private JTextField tf_expedidor_id;
	private JLabel tl_expedidor;
	private JTextField tf_frete;
	private JLabel tl_frete;
	private JButton bt_voltar;
	private JScrollPane scrollPane;
	private JPanel panel_tabela;
	private JTable table_order_details;
	private int tipo; // 1 - Visualização, 2 - Inserção
	private JButton bt_confirm;
	private JButton bt_insert;
	private JButton bt_delete;
	private DefaultTableModel Modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_pedido_info frame = new Tela_pedido_info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_pedido_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(5, 5, 828, 529);
		contentPane.add(panel);
		panel.setLayout(null);

		tl_titulo = new JLabel("Visualiza\u00E7\u00E3o de Pedido");
		tl_titulo.setFont(new Font("Swis721 BT", Font.BOLD, 16));
		tl_titulo.setBounds(328, 21, 178, 36);
		panel.add(tl_titulo);

		tf_pedido_Id = new JTextField();
		tf_pedido_Id.setEditable(false);
		tf_pedido_Id.setColumns(10);
		tf_pedido_Id.setBounds(115, 76, 212, 20);
		panel.add(tf_pedido_Id);

		JLabel tl_pedido_id = new JLabel("Pedido ID:");
		tl_pedido_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_pedido_id.setBounds(38, 76, 78, 20);
		panel.add(tl_pedido_id);

		tf_cliente_id = new JTextField();
		tf_cliente_id.setEditable(false);
		tf_cliente_id.setColumns(10);
		tf_cliente_id.setBounds(115, 109, 64, 20);
		panel.add(tf_cliente_id);

		JLabel tl_cliente = new JLabel("Cliente:");
		tl_cliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_cliente.setBounds(38, 109, 78, 20);
		panel.add(tl_cliente);

		tf_cliente_nome = new JTextField();
		tf_cliente_nome.setEditable(false);
		tf_cliente_nome.setColumns(10);
		tf_cliente_nome.setBounds(189, 109, 212, 20);
		panel.add(tf_cliente_nome);

		tf_empl_id = new JTextField();
		tf_empl_id.setEditable(false);
		tf_empl_id.setColumns(10);
		tf_empl_id.setBounds(115, 142, 64, 20);
		panel.add(tf_empl_id);

		tf_empl_nome = new JTextField();
		tf_empl_nome.setEditable(false);
		tf_empl_nome.setColumns(10);
		tf_empl_nome.setBounds(189, 142, 212, 20);
		panel.add(tf_empl_nome);

		JLabel tf_funcionario = new JLabel("Funcion\u00E1rio:");
		tf_funcionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_funcionario.setBounds(38, 142, 78, 20);
		panel.add(tf_funcionario);

		tf_data_pedido = new JTextField();
		tf_data_pedido.setEditable(false);
		tf_data_pedido.setColumns(10);
		tf_data_pedido.setBounds(543, 76, 212, 20);
		panel.add(tf_data_pedido);

		tl_data_pedido = new JLabel("Data do Pedido:");
		tl_data_pedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_data_pedido.setBounds(439, 74, 106, 20);
		panel.add(tl_data_pedido);

		tf_data_requerida = new JTextField();
		tf_data_requerida.setEditable(false);
		tf_data_requerida.setColumns(10);
		tf_data_requerida.setBounds(543, 109, 212, 20);
		panel.add(tf_data_requerida);

		tl_data_requerida = new JLabel("Data Requerida:");
		tl_data_requerida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_data_requerida.setBounds(439, 107, 106, 20);
		panel.add(tl_data_requerida);

		tl_data_envio = new JLabel("Data de Envio:");
		tl_data_envio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_data_envio.setBounds(439, 140, 106, 20);
		panel.add(tl_data_envio);

		tf_data_envio = new JTextField();
		tf_data_envio.setEditable(false);
		tf_data_envio.setColumns(10);
		tf_data_envio.setBounds(543, 142, 212, 20);
		panel.add(tf_data_envio);

		tf_expedidor_nome = new JTextField();
		tf_expedidor_nome.setEditable(false);
		tf_expedidor_nome.setColumns(10);
		tf_expedidor_nome.setBounds(189, 176, 212, 20);
		panel.add(tf_expedidor_nome);

		tf_expedidor_id = new JTextField();
		tf_expedidor_id.setEditable(false);
		tf_expedidor_id.setColumns(10);
		tf_expedidor_id.setBounds(115, 176, 64, 20);
		panel.add(tf_expedidor_id);

		tl_expedidor = new JLabel("Exepedidor:");
		tl_expedidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_expedidor.setBounds(38, 176, 78, 20);
		panel.add(tl_expedidor);

		tf_frete = new JTextField();
		tf_frete.setEditable(false);
		tf_frete.setColumns(10);
		tf_frete.setBounds(481, 176, 64, 20);
		panel.add(tf_frete);

		tl_frete = new JLabel("Frete:");
		tl_frete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_frete.setBounds(439, 176, 78, 20);
		panel.add(tl_frete);

		bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_id_pedido tela_id_pedido = new Tela_id_pedido();
				tela_id_pedido.setVisible(true);
				dispose();
			}
		});
		bt_voltar.setBounds(721, 484, 97, 23);
		panel.add(bt_voltar);

		panel_tabela = new JPanel();
		panel_tabela.setBounds(61, 253, 678, 193);
		panel.add(panel_tabela);
		panel_tabela.setLayout(new BorderLayout(0, 0));

		table_order_details = new JTable();
		table_order_details.setCellSelectionEnabled(true);
		panel_tabela.add(table_order_details, BorderLayout.CENTER);

		bt_confirm = new JButton("Confimar");
		bt_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					criarPedido();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt_confirm.setBounds(614, 484, 97, 23);
		panel.add(bt_confirm);

		bt_insert = new JButton("Inserir Linha");
		bt_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo.addRow(new Object[] { "", "", "", "", "" });
				table_order_details.setModel(Modelo);
			}
		});
		bt_insert.setBounds(19, 484, 111, 23);
		panel.add(bt_insert);

		bt_delete = new JButton("Deletar Linha");
		bt_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = table_order_details.getSelectedRows();
				for (int i = 0; i < rows.length; i++) {
					Modelo.removeRow(rows[i] - i);
				}
				table_order_details.setModel(Modelo);
			}
		});
		bt_delete.setBounds(140, 484, 111, 23);
		panel.add(bt_delete);

	}

	public void setDados(Orders order) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		tf_pedido_Id.setText(Integer.toString(order.getOrderID()));
		tf_cliente_id.setText(order.getCustomerID());
		tf_cliente_nome.setText(order.getCustomerName());
		tf_empl_id.setText(Integer.toString(order.getEmployeeID()));
		tf_empl_nome.setText(order.getEmployeeName());

		if (order.getOrderDate() != null) {
			tf_data_pedido.setText(dateFormat.format(order.getOrderDate()));
		}

		if (order.getRequiredDate() != null) {
			tf_data_requerida.setText(dateFormat.format(order.getRequiredDate()));
		}
		if (order.getShippedDate() != null) {
			tf_data_envio.setText(dateFormat.format(order.getShippedDate()));
		}

		tf_expedidor_nome.setText(order.getShipName());
		tf_expedidor_id.setText(Integer.toString(order.getShipVia()));
		tf_frete.setText(order.getFreight().toString());

		montarTabela(order.getOrders_detail());

	}

	public void montarTabela(Order_Details[] OD) {
		int i;
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		modelo.addColumn("Produto ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Preço Unitário");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Desconto");

		for (i = 0; i < OD.length; i++) {
			modelo.addRow(new Object[] { OD[i].getProdutoID(), OD[i].getProdutoName(), OD[i].getUnitPrice(),
					OD[i].getQuantity(), OD[i].getDiscount() });

		}

		Modelo = modelo;

		table_order_details.setModel(modelo);
		JTableHeader header = table_order_details.getTableHeader();
		panel_tabela.add(header, BorderLayout.NORTH);

		table_order_details.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_order_details.getColumnModel().getColumn(1).setPreferredWidth(190);
		table_order_details.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_order_details.getColumnModel().getColumn(3).setPreferredWidth(80);
		table_order_details.getColumnModel().getColumn(4).setPreferredWidth(80);

	}

	public void setTipo(String titulo, int tipo) {

		this.tipo = tipo;
		tl_titulo.setText(titulo);

		if (tipo == 1) {
			tf_pedido_Id.setEditable(false);
			tf_cliente_id.setEditable(false);
			tf_cliente_nome.setEditable(false);
			tf_empl_id.setEditable(false);
			tf_empl_nome.setEditable(false);
			tf_data_pedido.setEditable(false);
			tf_data_requerida.setEditable(false);
			tf_data_envio.setEditable(false);
			tf_expedidor_nome.setEditable(false);
			tf_expedidor_id.setEditable(false);
			tf_frete.setEditable(false);

			bt_confirm.hide();
			bt_insert.hide();
			bt_delete.hide();

		} else if (tipo == 2) {
			tf_pedido_Id.setEditable(true);
			tf_cliente_id.setEditable(true);
			tf_cliente_nome.hide();
			tf_empl_id.setEditable(true);
			tf_empl_nome.hide();
			tf_data_pedido.setEditable(true);
			tf_data_requerida.setEditable(true);
			tf_data_envio.setEditable(true);
			tf_expedidor_nome.setEditable(true);
			tf_expedidor_id.setEditable(true);
			tf_frete.setEditable(true);
			montarTabelaEdit();
		}
	}

	public void montarTabelaEdit() {

		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return true;
			}
		};

		modelo.addColumn("Produto ID");
		modelo.addColumn("Preço Unitário");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Desconto");

		modelo.addTableModelListener((TableModelListener) new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Modelo = modelo;

		table_order_details.setModel(modelo);
		JTableHeader header = table_order_details.getTableHeader();
		panel_tabela.add(header, BorderLayout.NORTH);

		table_order_details.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_order_details.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_order_details.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_order_details.getColumnModel().getColumn(3).setPreferredWidth(80);

	}

	public void criarPedido() throws ParseException {
		Mensagem mensg = new Mensagem();

		if (tf_pedido_Id.getText().equals("")) {
			mensg.setMensage("Não é permitido Pedido ID em branco");
			mensg.setVisible(true);
		} else if (table_order_details.getModel().getRowCount() == 0) {
			mensg.setMensage("Não é permitido criar pedido sem produto");
			mensg.setVisible(true);
		} else if (table_order_details.getModel().getValueAt(0, 0).equals("")) {
			mensg.setMensage("Não é permitido criar pedido com Produto ID em branco");
			mensg.setVisible(true);
		} else if (!tf_cliente_id.getText().equals("") && !validaCliente(tf_cliente_id.getText())) {
			mensg.setMensage("Cliente " + tf_cliente_id.getText() + " Não existe");
			mensg.setVisible(true);
		} else if (!tf_empl_id.getText().equals("") && !validaEmpregado(tf_empl_id.getText())) {
			mensg.setMensage("Funcionário " + tf_empl_id.getText() + " Não existe");
			mensg.setVisible(true);
		} else {
			Orders order = new Orders();
			Banco bd = new Banco();

			String produto = validaProduto();
			if (!produto.equals("")) {
				mensg.setMensage("Produto ID " + produto + " Não existe");
				mensg.setVisible(true);
			} else {
				Boolean existe = validaJaExiste(tf_pedido_Id.getText());
				if (existe == true) {
					mensg.setMensage("Pedido " + tf_pedido_Id.getText() + " Já existe");
					mensg.setVisible(true);
				} else {
					order = MontaPedido();
					boolean insert_suc = false;

					try {
						insert_suc = bd.inserirPedido(order);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (insert_suc == true) {
						Orders order_refresh = new Orders();
						setDados(order_refresh);
						mensg.setMensage("Pedido criado com sucesso");
						mensg.setVisible(true);
					} else {
						mensg.setMensage("Não foi possível criar Pedido");
						mensg.setVisible(true);
					}
				}
			}

		}

	}

	public boolean validaJaExiste(String Order_id) {
		Orders order = new Orders();
		Banco bd = new Banco();
		try {
			bd.conexao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			order = bd.buscaPedido(Order_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (order == null) {
			return false;
		} else {
			return true;
		}

	}

	public boolean validaCliente(String Cliente) {
		Cliente cli = new Cliente();
		Banco bd = new Banco();
		try {
			bd.conexao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cli = bd.buscaCliente(Cliente);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (cli == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validaEmpregado(String Empregado) {
		boolean existe = false;

		Banco bd = new Banco();
		try {
			bd.conexao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			existe = bd.existeEmpregado(Empregado);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return existe;

	}

	public String validaProduto() {
		boolean existe = false;
		String produto = "";
		int rows = table_order_details.getModel().getRowCount();
		Banco bd = new Banco();

		for (int i = 0; i < rows; i++) {
			try {
				bd.conexao();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				produto = (String) table_order_details.getModel().getValueAt(i, 0);
				existe = bd.existeProduto(produto);
				if (existe == false) {
					return produto;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		return "";
	}

	public Orders MontaPedido() throws ParseException {
		Orders order = new Orders();
		Order_Details od = new Order_Details();
		int rows = table_order_details.getModel().getRowCount();
		Order_Details OD[] = new Order_Details[rows];
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		for (int i = 0; i < rows; i++) {
			od = new Order_Details();
			od.setOrderID(Integer.parseInt(tf_pedido_Id.getText()));
			od.setProdutoID(Integer.parseInt(table_order_details.getModel().getValueAt(i, 0).toString()));

			BigDecimal unit_price = new BigDecimal(table_order_details.getModel().getValueAt(i, 1).toString());
			od.setUnitPrice(unit_price);

			od.setQuantity(Short.valueOf(table_order_details.getModel().getValueAt(i, 2).toString()));
			od.setDiscount(Float.parseFloat(table_order_details.getModel().getValueAt(i, 3).toString()));
			OD[i] = od;
		}

		order.setOrderID(Integer.parseInt(tf_pedido_Id.getText()));
		order.setCustomerID(tf_cliente_id.getText());
		order.setEmployeeID(Integer.parseInt(tf_empl_id.getText()));

		if (!tf_data_pedido.getText().equals("")) {
			java.util.Date data_pedido = format.parse(tf_data_pedido.getText());
			java.sql.Date data_pedido_sql = new java.sql.Date(data_pedido.getTime());
			order.setOrderDate(data_pedido_sql);
		}
		if (!tf_data_requerida.getText().equals("")) {
			java.util.Date data_requerida = format.parse(tf_data_requerida.getText());
			java.sql.Date data_requerida_sql = new java.sql.Date(data_requerida.getTime());
			order.setRequiredDate(data_requerida_sql);
		}
		if (!tf_data_envio.getText().equals("")) {
			java.util.Date data_envio = format.parse(tf_data_envio.getText());
			java.sql.Date data_envio_sql = new java.sql.Date(data_envio.getTime());
			order.setShippedDate(data_envio_sql);
		}

		order.setShipVia(Integer.parseInt(tf_expedidor_id.getText()));
		if (!tf_frete.getText().equals("")) {
			BigDecimal frete = new BigDecimal(tf_frete.getText());
			order.setFreight(frete);
		}
		
		order.setShipName(tf_expedidor_nome.getText());

		order.setOrders_detail(OD);
		return order;
	}
}
