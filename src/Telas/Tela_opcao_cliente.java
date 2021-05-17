package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_opcao_cliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_opcao_cliente frame = new Tela_opcao_cliente();
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
	public Tela_opcao_cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 426, 258);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton bt_insert = new JButton("Inser\u00E7\u00E3o ");
		bt_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_cliente_info tela_cliente_info = new Tela_cliente_info();
				tela_cliente_info.setTipo("Inserção de Cliente", 2);
				tela_cliente_info.setVisible(true);
				dispose();
			}
		});
		bt_insert.setBounds(151, 70, 110, 23);
		panel.add(bt_insert);

		JButton bt_visualizar = new JButton("Visualiza\u00E7\u00E3o ");
		bt_visualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_id_cliente tela_id_cliente = new Tela_id_cliente();
				tela_id_cliente.setTipo("Visualização de Cliente", 1);
				tela_id_cliente.setVisible(true);
				dispose();
			}
		});
		bt_visualizar.setBounds(151, 22, 110, 23);
		panel.add(bt_visualizar);

		JButton bt_remove = new JButton("Remor\u00E7\u00E3o");
		bt_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_id_cliente tela_id_cliente = new Tela_id_cliente();
				tela_id_cliente.setTipo("Remoção de Cliente", 4);
				tela_id_cliente.setVisible(true);
				dispose();
			}
		});
		bt_remove.setBounds(151, 114, 110, 23);
		panel.add(bt_remove);

		JButton bt_att = new JButton("Atualiza\u00E7\u00E3o");
		bt_att.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_id_cliente tela_id_cliente = new Tela_id_cliente();
				tela_id_cliente.setTipo("Atualização de Cliente", 3);
				tela_id_cliente.setVisible(true);
				dispose();
			}
		});
		bt_att.setBounds(151, 160, 110, 23);
		panel.add(bt_att);

		JButton bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal menu = new Menu_Principal();
				menu.setVisible(true);
				dispose();
			}
		});
		bt_voltar.setBounds(327, 224, 89, 23);
		panel.add(bt_voltar);
	}

}
