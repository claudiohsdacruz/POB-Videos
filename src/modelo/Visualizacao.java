package modelo;
import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import dao.TriggerListener;


@Entity
@Cacheable(true)
@EntityListeners(TriggerListener.class)
@Table(name="Visualizacao20191370006")
public class Visualizacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "DATETIME")
	private LocalDate datahora = LocalDate.now();
	
	@ManyToOne()
	private Usuario usuario;
	
	@Transient
	private int idade;
	
	private int nota;
	
	@Version
	private int versao;
	
	@ManyToOne(cascade={ CascadeType.PERSIST,
			CascadeType.MERGE } )
	private Video video;
	
	public Visualizacao() {}
	
	public Visualizacao(Video video, Usuario usuario, int nota) {
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
		video.calcularClassificacao(nota);
	}


	public int getId(){
		return id;
	}
	
	public LocalDate getDataHora() {
		return datahora;
	}

	public void setDataHora(LocalDate datahora) {
		this.datahora = datahora;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public Video getVideo() {
		return video;
	}

	public int getNota() {
		return nota;
	}
	
	@Override
	public String toString() {
		return "Visualizacao [id=" + id + 
				", datahora=" + datahora + 
				", nota=" + nota + ", idade=" + idade + " dias" +
				"\n usuario=" + usuario.getEmail() + ", video=" + video.getNome() + "]";
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
