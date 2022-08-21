package service;

import entity.Person;
import repository.PersonRepositoryImpl;

public class PersonServiceImpl {

    private final PersonRepositoryImpl personRepository = new PersonRepositoryImpl();

    public void save(String firstname, String lastname, String nationalCode){
        if(personRepository.loadByNationalCode(nationalCode) == null){
            personRepository.save(new Person(firstname,lastname,nationalCode));
        }
    }

    public Person loadByNationalCode(String nationalCode){
        return personRepository.loadByNationalCode(nationalCode);
    }
    public Person loadById(long id){
        return personRepository.loadById(id);
    }

}
