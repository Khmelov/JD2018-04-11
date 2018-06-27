package by.it.tayanovskii.jd03_03.beans;

public class Permission {

    private long id;
    private boolean access;
    private long users_id;
    private long publications_id;

    public Permission() {
    }

    public Permission(long id, boolean access, long users_id, long publications_id) {
        this.id = id;
        this.access = access;
        this.users_id = users_id;
        this.publications_id = publications_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public long getPublications_id() {
        return publications_id;
    }

    public void setPublications_id(long publications_id) {
        this.publications_id = publications_id;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", access=" + access +
                ", users_id=" + users_id +
                ", publications_id=" + publications_id +
                '}';
    }
}
