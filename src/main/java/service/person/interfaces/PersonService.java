package service.person.interfaces;

import entity.Person;

public interface PersonService {

    void save(String firstname, String lastname, String nationalCode);
    Person loadByNationalCode(String nationalCode);
    Person loadById(long id);
}
