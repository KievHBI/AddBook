package ua.hbi.PersonManager.dto;

import ua.hbi.PersonManager.model.Person;


public class ContactDTO {

    private Long idContact;
    private String mphone;
    private String hphone;
    private String wphone;
    private String email;
    private String skype;
    private Person person;

    public ContactDTO(String mphone, String hphone, String wphone, String email, String skype, Person person) {
        this.mphone = mphone;
        this.hphone = hphone;
        this.wphone = wphone;
        this.email = email;
        this.skype = skype;
        this.person = person;
    }

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getWphone() {
        return wphone;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "\nContactDTO{" +
                "idContact=" + idContact +
                ", mphone='" + mphone + '\'' +
                ", hphone='" + hphone + '\'' +
                ", wphone='" + wphone + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", person=" + person +
                '}';
    }
}
