package javahive.domain.impl;

import javahive.domain.RepozytoriumStudent;
import javahive.domain.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by m on 2014-03-25.
 */
@Component
public class RepozytoriumStudentImpl implements RepozytoriumStudent {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student getStudentPoNazwisku(String nazwisko) {
        Session session=entityManager.unwrap(Session.class);
        //return session.createCriteria(nu).uniqueResult();
        //TODO zaimplementować
        return null;
    }

    @Override
    public List<Student> getStudenciPoNazwiskuZaczynajacymSieOdLiter(String nazwisko) {
        return null;
    }
}
