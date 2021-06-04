package aplicacao_console;

import fachada.Fachada;
import modelo.Video;

public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
		
		System.out.println("cadastrando usuários...");
		try {
			Fachada.cadastrarUsuario("joao@email");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarUsuario("paulo@email");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarUsuario("jose@email");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.cadastrarUsuario("maria@email");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("cadastrando vídeos...");
		try {		
			Video v = Fachada.cadastrarVideo("https://youtu.be/sTX0UEplF54", "Historia do Java");
			Fachada.adicionarAssunto(v,"Java");
		} 
		catch (Exception e) {	
			System.out.println(e.getMessage());
		}

		try {
			Video v = Fachada.cadastrarVideo("https://youtu.be/v_ZCtgwbS3o", "Como Funciona o Java");
			Fachada.adicionarAssunto(v,"Java");
		} 
		catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		
		try {
			Video v = Fachada.cadastrarVideo("https://youtu.be/yWU5bm_pZzY", "Instalando o JDK");
			Fachada.adicionarAssunto(v,"JDK");
		} 
		catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		try {
			Video v = Fachada.cadastrarVideo("https://youtu.be/cYMruFKwqf0", "Introdução ao Swing e JavaFX");
			Fachada.adicionarAssunto(v,"Swing");
		} 
		catch (Exception e) {			
			System.out.println(e.getMessage());
		}
		
		System.out.println("registrando visualizacão...");
		try {
			Fachada.registrarVisualizacao("https://youtu.be/sTX0UEplF54", "jose@email", 5);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/sTX0UEplF54", "maria@email", 4);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/sTX0UEplF54", "joao@email", 3);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/yWU5bm_pZzY", "jose@email", 5);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.registrarVisualizacao("https://youtu.be/yWU5bm_pZzY", "joao@email", 4);
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

