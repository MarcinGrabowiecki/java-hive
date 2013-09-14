package javafxapplication2;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javahive.domain.Ocena;
import javahive.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.Yaml;

import com.fixy.Fixy;
import com.fixy.JpaFixyBuilder;
import com.google.common.base.Stopwatch;


@Component
public class SpringClass {
	@PersistenceContext
	public EntityManager entityManager;
	
	@Transactional
	public List<Student> test(){
		
		Stopwatch watch = new Stopwatch().start();
		Fixy fixtures = new JpaFixyBuilder(entityManager).mergeEntities().withDefaultPackage("javafxapplication2").useFieldAccess().build();
		fixtures.load("owners-fieldaccess.yaml");
		fixtures.load("owners.yaml");
		fixtures.load("javafxapplication2/Studenci1.yaml");
		//fixtures.load(new String[]{""});

				
		Query query = entityManager.createQuery("SELECT s from Student as s");		
		System.out.println(query.getResultList().size());
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> personRoot = criteria.from(Student.class);
		criteria.select( personRoot );
		//criteria.where( builder.equal( personRoot.get( Student.eyeColor ), "brown" ) );
		List<Student> people = entityManager.createQuery( criteria ).getResultList();
		return people;
	}
}
