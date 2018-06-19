package by.it.shumilov.jd03_02.beans;

public class User {
    long id;
    String login;
    String password;
    String email;
    long roles_id;


    public User(){

    }

    public User(long id,
            String login,
            String password,
            String email,
            long roles_id){
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_id = roles_id;


    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getRoles_id() {
        return roles_id;
    }
}
