package javahive.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Czlowiek {
	
	@Id
	private long id;
	
	@OneToMany(mappedBy="czlowiek")
	private List<Konczyna> konczyny;

}
