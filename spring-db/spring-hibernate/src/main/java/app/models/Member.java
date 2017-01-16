package app.models;

import java.util.Date;



import app.models.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="member")
public class Member extends BaseModel {

    public String username;
    public String password;

    public String email;
    public String fullName; //


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
