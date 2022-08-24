package service.person;

import entity.Person;
import repository.person.PersonRepositoryImpl;
import service.person.interfaces.PersonService;

public class PersonServiceImpl implements PersonService {

    private final PersonRepositoryImpl personRepository = new PersonRepositoryImpl();

    @Override
    public void save(String firstname, String lastname, String nationalCode){
        if(personRepository.loadByNationalCode(nationalCode) == null){
            personRepository.save(new Person(firstname,lastname,nationalCode));
        }
    }

    @Override
    public Person loadByNationalCode(String nationalCode){
        return personRepository.loadByNationalCode(nationalCode);
    }

    @Override
    public Person loadById(long id){
        return personRepository.loadById(id);
    }

}
