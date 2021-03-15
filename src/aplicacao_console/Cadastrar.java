package aplicacao_console;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Usuario;

public class Cadastrar {

	private static final Assunto assunto = new Assunto("Java");

	public Cadastrar(){
		Fachada.inicializar();
		System.out.println("cadastrando usuário...");
		try {
			Fachada.cadastrarUsuario("joao@email");
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarUsuario("paulo@email");
			System.out.println("cadastrando usuário");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarUsuario("jose@email");
			System.out.println("cadastrando usuário");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarUsuario("maria@email");
			System.out.println("cadastrando usuário");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarVideo("https://youtu.be/sTX0UEplF54", "Historia do Java", assunto);
			System.out.println("cadastrando Vídeo");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarVideo("https://youtu.be/v_ZCtgwbS3o", "Como Funciona o Java", assunto);
			System.out.println("cadastrando Vídeo");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarVideo("https://youtu.be/yWU5bm_pZzY", "Instalando o JDK", assunto);
			System.out.println("cadastrando Vídeo");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarVideo("https://youtu.be/cYMruFKwqf0", "Introdução ao Swing e JavaFX", assunto);
			System.out.println("cadastrando Vídeo");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/sTX0UEplF54", "jose@email", 5);
			System.out.println("registrando visualizacão");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/sTX0UEplF54", "maria@email", 4);
			System.out.println("registrando visualizacão");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/sTX0UEplF54", "joao@email", 3);
			System.out.println("registrando visualizacão");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/v_ZCtgwbS3o", "jose@email", 5);
			System.out.println("registrando visualizacão");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/v_ZCtgwbS3o", "joao@email", 4);
			System.out.println("registrando visualizacão");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}

