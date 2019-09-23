package pl.coderslab.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String login;
    @Column
    private Integer pushUpsRep;
    @Column
    private Integer sitUpsRep;



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPushUpsRep() {
        return pushUpsRep;
    }

    public void setPushUpsRep(Integer pushUpsRep) {
        this.pushUpsRep = pushUpsRep;
    }

    public Integer getSitUpsRep() {
        return sitUpsRep;
    }

    public void setSitUpsRep(Integer sitUpsRep) {
        this.sitUpsRep = sitUpsRep;
    }
}
