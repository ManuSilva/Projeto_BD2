package Projeto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal window = new Tela_Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela_Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 285, 237);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 279, 207);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton bt_op_cliente = new JButton("Fun\u00E7\u00E3o Cliente");
		bt_op_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_op_cliente.setBounds(68, 34, 140, 23);
		panel.add(bt_op_cliente);
		
		JButton bt_op_pedido = new JButton("Fun\u00E7\u00E3o Pedido\r\n");
		bt_op_pedido.setBounds(68, 87, 140, 23);
		panel.add(bt_op_pedido);
		
		JButton bt_op_relatorio = new JButton("Relat\u00F3rio");
		bt_op_relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_op_relatorio.setBounds(68, 140, 140, 23);
		panel.add(bt_op_relatorio);
	}
}
