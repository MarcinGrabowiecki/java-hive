package javahive.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Ocena extends BaseEntity{
	public Ocena(){};
	private String wysokosc;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	@OneToOne
	private Przedmiot przedmiot;

}
