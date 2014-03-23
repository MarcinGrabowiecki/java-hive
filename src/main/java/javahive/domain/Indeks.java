package javahive.domain;


import javahive.infrastruktura.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

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
