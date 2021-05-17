package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco.Banco;
import Banco.Relatorio;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Tela_informar_relatorio extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Primeiro_nome;
	private JTextField tf_Segundo_nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_informar_relatorio frame = new Tela_informar_relatorio();
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
	public Tela_informar_relatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel frame = new JPanel();
		frame.setBounds(5, 5, 509, 226);
		contentPane.add(frame);
		frame.setLayout(null);

		JLabel lblNewLabel = new JLabel("Relat\u00F3rio dos produtos vendidos por funcion\u00E1rio");
		lblNewLabel.setFont(new Font("Swis721 BT", Font.BOLD, 16));
		lblNewLabel.setBounds(68, 0, 407, 83);
		frame.add(lblNewLabel);

		tf_Primeiro_nome = new JTextField();
		tf_Primeiro_nome.setBounds(179, 96, 162, 20);
		frame.add(tf_Primeiro_nome);
		tf_Primeiro_nome.setColumns(10);

		JLabel tl_primeiro_nome = new JLabel("Primeiro Nome:");
		tl_primeiro_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_primeiro_nome.setBounds(78, 94, 103, 20);
		frame.add(tl_primeiro_nome);

		tf_Segundo_nome = new JTextField();
		tf_Segundo_nome.setColumns(10);
		tf_Segundo_nome.setBounds(179, 143, 162, 20);
		frame.add(tf_Segundo_nome);

		JLabel tl_segundo_nome = new JLabel("Segundo Nome:");
		tl_segundo_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tl_segundo_nome.setBounds(78, 141, 103, 20);
		frame.add(tl_segundo_nome);

		JButton bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal menu = new Menu_Principal();
				menu.setVisible(true);
				dispose();
			}
		});
		bt_voltar.setBounds(392, 181, 97, 23);
		frame.add(bt_voltar);

		JButton bt_confirm = new JButton("Confirmar");
		bt_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mensagem mensg = new Mensagem();
				String first_name = tf_Primeiro_nome.getText();
				String second_name = tf_Segundo_nome.getText();
				if (first_name.isEmpty()) {

					mensg.setMensage("Por favor informar o Primeiro Nome");
					mensg.setVisible(true);

				} else if (second_name.isEmpty()) {

					mensg.setMensage("Por favor informar o Segundo Nome");
					mensg.setVisible(true);

				} else {

					boolean existe = validaExisteEmpregado(first_name, second_name);

					if (existe == false) {
						mensg.setMensage("Esse Funcionário não está cadastrado");
						mensg.setVisible(true);
					} else {

						Tela_relatorio tela_relatorio = new Tela_relatorio();
						Banco bd = new Banco();
						ArrayList<Relatorio> rel = new ArrayList<Relatorio>();

						try {
							bd.conexao();
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						try {
							rel = bd.execRelatorio(first_name, second_name);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (rel == null) {
							mensg.setMensage("Nenhum dado encontrado");
							mensg.setVisible(true);
						} else {
							tela_relatorio.montarRelatorio(rel);
							tela_relatorio.setVisible(true);
							dispose();
						}
					}

				}
			}
		});
		bt_confirm.setBounds(285, 181, 97, 23);
		frame.add(bt_confirm);
	}

	public boolean validaExisteEmpregado(String PrimNome, String LastNome) {
		boolean existe = false;
		Banco bd = new Banco();

		try {
			bd.conexao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			existe = bd.existeEmpregadoNome(PrimNome, LastNome);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return existe;

	}
}
