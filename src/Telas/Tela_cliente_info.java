package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import Banco.Banco;
import Banco.Cliente;

public class Tela_cliente_info extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cliente_id;
	private JTextField tf_nome;
	private JTextField tf_nome_contact;
	private JTextField tf_contact_title;
	private JTextField tf_endereco;
	private JTextField tf_cidade;
	private JTextField tf_regiao;
	private JTextField tf_code_postal;
	private JTextField tf_pais;
	private JTextField tf_fone;
	private JTextField tf_fax;
	private JLabel tl_titulo;
	private JButton bt_confirm;
	private int tipo; // 1 - Visualização, 2 - Inserção, 3 - Atualização, 4 - Remorção
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cliente_info frame = new Tela_cliente_info();
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
	public Tela_cliente_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 447, 497);
		contentPane.add(panel);
		panel.setLayout(null);

		tl_titulo = new JLabel("Visualiza\u00E7\u00E3o de Cliente");
		tl_titulo.setFont(new Font("Swis721 BT", Font.BOLD, 16));
		tl_titulo.setBounds(128, 11, 178, 36);
		panel.add(tl_titulo);

		tf_cliente_id = new JTextField();
		tf_cliente_id.setEditable(false);
		tf_cliente_id.setColumns(10);
		tf_cliente_id.setBounds(144, 69, 212, 20);
		panel.add(tf_cliente_id);

		JLabel tl_cliente = new JLabel("Cliente ID:");
		tl_cliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_cliente.setBounds(71, 67, 78, 20);
		panel.add(tl_cliente);

		JButton bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Tela_id_cliente tela_id_cliente = new Tela_id_cliente();
				if (tipo == 1) {
					tela_id_cliente.setTipo("Visualização de Cliente", tipo);
					tela_id_cliente.setVisible(true);
					dispose();
				} else if (tipo == 3) {
					tela_id_cliente.setTipo("Atualização de Cliente", tipo);
					tela_id_cliente.setVisible(true);
					dispose();
				} else if (tipo == 2) {
					Tela_opcao_cliente tela_opcao_cliente = new Tela_opcao_cliente();
					tela_opcao_cliente.setVisible(true);
					dispose();
				}


			}
		});
		bt_voltar.setBounds(340, 463, 97, 23);
		panel.add(bt_voltar);

		tf_nome = new JTextField();
		tf_nome.setEditable(false);
		tf_nome.setColumns(10);
		tf_nome.setBounds(144, 100, 212, 20);
		panel.add(tf_nome);

		JLabel tl_nome = new JLabel("Nome:");
		tl_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_nome.setBounds(71, 100, 78, 20);
		panel.add(tl_nome);

		tf_nome_contact = new JTextField();
		tf_nome_contact.setEditable(false);
		tf_nome_contact.setColumns(10);
		tf_nome_contact.setBounds(194, 135, 162, 20);
		panel.add(tf_nome_contact);

		JLabel tl_nome_contact = new JLabel("Nome de Contato:");
		tl_nome_contact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_nome_contact.setBounds(71, 133, 121, 20);
		panel.add(tl_nome_contact);

		tf_contact_title = new JTextField();
		tf_contact_title.setEditable(false);
		tf_contact_title.setColumns(10);
		tf_contact_title.setBounds(194, 167, 162, 20);
		panel.add(tf_contact_title);

		JLabel tl_contact_title = new JLabel("T\u00EDtulo do Contato:");
		tl_contact_title.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_contact_title.setBounds(71, 165, 121, 20);
		panel.add(tl_contact_title);

		tf_endereco = new JTextField();
		tf_endereco.setEditable(false);
		tf_endereco.setColumns(10);
		tf_endereco.setBounds(144, 200, 212, 20);
		panel.add(tf_endereco);

		JLabel tl_endereco = new JLabel("Endere\u00E7o:");
		tl_endereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_endereco.setBounds(71, 198, 78, 20);
		panel.add(tl_endereco);

		tf_cidade = new JTextField();
		tf_cidade.setEditable(false);
		tf_cidade.setColumns(10);
		tf_cidade.setBounds(144, 233, 212, 20);
		panel.add(tf_cidade);

		JLabel tl_cidade = new JLabel("Cidade:");
		tl_cidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_cidade.setBounds(71, 231, 78, 20);
		panel.add(tl_cidade);

		tf_regiao = new JTextField();
		tf_regiao.setEditable(false);
		tf_regiao.setColumns(10);
		tf_regiao.setBounds(144, 269, 212, 20);
		panel.add(tf_regiao);

		JLabel tl_regiao = new JLabel("Regi\u00E3o:");
		tl_regiao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_regiao.setBounds(71, 267, 78, 20);
		panel.add(tl_regiao);

		tf_code_postal = new JTextField();
		tf_code_postal.setEditable(false);
		tf_code_postal.setColumns(10);
		tf_code_postal.setBounds(164, 302, 192, 20);
		panel.add(tf_code_postal);

		JLabel tl_postal_code = new JLabel("C\u00F3digo Postal:");
		tl_postal_code.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_postal_code.setBounds(71, 300, 97, 20);
		panel.add(tl_postal_code);

		tf_pais = new JTextField();
		tf_pais.setEditable(false);
		tf_pais.setColumns(10);
		tf_pais.setBounds(144, 333, 212, 20);
		panel.add(tf_pais);

		JLabel tl_pais = new JLabel("Pa\u00EDs: ");
		tl_pais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_pais.setBounds(71, 333, 78, 20);
		panel.add(tl_pais);

		tf_fone = new JTextField();
		tf_fone.setEditable(false);
		tf_fone.setColumns(10);
		tf_fone.setBounds(144, 366, 212, 20);
		panel.add(tf_fone);

		JLabel tl_fone = new JLabel("Telefone:");
		tl_fone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_fone.setBounds(71, 366, 78, 20);
		panel.add(tl_fone);

		tf_fax = new JTextField();
		tf_fax.setEditable(false);
		tf_fax.setColumns(10);
		tf_fax.setBounds(144, 399, 212, 20);
		panel.add(tf_fax);

		JLabel tl_fax = new JLabel("Fax:");
		tl_fax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_fax.setBounds(71, 399, 78, 20);
		panel.add(tl_fax);

		bt_confirm = new JButton("Confirmar");
		bt_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tipo == 2) {
					insercao();
				} else if (tipo == 3) {
					alteracao();
				}

			}
		});
		bt_confirm.setBounds(235, 463, 97, 23);
		panel.add(bt_confirm);
	}

	public void setDados(Cliente cli) {

		this.cliente = cli;

		tf_cliente_id.setText(cli.getCustomerID());
		tf_nome.setText(cli.getNome());
		tf_nome_contact.setText(cli.getContact_name());
		tf_contact_title.setText(cli.getContact_title());
		tf_endereco.setText(cli.getAddress());
		tf_cidade.setText(cli.getCity());
		tf_regiao.setText(cli.getRegion());
		tf_code_postal.setText(cli.getPostal_code());
		tf_pais.setText(cli.getCountry());
		tf_fone.setText(cli.getPhone());
		tf_fax.setText(cli.getFax());
	}

	public void setTipo(String titulo, int tipo) {

		this.tipo = tipo;
		tl_titulo.setText(titulo);

		if (tipo == 3) {

			tf_cliente_id.setEditable(false);
			tf_nome.setEditable(true);
			tf_nome_contact.setEditable(true);
			tf_contact_title.setEditable(true);
			tf_endereco.setEditable(true);
			tf_cidade.setEditable(true);
			tf_regiao.setEditable(true);
			tf_code_postal.setEditable(true);
			tf_pais.setEditable(true);
			tf_fone.setEditable(true);
			tf_fax.setEditable(true);

		} else if (tipo == 1) {

			tf_cliente_id.setEditable(false);
			tf_nome.setEditable(false);
			tf_nome_contact.setEditable(false);
			tf_contact_title.setEditable(false);
			tf_endereco.setEditable(false);
			tf_cidade.setEditable(false);
			tf_regiao.setEditable(false);
			tf_code_postal.setEditable(false);
			tf_pais.setEditable(false);
			tf_fone.setEditable(false);
			tf_fax.setEditable(false);

			bt_confirm.hide();

		} else if (tipo == 2) {

			tf_cliente_id.setEditable(true);
			tf_nome.setEditable(true);
			tf_nome_contact.setEditable(true);
			tf_contact_title.setEditable(true);
			tf_endereco.setEditable(true);
			tf_cidade.setEditable(true);
			tf_regiao.setEditable(true);
			tf_code_postal.setEditable(true);
			tf_pais.setEditable(true);
			tf_fone.setEditable(true);
			tf_fax.setEditable(true);

		}

	}

	public Boolean validaAlteracao() {

		if (cliente.getCustomerID().equals(tf_cliente_id.getText()) && cliente.getNome().equals(tf_nome.getText())
				&& cliente.getContact_name().equals(tf_nome_contact.getText())
				&& cliente.getContact_title().equals(tf_contact_title.getText())
				&& cliente.getAddress().equals(tf_endereco.getText()) && cliente.getCity().equals(tf_cidade.getText())
				&& cliente.getRegion().equals(tf_regiao.getText())
				&& cliente.getPostal_code().equals(tf_code_postal.getText())
				&& cliente.getCountry().equals(tf_pais.getText()) && cliente.getPhone().equals(tf_fone.getText())
				&& cliente.getFax().equals(tf_fax.getText())) {

			return false;
		} else {
			return true;
		}

	}

	public Cliente MontaCliente() {
		Cliente cli = new Cliente();

		cli.setCustomerID(tf_cliente_id.getText());
		cli.setNome(tf_nome.getText());
		cli.setContact_name(tf_nome_contact.getText());
		cli.setContact_title(tf_contact_title.getText());
		cli.setAddress(tf_endereco.getText());
		cli.setCity(tf_cidade.getText());
		cli.setRegion(tf_regiao.getText());
		cli.setPostal_code(tf_code_postal.getText());
		cli.setCountry(tf_pais.getText());
		cli.setPhone(tf_fone.getText());
		cli.setFax(tf_fax.getText());

		return cli;
	}

	public void insercao() {
		Mensagem mensg = new Mensagem();

		if (tf_cliente_id.getText().equals("")) {
			mensg.setMensage("Não é permitido Cliente ID em branco");
			mensg.setVisible(true);
		} else if (tf_nome.getText().equals("")) {
			mensg.setMensage("Não é permitido campo nome em branco");
			mensg.setVisible(true);
		} else {
			Cliente cli = new Cliente();
			Banco bd = new Banco();

			Boolean existe = validaJaExiste(tf_cliente_id.getText());

			if (existe == true) {
				mensg.setMensage("Cliente " + tf_cliente_id.getText() + " Já existe");
				mensg.setVisible(true);
			} else {

				try {
					bd.conexao();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				cli = MontaCliente();
				cli.tratarBranco();
				boolean insert_suc = false;

				try {
					insert_suc = bd.inserirCliente(cli);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (insert_suc == true) {
					Cliente cli_refresh = new Cliente();
					setDados(cli_refresh);
					mensg.setMensage("Cliente criado com sucesso");
					mensg.setVisible(true);
				} else {
					mensg.setMensage("Não foi possível criar Cliente");
					mensg.setVisible(true);
				}
			}

		}

	}

	public void alteracao() {

		Mensagem mensg = new Mensagem();
		Boolean alter = validaAlteracao();
		if (alter == false) {

			mensg.setMensage("Nenhuma dado foi alterado");
			mensg.setVisible(true);

		} else {

			if (tf_nome.getText().equals("")) {
				mensg.setMensage("Não é permitido campo nome em branco");
				mensg.setVisible(true);
			} else {
				Cliente cli = new Cliente();
				Banco bd = new Banco();

				try {
					bd.conexao();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				cli = MontaCliente();
				cli.tratarBranco();
				boolean sucesso = false;

				try {
					sucesso = bd.updateCliente(cli);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (sucesso == true) {
					cliente = cli;
					mensg.setMensage("Cliente atualizado com sucesso");
					mensg.setVisible(true);
				} else {
					mensg.setMensage("Não foi possível atualizar Cliente");
					mensg.setVisible(true);
				}

			}

		}

	}

	public boolean validaJaExiste(String cliente_ID) {
		Cliente cli = new Cliente();
		Banco bd = new Banco();
		try {
			bd.conexao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cli = bd.buscaCliente(cliente_ID);
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
}
