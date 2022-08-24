package repository.person.interfaces;

import entity.Person;

public interface PersonRepository {

    void save(Person person);
    Person loadByNationalCode(String nationalCode);
    Person loadById(long id);

}
