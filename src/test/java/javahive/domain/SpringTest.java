package javahive.domain;

import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import infrastruktura.GenericFinder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
//import static org.hamcrest.CoreMatchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:testApplicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SpringTest {
		
	@PersistenceContext
	private EntityManager entityManager;
	@Inject
    GenericFinder genericFinder;
	
	@Test
	public void sprawdzLiczbeStudentow(){
		assertThat(genericFinder.findAll(Student.class).size(),is(5));
		Student s=new Student();
		s.setImie("Jan");
		s.setNazwisko("Kwas");
		entityManager.persist(s);
		assertThat(genericFinder.findAll(Student.class).size(),is(6));
	}
	
    @Test
    public void testPet() {
        //PetType dog = entityManager.createQuery("select type from PetType type where type.name = 'Dog'", PetType.class).getSingleResult();
        //System.out.println("+++"+dog.getPets().size());
        //assertThat(dog.getName(), is("Dog"));
    }
 
    @Test
    public void testPet1() {
        //Pet fido = entityManager.createQuery("select pet from Pet pet where pet.name = 'Fido'", Pet.class).getSingleResult();
    	//Pet fido=finder.findAll(Pet.class).get(0);
        //System.out.println("+++"+fido.getName());
    }   
	
    @Test
    public void sprawdzLiczbeOcen(){
    	List<Ocena> oc= genericFinder.findAll(Ocena.class);
    	System.out.println("$$$"+oc.size());
    }
    
	@Test
	public void sprawdzOceny(){
		Student s= genericFinder.findAll(Student.class).get(0);
		System.out.println("***"+s.getImie());		
		assertThat(s.getOceny().size(),is(1));
		System.out.println(s.getOceny());
	}


    @Test
    public void daneStudentaPowinnySieAktualizowac(){
        Student s= genericFinder.findAll(Student.class).get(0);
        System.out.println("***"+s.getImie());
        s.setImie("Władimir");
        entityManager.persist(s);
        s= genericFinder.findAll(Student.class).get(0);
        System.out.println("***"+s.getImie());
        s.getC();
    }
}
