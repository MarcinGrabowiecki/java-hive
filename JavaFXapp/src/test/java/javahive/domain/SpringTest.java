package javahive.domain;

import static org.hamcrest.Matchers.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javafx.fxml.FXMLLoader;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.*; 

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fixy.Fixy;
import com.fixy.JpaFixyBuilder;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:testApplicationContext.xml")
@Transactional
public class SpringTest {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Inject Finder finder;
	@Inject DBFiller dbFiller;
	
	
	@Before
	public void fill(){
		dbFiller.fill();
	}
	
	@Test
	public void sprawdzLiczbeStudentow(){
		assertThat(finder.findAll(Student.class).size(),is(2));
		Student s=new Student();
		s.setImie("Jan");
		s.setNazwisko("Kwas");
		entityManager.persist(s);
		assertThat(finder.findAll(Student.class).size(),is(3));
	}
	
	@Test
	public void sprawdzOceny(){
		Student s=finder.findAll(Student.class).get(0);
		System.out.println(s.getImie());
		Ocena o=new Ocena();
		o.setStudent(s);
		entityManager.persist(o);
		for(Ocena oc: finder.findAll(Ocena.class)){
			System.out.println(oc.getStudent().getImie());
		};
		System.out.println(s.getOceny());
	}
}
