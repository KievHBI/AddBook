package ua.hbi.PersonManager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContact;

    private String mphone;
    private String hphone;
    private String wphone;
    private String email;
    private String skype;

    @OneToOne(mappedBy = "contact") //, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private Person person;

    public Contact() {
    }

    public Contact(String mphone, String hphone, String wphone, String email, String skype) {
        this.mphone = mphone;
        this.hphone = hphone;
        this.wphone = wphone;
        this.email = email;
        this.skype = skype;
    }

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(idContact, contact.idContact) &&
                Objects.equals(mphone, contact.mphone) &&
                Objects.equals(hphone, contact.hphone) &&
                Objects.equals(wphone, contact.wphone) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(skype, contact.skype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContact, mphone, hphone, wphone, email, skype);
    }

    @Override
    public String toString() {
        return "\nContact{" +
                "id=" + idContact +
                ", mphone='" + mphone + '\'' +
                ", hphone='" + hphone + '\'' +
                ", wphone='" + wphone + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                '}';
    }
}
