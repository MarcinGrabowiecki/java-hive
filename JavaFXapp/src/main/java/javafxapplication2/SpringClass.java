package javafxapplication2;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javahive.domain.DBFiller;
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
	
	@Inject
	DBFiller dbFiller;
	
	@Transactional
	public List<Student> test(){
		dbFiller.fill();
		
		return finder.findAll(Student.class);
		}

}
