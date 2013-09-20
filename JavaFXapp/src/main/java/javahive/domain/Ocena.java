package javahive.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	private Student student;
	@ManyToOne
	private Przedmiot przedmiot;
}
