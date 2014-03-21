package javahive.domain;

import infrastruktura.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by m on 2014-03-21.
 */
@Data
@Entity
@ToString
public class Indeks extends BaseEntity {
    public Indeks(){};
    @OneToOne
    private Student student;
    private String numer;
}
