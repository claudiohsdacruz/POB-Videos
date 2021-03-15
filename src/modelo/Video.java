package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private String link;
	private String nome;
	private double classificacao;
	private String datahora = LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private List<Assunto> assuntos = new ArrayList<>();
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	
	public Video(String link, String nome, Assunto assunto) {
		this.link = link;
		this.nome = nome;
		assuntos.add(assunto);
		assunto.adicionar(this);
	}

	public void calcularClassificacao() {
		double nota = 0;
		int n = 0;
		for (Visualizacao v : visualizacoes) {;
			nota += v.getNota();
			System.out.println(nota);
			n ++;
		}
		this.classificacao = nota/n;
	}
	
	public String getNome() {
		return nome;
	}
	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public double getClassificacao() {
		return classificacao;
	}
	
	public List<Visualizacao> getVisualizacoes() {
		return visualizacoes;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}


	@Override
	public String toString() {
		String texto = "Video [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "media=" + classificacao ;
		
		texto+=", assuntos=";
		for(Assunto a : assuntos) {
			texto += a.getPalavra();
		}
//		texto+="\n visualizacoes=";
//		for(Visualizacao vis : visualizacoes) {
//			texto += vis;
//		}
		return texto;
	}

	
}
