package aplicacao_swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Video;
import modelo.Visualizacao;

//import modelo.Telefone;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Tela_Listagem_Visualizacao {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnListarPessoasE;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaListar window = new TelaListar();
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
	public Tela_Listagem_Visualizacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Listar Visualizações");
		frame.setBounds(100, 100, 505, 323);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 33, 409, 116);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.YELLOW);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Video", "Usuario", "Nota"}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		btnListarPessoasE = new JButton("Listar Visualizações");
		btnListarPessoasE.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarPessoasE.setHorizontalAlignment(SwingConstants.LEFT);
		btnListarPessoasE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Video");
					model.addColumn("Usuario");
					model.addColumn("Nota");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);
					
					List<Visualizacao> lista = Fachada.listarVisualizacoes();
					for(Visualizacao v : lista)
//						for(Video v : vis.getVideos())
						model.addRow(new Object[]{ v.getVideo().getNome(),v.getUsuario(), v.getNota() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frame,erro.getMessage());
				}
			}
		});
		btnListarPessoasE.setBounds(44, 170, 135, 23);
		frame.getContentPane().add(btnListarPessoasE);

		frame.setVisible(true);
	}
}