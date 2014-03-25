package javahive.domain;

import java.util.List;

/**
 * Created by m on 2014-03-25.
 */
public interface RepozytoriumStudent {
    Student getStudentPoNazwisku(String nazwisko);
    List<Student> getStudenciPoNazwiskuZaczynajacymSieOdLiter(String nazwisko);
}
