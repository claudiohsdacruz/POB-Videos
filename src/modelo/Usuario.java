package modelo;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String email;
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	public Usuario(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Visualizacao> getVisualizacoes() {
		return visualizacoes;
	}
	
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}

	@Override
	public String toString() {
		String texto =  "Usuario [email=" + email + "]";
		
//		texto+="\n visualizacoes=";
//		for(Visualizacao vis : visualizacoes) {
//			texto += vis;
//		}
		return texto;
	}

	
	
	
}
