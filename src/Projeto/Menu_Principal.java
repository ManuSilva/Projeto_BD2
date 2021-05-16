package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
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
	public Menu_Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 281, 179);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton bt_op_pedido = new JButton("Fun\u00E7\u00E3o Pedido\r\n");
		bt_op_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_opcao_pedido tela_opcao_pedido = new Tela_opcao_pedido();
				tela_opcao_pedido.setVisible(true);
				dispose();
				
			}
		});
		bt_op_pedido.setBounds(84, 76, 124, 23);
		panel.add(bt_op_pedido);
		
		JButton bt_op_relatorio = new JButton("Relat\u00F3rio");
		bt_op_relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_informar_relatorio tela_informar_relatorio = new Tela_informar_relatorio ();
				tela_informar_relatorio.setVisible(true);
				dispose();
			}
		});
		bt_op_relatorio.setBounds(84, 121, 124, 23);
		panel.add(bt_op_relatorio);
		
		JButton bt_op_cliente = new JButton("Fun\u00E7\u00E3o Cliente");
		bt_op_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_opcao_cliente tela_opcao_cliente = new Tela_opcao_cliente();
				tela_opcao_cliente.setVisible(true);
				dispose();
			}
		});
		bt_op_cliente.setBounds(82, 31, 126, 23);
		panel.add(bt_op_cliente);
	}
}
