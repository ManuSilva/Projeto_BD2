package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_opcao_pedido extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_opcao_pedido frame = new Tela_opcao_pedido();
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
	public Tela_opcao_pedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 281, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton bt_criar_pedido = new JButton("Criar Pedido");
		bt_criar_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_pedido_info tela_pedido_info = new Tela_pedido_info();
				tela_pedido_info.setTipo("Criação de Pedido", 2);
				tela_pedido_info.setVisible(true);
				dispose();
			}
		});
		bt_criar_pedido.setBounds(67, 102, 137, 23);
		panel.add(bt_criar_pedido);
		
		JButton bt_show_pedido = new JButton("Visualizar Pedido");
		bt_show_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_id_pedido tela_id_pedido = new Tela_id_pedido();
				tela_id_pedido.setVisible(true);
				dispose();
			}
		});
		bt_show_pedido.setBounds(67, 42, 137, 23);
		panel.add(bt_show_pedido);
		
		JButton bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal menu = new Menu_Principal();
				menu.setVisible(true);
				dispose();
			}
		});
		bt_voltar.setBounds(177, 159, 89, 23);
		panel.add(bt_voltar);
	}

}
