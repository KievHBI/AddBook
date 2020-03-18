// https://github.com/promoscow/modelmapper-demo/blob/master/src/main/java/ru/xpendence/modelmapperdemo/mapper/CupcakeMapper.java

package ua.hbi.PersonManager.dto;

import ua.hbi.PersonManager.model.Address;
import ua.hbi.PersonManager.model.Contact;

public class PersonDTO {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String organization;
    private Address address;
    private Contact contact;

    public PersonDTO(String name, String surname, String patronymic, String organization, Address address, Contact contact) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.organization = organization;
        this.address = address;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "\nPersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", organization='" + organization + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                '}';
    }
}
