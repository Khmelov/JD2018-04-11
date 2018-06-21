package by.it.dkruchek.jd03_02.beans;

public class Employee {

    long id;
    String name;
    String lastname;
    String password;
    String email;
    Long role_id;


    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Employee(long id, String name, String lastname, String password, String email, Long role_id) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.role_id = role_id;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Long getRole_id() {
        return role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
