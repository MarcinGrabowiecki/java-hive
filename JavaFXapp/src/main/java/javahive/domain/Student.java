package javahive.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Student extends BaseEntity {
	private String imie;
	private String nazwisko;
	private boolean wieczny;
	@ManyToOne
	private Ocena ocena;
	public Student(){};
}
