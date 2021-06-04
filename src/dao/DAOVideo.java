/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Video;

public class DAOVideo  extends DAO<Video>{
	
	public Video read (Object chave){
		try{
			String link = (String) chave;
			TypedQuery<Video> q = manager.createQuery("select v from Video v where v.link =:l ",Video.class);
			q.setParameter("l", link);
			
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
//
//	//--------------------------------------------
//	//  consultas
//	//--------------------------------------------
//
	public List<Video> readQtdVisualizacoes (int vis){		
		TypedQuery<Video> q = manager.createQuery
				("select v from Video v where SIZE(v.visualizacoes) =:k",Video.class);
		q.setParameter("k", vis);
		return q.getResultList();
	}
}
