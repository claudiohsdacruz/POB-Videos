package aplicacao_console;

import fachada.Fachada;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		try {
			Fachada.alterarUsuario("paulo@email", "paula@email");
			System.out.println("alterando paulo para paula");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

