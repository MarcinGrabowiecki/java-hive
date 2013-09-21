package javafxapplication2.api;

import javahive.domain.Finder;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class API {
	@Inject
	private Finder finder;
	
	void getAllStudents(){
		
	}
	
	
}
