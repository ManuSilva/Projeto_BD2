package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Mensagem extends JFrame {

	private JPanel contentPane;
	private JLabel tx_mensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mensagem frame = new Mensagem();
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
	public Mensagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 332, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 303, 171);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tx_mensagem = new JLabel("texte");
		tx_mensagem.setBounds(37, 42, 238, 68);
		panel.add(tx_mensagem);
	}
	
	public void setMensage(String mesg) {
		tx_mensagem.setText(mesg);
		
	}

}
