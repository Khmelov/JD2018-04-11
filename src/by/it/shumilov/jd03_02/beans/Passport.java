package by.it.shumilov.jd03_02.beans;

public class Passport {
    private long id;
    private String firstname;
    private String lastname;
    private String pasportid;
    private String phone;
    private long users_id;

    public Passport(long id, String firstname, String lastname, String pasportid, String phone, long users_id) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pasportid = pasportid;
        this.phone = phone;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPasportid() {
        return pasportid;
    }

    public void setPasportid(String pasportid) {
        this.pasportid = pasportid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pasportid='" + pasportid + '\'' +
                ", phone='" + phone + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}

