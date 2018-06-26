package by.it.rogov.jd03_02.beans;

public class Permission {
    // переделать на булион в таблицах в сех инты
    private long id;
    private int pemissionAccess;
    private int permissionUpdate;
    private long users_id;
    private long labrary_ID;

    public Permission() {
    }

    public Permission(long id, int pemissionAccess, int permissionUpdate, long users_id, long labrary_ID) {
        this.id = id;
        this.pemissionAccess = pemissionAccess;
        this.permissionUpdate = permissionUpdate;
        this.users_id = users_id;
        this.labrary_ID = labrary_ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int isPemissionAccess() {
        return pemissionAccess;
    }

    public void setPemissionAccess(int pemissionAccess) {
        this.pemissionAccess = pemissionAccess;
    }

    public long getUsers_id() {
        return users_id;
    }

    public long getLibrary_id() {
        return labrary_ID;
    }

    public int isPermissionUpdate() {
        return permissionUpdate;
    }

    public void setPermissionUpdate(int permissionUpdate) {
        this.permissionUpdate = permissionUpdate;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pemissionAccess=" + pemissionAccess +
                ", permissionUpdate=" + permissionUpdate +
                ", users_id=" + users_id +
                ", library_id=" + labrary_ID +
                '}';
    }
}
