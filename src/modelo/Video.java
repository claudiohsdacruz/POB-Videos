package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Cacheable(false)
@Table(name="Video20191370006")
public class Video {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private String link;
	private String nome;
	
	@Version
	private int versao;
	
	private static int soma;
	
	private static double qtdVisualizacoes;
	private double classificacao;
	
	@Column(columnDefinition = "DATETIME")
	private LocalDate datahora = LocalDate.now();
	
	
	@ManyToMany(mappedBy="videos", cascade={ CascadeType.PERSIST,
			CascadeType.MERGE })
	private List<Assunto> assuntos = new ArrayList<>();
	
	
	@OneToMany(mappedBy="video", 
			cascade={ CascadeType.ALL}, 
			orphanRemoval = true,
			fetch=FetchType.EAGER)
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	
	public Video (){}
	
	public Video(String link, String nome) {
		this.link = link;
		this.nome = nome;
	}


	public void calcularClassificacao(int nota) {
		soma += nota;	
		qtdVisualizacoes ++;
		classificacao = soma/qtdVisualizacoes;
	}
	
	public String getLink() {
		return link;
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

	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}

	public LocalDate getDataHora() {	
		return datahora;	
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String texto = "Video [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "media=" + classificacao + ", " ;
		
//		texto+=", assuntos= " + assuntos;
//		for(Assunto a : assuntos) {
//			texto += a.getPalavra();
//		}
		return texto+ "]";
	}

	public void setDataHora(LocalDate data) {
		this.datahora = data;
		
	}

	
}
