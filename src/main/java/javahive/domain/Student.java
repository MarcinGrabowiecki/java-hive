package javahive.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import infrastruktura.BaseEntity;
import org.hibernate.annotations.Fetch;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Student extends BaseEntity {
	public Student(){};
	private String imie;
	private String nazwisko;
	private boolean wieczny;
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	private List<Ocena> oceny=Lists.newArrayList();
}
