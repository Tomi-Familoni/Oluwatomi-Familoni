package helpers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "username", "firstName", "lastName", "email", "password", "phone", "userStatus"})
public class User {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    public User() {
        this.id = 0;
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.phone = "";
        this.userStatus = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String passsword) {
        this.password = passsword;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserStatus() {
        return userStatus;
    }
}
