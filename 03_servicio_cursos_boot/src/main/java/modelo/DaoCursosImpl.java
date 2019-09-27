package modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entidades.Curso;
@Repository
public class DaoCursosImpl implements DaoCursos {
	@PersistenceContext()
	EntityManager em;
	@Transactional
	@Override
	public void altaCurso(Curso c) {
		em.persist(c);

	}
	@Transactional
	@Override
	public void actualizarCurso(Curso c) {
		if(em.find(Curso.class,c.getIdCurso())!=null) {
			em.merge(c);
		}
		

	}
	@Transactional
	@Override
	public void eliminarCurso(int idCurso) {
		Curso curso=em.find(Curso.class, idCurso);
		if(curso!=null) {
			em.remove(curso);
		}

	}

	@Override
	public Curso buscarCurso(int idCurso) {
		
		return em.find(Curso.class, idCurso);
	}

	@Override
	public List<Curso> recuperarTodosCursos() {
		String jpql="Select c From Curso c";
		Query query=em.createQuery(jpql);
		return (List<Curso>)query.getResultList();
	}

}
