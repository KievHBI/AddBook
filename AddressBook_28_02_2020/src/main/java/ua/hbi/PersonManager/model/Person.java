package ua.hbi.PersonManager.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="patronymic")
    private String patronymic;

    @Column(name="organization")
    private String organization;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", updatable = false)
    @JsonManagedReference
    private Address address;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "contact_id", updatable = false)
    private Contact contact;


    public Person() {
    }

    public Person(String name, String surname, String patronymic, String organization) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.organization =organization;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)

    {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(patronymic, person.patronymic) &&
                Objects.equals(organization, person.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, organization);
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", organization='" + organization + '\'' +
                ", address=" + address +
                ", contacts=" + contact +
                '}';
    }
}
