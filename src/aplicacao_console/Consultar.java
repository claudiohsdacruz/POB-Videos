package aplicacao_console;

import java.util.List;


import fachada.Fachada;
import modelo.Assunto;
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
			
			//Consultas JPQL
			System.out.println("\nListagem de assuntos por parte:");
			List<Assunto> assuntos = Fachada.listarAssuntos("J");	
			for(Assunto a : assuntos)	
				System.out.println(a);
			
			System.out.println("\nListagem de vídeos por número de visualizacoes:");
			List<Video> videos = Fachada.listarVideoPorVisualizacoes(0);	
			for(Video v : videos)	
				System.out.println(v);
			
			System.out.println("\nListagem de visualizacoes por tempo decorrido.");
			List<Visualizacao> vis = Fachada.listarVisualizacoesPorIdade(15);	
			for(Visualizacao v : vis)	
				System.out.println(v);
			
			System.out.println("\nFim da Listagem.");

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


