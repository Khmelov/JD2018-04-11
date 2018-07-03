package by.it.rogov.progect.java.beans;

public class Permission {
    // переделать на булион в таблицах в сех инты
    private long id;
    private int pemissionAccess;
    private long users_id;


    public Permission() {
    }

    public Permission(long id, int pemissionAccess, long users_id) {
        this.id = id;
        this.pemissionAccess = pemissionAccess;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPemissionAccess() {
        return pemissionAccess;
    }

    public void setPemissionAccess(int pemissionAccess) {
        this.pemissionAccess = pemissionAccess;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }


    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pemissionAccess=" + pemissionAccess +
                ", users_id=" + users_id +
                '}';
    }
}
