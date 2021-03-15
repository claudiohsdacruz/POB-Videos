package aplicacao_console;

import fachada.Fachada;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Consultar {

	public Consultar(){
		try {
			Fachada.inicializar();

			System.out.println("Listagem de videos por assunto:");
			for(Video va : Fachada.listarVideosPorAssunto("Java"))		
				System.out.println(va);			

			System.out.println("\nListagem de videos por usuário:");
			for(Video vu : Fachada.listarVideosPorUsuario("joao@email"))	
				System.out.println(vu);
			
			System.out.println("\nListagem de usuários por vídeo:");
			for(Usuario u : Fachada.listarUsuariosPorVideo("https://youtu.be/sTX0UEplF54"))	
				System.out.println(u);
			System.out.println("Fim da Listagem.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
	}


	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}


