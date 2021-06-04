package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Cacheable(true)
@Table(name="Assunto20191370006")
public class Assunto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String palavra;
	
	@Version
	private int versao;
	
	
	@ManyToMany(cascade={ 
			CascadeType.MERGE })
	private List<Video> videos = new ArrayList<>();
	
	public Assunto (){}
	
	public Assunto(Video video, String palavra) {
		this.palavra = palavra;		
		this.videos.add(video); 
	}

	public String getPalavra() {
		return palavra;
	}
	
	public List<Video> getVideos() {
		return videos;
	}

	public void adicionar(Video v) {
		videos.add(v);
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String texto = "Assunto [palavra=" + palavra;
		texto+=", vídeos= "+ videos;
//		for(Video v : videos) {
//			texto += v.getNome();
//		}
		return texto+ "]";
	}
	
	
	
}
