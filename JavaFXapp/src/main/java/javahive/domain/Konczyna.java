package javahive.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Konczyna {
	@Id
	private long id;
	
	@OneToOne
	private Czlowiek czlowiek;
	

}
