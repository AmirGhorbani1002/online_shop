package entity;

public class Person {

    private String firstname;
    private String lastname;
    private String nationalCode;

    public Person(String firstname, String lastname, String nationalCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

}
