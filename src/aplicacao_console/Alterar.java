package aplicacao_console;

import fachada.Fachada;


public class Alterar {

	public Alterar(){
		Fachada.inicializar();
	
		try {
			Fachada.alterarUsuario("paulo@email", "paula@email");
			System.out.println("alterando paulo para paula");		
			Fachada.alterarDataCadastro(1,"10/05/2021");
			Fachada.alterarDataCadastro(2,"15/05/2021");
			Fachada.alterarDataCadastro(3,"17/05/2021");
			Fachada.alterarDataCadastro(4,"30/05/2021");
			Fachada.alterarDataCadastro(5,"01/06/2021");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

