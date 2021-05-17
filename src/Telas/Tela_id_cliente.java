package Telas;

import java.awt.BorderLayout;
import Banco.Banco;
import Banco.Cliente;
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

public class Tela_id_cliente extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cliente;
	private JLabel tl_titulo;
	private int tipo ;// 1 - Visualização, 2 - Inserção, 3 - Atualização, 4 - Remorção

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_id_cliente frame = new Tela_id_cliente();
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
	public Tela_id_cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 443, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tl_titulo = new JLabel("Visualiza\u00E7\u00E3o de Cliente");
		tl_titulo.setFont(new Font("Swis721 BT", Font.BOLD, 16));
		tl_titulo.setBounds(121, 2, 178, 83);
		panel.add(tl_titulo);
		
		tf_cliente = new JTextField();
		tf_cliente.setColumns(10);
		tf_cliente.setBounds(121, 96, 162, 20);
		panel.add(tf_cliente);
		
		JLabel tl_cliente = new JLabel("Cliente ID:");
		tl_cliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_cliente.setBounds(45, 94, 78, 20);
		panel.add(tl_cliente);
		
		JButton bt_confirm = new JButton("Confirmar");
		bt_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cliente_ID = tf_cliente.getText();
				Mensagem mensg = new Mensagem();

				if(cliente_ID.isEmpty()) {
					
					mensg.setMensage("Por favor informar o ID do Cliente");
					mensg.setVisible(true);

				}else {
					Cliente cli = getCliente(cliente_ID);
					
					if(cli == null) {
						mensg.setMensage("Não existe cliente com o ID " +  cliente_ID);
						mensg.setVisible(true);
					}else {
						
						Tela_cliente_info tela_cliente_info = new Tela_cliente_info();
							
						if(tipo == 1) {
							tela_cliente_info.setDados(cli);
							tela_cliente_info.setTipo("Visualização de Cliente",tipo);
							tela_cliente_info.setVisible(true);
							dispose();
						}else if(tipo == 3) {
							tela_cliente_info.setDados(cli);
							tela_cliente_info.setTipo("Atualização de Cliente",tipo);
							tela_cliente_info.setVisible(true);
							dispose();
						}else if (tipo == 4) {
							boolean sucess = deleteCliente(cliente_ID);
							if (sucess == true) {
								mensg.setMensage("Cliente removido com sucesso");
								mensg.setVisible(true);
							} else {
								mensg.setMensage("Não foi possível remover Cliente");
								mensg.setVisible(true);
							}
						}

					}
					
				}
			}
		});
		bt_confirm.setBounds(229, 166, 97, 23);
		panel.add(bt_confirm);
		
		JButton bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_opcao_cliente tela_opcao_cliente = new Tela_opcao_cliente();
				tela_opcao_cliente.setVisible(true);
				dispose();
			}
		});
		bt_voltar.setBounds(336, 166, 97, 23);
		panel.add(bt_voltar);
	}
	
	public void setTipo(String titulo, int tipo) {
		
		this.tipo = tipo;
		tl_titulo.setText(titulo);
	}
	
	public Cliente getCliente(String cliente_id) {
		Cliente cli = null;
		Banco bd = new Banco();
		try {
			bd.conexao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cli = bd.buscaCliente(cliente_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return cli;
		
	}

	public boolean deleteCliente(String cliente_id) {
		boolean sucess = false;
		Banco bd = new Banco();
		try {
			bd.conexao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			sucess = bd.DeleteCliente(cliente_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return sucess ;
	}
}
