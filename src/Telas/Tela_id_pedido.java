package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco.Banco;
import Banco.Cliente;
import Banco.Orders;
import Banco.Order_Details;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_id_pedido extends JFrame {

	private JPanel contentPane;
	private JTextField tf_pedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_id_pedido frame = new Tela_id_pedido();
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
	public Tela_id_pedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 522, 217);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel tl_titulo = new JLabel("Visualiza\u00E7\u00E3o de Pedido");
		tl_titulo.setFont(new Font("Swis721 BT", Font.BOLD, 16));
		tl_titulo.setBounds(129, 11, 178, 70);
		panel.add(tl_titulo);

		JLabel tl_pedido = new JLabel("Pedido ID:");
		tl_pedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_pedido.setBounds(45, 91, 78, 20);
		panel.add(tl_pedido);

		tf_pedido = new JTextField();
		tf_pedido.setColumns(10);
		tf_pedido.setBounds(121, 93, 162, 20);
		panel.add(tf_pedido);

		JButton bt_confirm = new JButton("Confirmar");
		bt_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pedido_id = tf_pedido.getText();
				Mensagem mensg = new Mensagem();

				if (pedido_id.isEmpty()) {

					mensg.setMensage("Por favor informar o ID do Pedido");
					mensg.setVisible(true);

				}else {
					
					Orders order = getPedido(pedido_id);
					
					if(order == null) {
						mensg.setMensage("Não existe pedido com o ID " +  pedido_id);
						mensg.setVisible(true);
					}else {
						Tela_pedido_info tela_pedido_info = new Tela_pedido_info();
						tela_pedido_info.setDados(order);
						tela_pedido_info.setTipo("Visualização de Pedido", 1);
						tela_pedido_info.setVisible(true);
						dispose();
					}

				}
			}
		});
		bt_confirm.setBounds(229, 163, 97, 23);
		panel.add(bt_confirm);

		JButton bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_opcao_pedido Tela_opcao_pedido = new Tela_opcao_pedido();
				Tela_opcao_pedido.setVisible(true);
				dispose();
			}
		});
		bt_voltar.setBounds(336, 163, 97, 23);
		panel.add(bt_voltar);
	}
	
	public Orders getPedido(String pedido_id) {
		Orders order = null;
		Banco bd = new Banco();
		try {
			bd.conexao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			order = bd.buscaPedido(pedido_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return order;
		
	}
}
