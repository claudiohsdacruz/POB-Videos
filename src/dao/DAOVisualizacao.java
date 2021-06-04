/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Visualizacao;

public class DAOVisualizacao  extends DAO<Visualizacao>{

	public Visualizacao read (Object chave){
		try{
			int id = (Integer) chave;
			TypedQuery<Visualizacao> q = manager.createQuery("select v from Visualizacao v where v.id=:i", Visualizacao.class);
			q.setParameter("i", id);
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
	public List<Visualizacao> readIdadeVisualizacoes(int dias) {
		// definindo a data de retorno em milisegundos
		long intervalo = dias * 86400000;
		Date hoje = new Date();
		long hojeMillis = hoje.getTime();
		long diferenca = hojeMillis - intervalo;

		// transformando data de milisegundo para o formato Date
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTimeInMillis(diferenca);
	    Date data = calendar.getTime();
	    
	   
	    LocalDate localDate = data.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
	    System.out.println(localDate);
		
		TypedQuery<Visualizacao> q = manager.createQuery
				("select v from Visualizacao v where v.datahora >=:k",Visualizacao.class);
		q.setParameter("k", localDate);
		return q.getResultList();
	}

}

