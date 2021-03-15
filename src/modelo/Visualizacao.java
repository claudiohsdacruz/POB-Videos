package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.DAOVisualizacao;
import fachada.Fachada;

public class Visualizacao {
	private int id;
	private String datahora = LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private int nota;
	private Usuario usuario;
	private Video video;
	private List<Video> videos = new ArrayList<>();
	private Object getId;
	
	public Visualizacao(Video video, Usuario usuario, int nota) {
		this.id = bucarMaxId() + 1;
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
		video.calcularClassificacao();
	}

	private int bucarMaxId() {
		List<Visualizacao> lista= Fachada.listarVisualizacoes();
		return lista.size();
	}
	
	public int getId(){
		return id;
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
				", nota=" + nota +
				"\n usuario=" + usuario.getEmail() + ", video=" + video.getNome() + "]";
	}

	
	
	

}
