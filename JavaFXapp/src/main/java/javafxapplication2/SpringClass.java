package javafxapplication2;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javahive.domain.Finder;
import javahive.domain.Ocena;
import javahive.domain.Przedmiot;
import javahive.domain.Student;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.Yaml;

import com.fixy.Fixy;
import com.fixy.JpaFixyBuilder;
import com.google.common.base.Stopwatch;


@Component
public class SpringClass {
	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	Finder finder;
	
	@Transactional
	public List<Student> test(){
		
		Stopwatch watch = new Stopwatch().start();
		Fixy fixtures = new JpaFixyBuilder(entityManager).withDefaultPackage("javafxapplication2").useFieldAccess().build();
		//fixtures.load("pets.yaml");
		//fixtures.load("owners-fieldaccess.yaml");
		//fixtures.load("owners.yaml");
		//fixtures.load(new String[]{"javafxapplication2/Studenci.yaml","javafxapplication2/Przedmioty.yaml","javafxapplication2/Oceny.yaml"});
		
		//fixtures.load(new String[]{"pet_types.yaml","pets.yaml"});
		//fixtures.load("pets.yaml");
		
		fixtures.load("javafxapplication2/Studenci.yaml","javafxapplication2/Przedmioty.yaml","javafxapplication2/Oceny.yaml");

		System.out.printf("Załadowane dane w %d sekund\n\n",watch.stop().elapsedTime(TimeUnit.SECONDS));

		System.out.println(finder.findAll(Przedmiot.class).size());
		
		return finder.findAll(Student.class);
		}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}
}
