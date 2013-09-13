package javafxapplication2;

import java.util.List;

import javahive.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.fixy.Fixy;
import com.fixy.JPAFixy;

@Component
public class SpringClass {
	@PersistenceContext
	public EntityManager entityManager;
		
	public void test(){

		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		
		new JPAFixy();
		//Fixy fixtures = new JpaFixyBuilder(entityManager).useFieldAccess().build();
		//fixtures.load(null);
		t.commit();
		entityManager.close();

		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> personRoot = criteria.from(Student.class);
		criteria.select( personRoot );
		//criteria.where( builder.equal( personRoot.get( Student.eyeColor ), "brown" ) );
		List<Student> people = entityManager.createQuery( criteria ).getResultList();
		for(Student s:people){
			System.out.println(s);
		}
	}
}
