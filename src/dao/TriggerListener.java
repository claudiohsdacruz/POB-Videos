package dao;

import java.time.LocalDate;

/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.time.temporal.ChronoUnit;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;

import modelo.Visualizacao;

public class TriggerListener{  // usada pelas classes Pessoa e Telefone

	@PrePersist
	public void exibirmsg1(Object obj) throws Exception {
		System.out.println(" @PrePersist... " + obj.getClass().getSimpleName());
	}

	@PostPersist
	public void exibirmsg2(Object obj) {
		System.out.println(" @PostPersist... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao v = (Visualizacao)obj;
			System.out.println("   idade =" +  v.getIdade() );
			int idade = (int) calcularIdade( v );
			v.setIdade(idade);
			System.out.println("   idade calculada=" +  idade );
		}
	}

	@PostUpdate
	public void exibirmsg3(Object obj) {
		System.out.println(" @PostPersist... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao v = (Visualizacao)obj;
			System.out.println("   idade =" +  v.getIdade() );
			int idade = (int) calcularIdade( v );
			v.setIdade(idade);
			System.out.println("   idade calculada=" +  idade );
		}
	}
	
	@PostLoad
	public void exibirmsg4(Object obj) {
		System.out.println(" @PostPersist... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao v = (Visualizacao)obj;
			System.out.println("   idade =" +v.getIdade() );
			int idade = (int) calcularIdade( v );
			v.setIdade(idade);
			System.out.println("   idade calculada=" +  idade );
		}
	}	

	@PostRemove
	public void exibirmsg5(Object obj) {
		System.out.println(" @PostRemove.... " + obj.getClass().getSimpleName());
	}

	//============================================================
	
	public long calcularIdade(Visualizacao v) {
		LocalDate hoje = LocalDate.now();
		long diferenca = ChronoUnit.DAYS.between(v.getDataHora(), hoje);
		int idade = (int)diferenca;
		return idade;
	}

}
