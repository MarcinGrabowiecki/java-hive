package javahive.infrastruktura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Finder{
	
	@PersistenceContext
	public EntityManager entityManager;
	
	public Finder(){}
	
	public <T> List<T> findAll(Class <T> c){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(c);
		Root<T> entityRoot = criteria.from(c);
		criteria.select(entityRoot);
		//criteria.where( builder.equal( personRoot.get( Student.eyeColor ), "brown" ) );
		List<T> entities = entityManager.createQuery( criteria ).getResultList();
		return entities;
	}
}
