package by.it.lanevich.jd03_03.beans;

public class User {
    long id;
    String login;
    String password;
    String email;
    String phone;
    String address;
    long roles_id;

    public User() {
    }

    public User(long id, String login, String password, String email, String phone, String address, long roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.roles_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.email = address;
    }

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
