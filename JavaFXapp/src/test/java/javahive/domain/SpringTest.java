package javahive.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
		s.getOceny().add(o);
		entityManager.persist(o);
		entityManager.flush();
		
		assertThat(s.getOceny().size(),is(1));
		System.out.println(s.getOceny());
	}
}
