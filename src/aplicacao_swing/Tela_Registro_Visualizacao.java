package aplicacao_swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fachada.Fachada;
import modelo.Assunto;

public class Tela_Registro_Visualizacao {
	private JFrame frame;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastrar window = new TelaCadastrar();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Tela_Registro_Visualizacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Registro");
		frame.setBounds(100, 100, 263, 211);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("video:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 26, 71, 14);
		frame.getContentPane().add(label);
		
		label = new JLabel("usuario:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 49, 71, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("nota:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 77, 71, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 157, 227, 14);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(91, 23, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 51, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 79, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_1.setColumns(10);
		
		button = new JButton("Registrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String link = textField.getText();
					String usuario = textField_1.getText();
					int nota = Integer.parseInt(textField_2.getText());
					Fachada.registrarVisualizacao(link,usuario,nota);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					label_2.setText("registro realizado");
				}
				catch(Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});
		button.setBounds(69, 117, 108, 23);
		frame.getContentPane().add(button);
		
		
		frame.setVisible(true);
	}
}
