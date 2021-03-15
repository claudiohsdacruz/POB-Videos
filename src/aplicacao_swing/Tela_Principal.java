package aplicacao_swing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class Tela_Principal {

	private JFrame frame;
	private JMenu mnVisualizacao;
	private JMenu mnVideo;
	private JMenuItem mntmCadastrarVideo;
	private JMenuItem mntmListarVideo;
	private JMenuItem mntmRegistrarVisualizacao;
	private JMenuItem mntmListarVisualizacao;
	private JLabel label;
	private ImageIcon imagem;


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
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				
				Fachada.inicializar();
				
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				label.setIcon(imagem);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(frame, "banco fechado !");
			}
		});
		frame.setTitle("Vídeos");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Inicializando...");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		imagem = new ImageIcon(getClass().getResource("/imagens/imagem.jpeg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));//		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(false);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnVideo = new JMenu("Video");
		menuBar.add(mnVideo);

		mntmCadastrarVideo = new JMenuItem("Cadastrar");
		mntmCadastrarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Cadastro_Video tela = new Tela_Cadastro_Video();
			}
		});
		mnVideo.add(mntmCadastrarVideo);
		
		mntmListarVideo = new JMenuItem("Listar");
		mntmListarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Listagem_Video tela = new Tela_Listagem_Video();
			}
		});
		mnVideo.add(mntmListarVideo);

		//-----------------------------------------------------------------
		mnVisualizacao = new JMenu("Visualizacão");
		menuBar.add(mnVisualizacao);
		
		mntmRegistrarVisualizacao = new JMenuItem("Registrar");
		mntmRegistrarVisualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Registro_Visualizacao tela = new Tela_Registro_Visualizacao();
			}
		});
		mnVisualizacao.add(mntmRegistrarVisualizacao);
		
		
		mntmListarVisualizacao = new JMenuItem("Listar");
		mntmListarVisualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Listagem_Visualizacao tela = new Tela_Listagem_Visualizacao();
			}
		});
		mnVisualizacao.add(mntmListarVisualizacao);
		
	}
}
