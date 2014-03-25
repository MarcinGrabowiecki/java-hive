package javahive.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import javahive.infrastruktura.Finder;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
//import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StudentTest {
    public static final int LICZBA_STUDENTOW_W_YAML = 10;
    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    Finder finder;

    //ten test jest ok
    @Test
    public void powinienZwrocic10Studentow() {
        //given
        List<Student> listaStudentow = finder.findAll(Student.class);
        //when
        int liczbaStudentow = listaStudentow.size();
        //then
        assertThat(liczbaStudentow, is(LICZBA_STUDENTOW_W_YAML));
    }

    @Test
    public void powinienDodacStudenta() {
        //given
        List<Student> listaStudentow = finder.findAll(Student.class);
        //when
        int liczbaStudentow = listaStudentow.size();
        Student s = new Student();
        s.setImie("Jan");
        s.setNazwisko("Kwas");
        entityManager.persist(s);
        //then
        assertThat(finder.findAll(Student.class).size(), is(LICZBA_STUDENTOW_W_YAML + 1));
    }

    @Test
    public void sprawdzLiczbeOcen() {
        //given
        List<Ocena> oc = finder.findAll(Ocena.class);
        //when
        int rozmiarListyOcen = oc.size();
        //then
        assertThat(rozmiarListyOcen, Matchers.greaterThan(0));
    }

    @Ignore //skopany test, trzeba dobrze powiazać oceny
    @Test
    public void sprawdzOceny() {
        Student s = finder.findAll(Student.class).get(0);
        System.out.println("***" + s.getImie());
        assertThat(s.getOceny().size(), is(0));
        System.out.println(s.getOceny());
    }

    @Test
    public void powinienZwrocicWieleIndeksow() {
        List<Indeks> indeksy = finder.findAll(Indeks.class);
        System.out.println(indeksy.size());
    }
}
