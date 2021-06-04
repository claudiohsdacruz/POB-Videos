package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Cacheable(true)
@Table(name="Usuario20191370006")
public class Usuario {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String email;
	
	@Version
	private int versao;
	
	@OneToMany(cascade={ CascadeType.ALL })
	@JoinColumn(name="minha_chave")
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	public Usuario (){}
	
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

	public int getId() {
		return id;
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
