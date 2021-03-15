package fachada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.DAO;
import dao.DAOAssunto;
import dao.DAOUsuario;
import dao.DAOVideo;
import dao.DAOVisualizacao;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

/**
 * @author claudiodacruz
 *
 */
public class Fachada {
	private static DAOAssunto daoassunto = new DAOAssunto(); 
	private static DAOUsuario daousuario = new DAOUsuario();  
	private static DAOVideo daovideo = new DAOVideo();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao(); 


	public static void inicializar(){
		System.out.println("incializando...");
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Usuario cadastrarUsuario(String email) throws  Exception{
		DAO.begin();	
		Usuario u = daousuario.read(email);
		if(u != null) {
			DAO.rollback();
			throw new Exception("usuário ja cadastrado:" + email);
		}
		u = new Usuario(email);
		daousuario.create(u);	
		DAO.commit();
		return u;
	}

	public static Video cadastrarVideo(String link, String nome, Assunto assunto) 
			throws  Exception{
		DAO.begin();	
		Video v = daovideo.read(link);
		if(v != null) {
			DAO.rollback();
			throw new Exception("video ja cadastrado:" + link);
		}

		Video v1 = new Video(link,nome,assunto);
		daovideo.create(v1);	
		DAO.commit();
		return v1;
	}

	public static void adicionarAssunto(String palavra) 
			throws  Exception{
		DAO.begin();	
		Assunto a = daoassunto.read(palavra);
		if(a != null) {
			DAO.rollback();
			throw new Exception("assunto ja cadastrado:" + palavra);
		}
		Assunto ass = new Assunto(palavra);
		daoassunto.create(ass);	
		DAO.commit();
	}


	public static Visualizacao registrarVisualizacao(String link, String email,int nota) throws Exception{
		DAO.begin();		
		Video v = daovideo.read(link);	//usando  chave primaria
		if (v==null) {
			DAO.rollback();
			throw new Exception("video inexistente:" + link);
		}
		Usuario u = daousuario.read(email);
		if (u==null) {
			DAO.rollback();
			throw new Exception("usuario inexistente:" + link);
		}
		
		Visualizacao vis = new Visualizacao(v,u,nota);
		daovisualizacao.create(vis);
		v.adicionar(vis);
		u.adicionar(vis);
		daousuario.update(u);
		daovideo.update(v);
		DAO.commit();
		return vis;
	}

	public static Visualizacao localizarVisualizacao(int id) throws Exception{
		DAO.begin();		
		Visualizacao v = daovisualizacao.read(id);	
		if (v==null) {
			DAO.rollback();	
			throw new Exception("vizualização não localizada:" + id);
		}
		
		v.toString();		
		v=daovisualizacao.update(v);     	
		DAO.commit();	
		return v;
	}

	public static void apagarVisualizacao(int id) throws Exception {
		DAO.begin();
		Visualizacao v = daovisualizacao.read(id);
		System.out.println(v);
		if (v==null) {
			DAO.rollback();	
			throw new Exception("vizualizacao inexistente:" + id);
		}
		daovisualizacao.delete(v);
		//DAO.commit();

	}

	public static List<Video> listarVideos(){
		return daovideo.readAll();
	}

	public static List<Visualizacao> listarVisualizacoes(){
		return daovisualizacao.readAll();
	}
	
	public static List<Usuario> listarUsuarios(){ 
		return daousuario.readAll(); 
	}

	public static List<Video> listarVideosPorAssunto(String assunto) throws Exception{ 
		DAO.begin();
		Assunto a = daoassunto.read(assunto);
		if (a==null) {
			DAO.rollback();
			throw new Exception("assunto não vinculado a nenhum vídeo.");
		}		
		List<Video> videos;
		videos = a.getVideos();	
		DAO.commit();
		return videos;
	}
	
	public static List<Video> listarVideosPorUsuario(String email) throws Exception{ 
		DAO.begin();
		Usuario u = daousuario.read(email);	
		if (u==null) {
			DAO.rollback();
			throw new Exception("nenhum video vinculado à: " + email);
		}
		List<Visualizacao> visualizacoes = u.getVisualizacoes();
		List<Video> videos = new ArrayList<Video>();
		for (Visualizacao v : visualizacoes) {
			videos.add(v.getVideo());
		}			   	
		DAO.commit();
		return videos;
	}
	
	public static List<Usuario> listarUsuariosPorVideo(String link) throws Exception{ 
		DAO.begin();
		Video v = daovideo.read(link);	
		if (v==null) {
			DAO.rollback();
			throw new Exception("nenhum usuario vinculado:" + link);
		}
		List<Visualizacao> visualizacoes = v.getVisualizacoes();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (Visualizacao vis : visualizacoes) {
			usuarios.add(vis.getUsuario());
		}			   	
		DAO.commit();
		return usuarios;
	}
	
	public static Usuario alterarUsuario(String email1, String email2) throws Exception {
		DAO.begin();	
		Usuario u = daousuario.read(email1);
		System.out.println(u);
		if(u == null) {
			DAO.rollback();
			throw new Exception("usuário não localizado:" + email1);
		}
		u.setEmail(email2);
		daousuario.update(u);
		DAO.commit();
		return u;
		
	}
	public static Video consultarVideo(String link) throws Exception {
		DAO.begin();
		Video v = daovideo.read(link);	
		if (v==null) {
			DAO.rollback();
			throw new Exception("video não encontrado:" + link);
		}
		DAO.commit();
		return v;
	}
	public static Visualizacao consultarVisualizacao(int id) throws Exception {
		DAO.begin();
		Visualizacao v = daovisualizacao.read(id);	
		if (v==null) {
			DAO.rollback();
			throw new Exception("visualização não encontrada:" + id);
		}
		DAO.commit();
		return v;
	}
	
	

}

