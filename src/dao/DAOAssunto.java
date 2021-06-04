/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;

//import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Assunto;


public class DAOAssunto  extends DAO<Assunto>{

	public Assunto read (Object chave) {
		try{
			String palavra = (String) chave;	
			TypedQuery<Assunto> q = manager.createQuery("select a from Assunto a where a.palavra=:p", Assunto.class);
			q.setParameter("p", palavra);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Assunto> readAll(){
		TypedQuery<Assunto> q = manager.createQuery("select a from Assunto a order by a.id", Assunto.class);
		return  q.getResultList();
	}

//	//consulta JPQL
	public  List<Assunto> readAssunto(String assunto) {
		TypedQuery<Assunto> q = manager.createQuery(
		"select a from Assunto a where a.palavra like :a order by a.id", Assunto.class);
		q.setParameter("a", "%"+assunto+"%");

		return q.getResultList();
	}

}

