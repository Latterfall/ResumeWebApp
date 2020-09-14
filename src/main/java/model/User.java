package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
@PersistenceUnit
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    long userID;

    @Column(name = "name")
    String name;

    @Column(name = "lastname")
    String lastName;

    @Column(name = "password")
    char[] password;

    public User() {
    }

    public User(long userID, String name, String lastName, char[] password) {
        this.userID = userID;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
