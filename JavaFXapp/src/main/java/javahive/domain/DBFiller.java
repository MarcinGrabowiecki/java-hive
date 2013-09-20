package javahive.domain;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fixy.Fixy;
import com.fixy.JpaFixyBuilder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;


@Component
public class DBFiller {

	@PersistenceContext
	private EntityManager entityManager;

	@Inject Finder finder;
	
	@Transactional
	public void fill(){
		Fixy fixtures = new JpaFixyBuilder(entityManager).withDefaultPackage("javafxapplication2").useFieldAccess().build();
		fixtures.load("javafxapplication2/Studenci.yaml","javafxapplication2/Przedmioty.yaml","javafxapplication2/Oceny.yaml");
		System.out.printf("załadowano %d studentów\n",finder.findAll(Student.class).size());
	}
}
