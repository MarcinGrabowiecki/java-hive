package javahive.domain;

import javax.persistence.Entity;

import lombok.Getter;


@Entity
@Getter
public class Przedmiot extends BaseEntity{
	private String nazwa;
}
