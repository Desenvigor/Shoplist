package br.com.desenvigor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String ssn;
    private Date birthdate;

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }

    public Client() {
    }

    public Client(String name, String ssn, Date birthdate) {
        this.name = name;
        this.ssn = ssn;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
