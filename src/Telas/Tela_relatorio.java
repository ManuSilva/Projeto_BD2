package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Banco.Relatorio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_relatorio extends JFrame {

	private JPanel contentPane;
	private JTable table_relatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_relatorio frame = new Tela_relatorio();
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
	public Tela_relatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tl_titulo = new JLabel("Relat\u00F3rio dos produtos vendidos por funcion\u00E1rio");
		tl_titulo.setFont(new Font("Swis721 BT", Font.BOLD, 16));
		tl_titulo.setBounds(181, 0, 407, 83);
		contentPane.add(tl_titulo);
		
		JButton bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_informar_relatorio tela_informar_relatorio = new Tela_informar_relatorio ();
				tela_informar_relatorio.setVisible(true);
				dispose();
			}
		});
		bt_voltar.setBounds(647, 401, 97, 23);
		contentPane.add(bt_voltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 77, 519, 301);
		contentPane.add(scrollPane);
		
		table_relatorio = new JTable();
		scrollPane.setViewportView(table_relatorio);
	}
	
	public void montarRelatorio(ArrayList<Relatorio> rel) {

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Produto");
		modelo.addColumn("Quantidade");
		
		for (int i = 0; i < rel.size(); i++) {
			Relatorio o_rel = new Relatorio();
			o_rel = rel.get(i);
			modelo.addRow(new Object[] { o_rel.getProduto(), o_rel.getQty().toString() });
		}


		table_relatorio.setModel(modelo);


		table_relatorio.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_relatorio.getColumnModel().getColumn(1).setPreferredWidth(80);


		
	}

}
