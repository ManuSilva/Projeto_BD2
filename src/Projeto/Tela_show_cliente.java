package Projeto;

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
import java.awt.event.ActionEvent;

public class Tela_show_cliente extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_show_cliente frame = new Tela_show_cliente();
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
	public Tela_show_cliente() {
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
		
		JLabel lblVisualizaoDeCliente = new JLabel("Visualiza\u00E7\u00E3o de Cliente");
		lblVisualizaoDeCliente.setFont(new Font("Swis721 BT", Font.BOLD, 16));
		lblVisualizaoDeCliente.setBounds(121, 2, 178, 83);
		panel.add(lblVisualizaoDeCliente);
		
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

				if(cliente_ID.isEmpty()) {
					Mensagem mensg = new Mensagem();
					mensg.setMensage("Por favor informar o ID do Cliente");
					mensg.setVisible(true);

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

}
