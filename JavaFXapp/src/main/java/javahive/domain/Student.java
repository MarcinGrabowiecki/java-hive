package javahive.domain;

import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
public class Student extends BaseEntity {
	String imie;
	String nazwisko;
}
