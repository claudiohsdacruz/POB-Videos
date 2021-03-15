 package aplicacao_console;

import fachada.Fachada;


public class Apagar {

	public Apagar(){
		Fachada.inicializar();
		try {
			Fachada.apagarVisualizacao(1);
			System.out.println("apagando visualizacao");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Apagar();
	}
}

