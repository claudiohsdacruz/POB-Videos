package aplicacao_console;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Listar {

	public Listar(){
		try {
			Fachada.inicializar();
			System.out.println("Listagem de usuarios:");
			for(Usuario u : Fachada.listarUsuarios() )		
				System.out.println(u);
			
			System.out.println("\nListagem de assuntos:");
			for(Assunto a : Fachada.listarAssuntos())		
				System.out.println(a);

			System.out.println("\nListagem de vídeos:");
			for(Video v : Fachada.listarVideos())	
				System.out.println(v);
			
			System.out.println("\nListagem de visualizações:");
			for(Visualizacao vis : Fachada.listarVisualizacoes()) 
				System.out.println(vis);
				

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}