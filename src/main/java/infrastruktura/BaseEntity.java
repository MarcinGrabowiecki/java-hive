package infrastruktura;

import javax.persistence.*;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@MappedSuperclass
@Component
public class BaseEntity {
    @Transient
    @PersistenceContext
    private EntityManager entityManager;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	int id;

    public void getC(){
        System.out.println(this.getClass());
    }

}
