package javahive.domain;

import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

import lombok.Setter;

import org.junit.Before;
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
	@Inject Finder finder;
	
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
    	List<Ocena> oc=finder.findAll(Ocena.class);
    	System.out.println("$$$"+oc.size());
    }
    
	@Test
	public void sprawdzOceny(){
		Student s=finder.findAll(Student.class).get(0);
		System.out.println("***"+s.getImie());		
		assertThat(s.getOceny().size(),is(1));
		System.out.println(s.getOceny());
	}

    public void powinienZwrocicWieleIndeksow(){
        Indeks indeksy=finder.findAll(Indeks.class);
    }
}
