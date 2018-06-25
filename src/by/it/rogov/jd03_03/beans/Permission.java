package by.it.rogov.jd03_03.beans;

public class Permission {
    // переделать на булион в таблицах в сех инты
    private long id;
    private boolean pemissionAccess;
    private long users_id;
    private long library_id;
    private boolean permissionUpdate;

    public Permission() {
    }

    public Permission(long id, boolean pemissionAccess, long users_id, long library_id, boolean permissionUpdate) {
        this.id = id;
        this.pemissionAccess = pemissionAccess;
        this.users_id = users_id;
        this.library_id = library_id;
        this.permissionUpdate = permissionUpdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPemissionAccess() {
        return pemissionAccess;
    }

    public void setPemissionAccess(boolean pemissionAccess) {
        this.pemissionAccess = pemissionAccess;
    }

    public long getUsers_id() {
        return users_id;
    }

    public long getLibrary_id() {
        return library_id;
    }

    public boolean isPermissionUpdate() {
        return permissionUpdate;
    }

    public void setPermissionUpdate(boolean permissionUpdate) {
        this.permissionUpdate = permissionUpdate;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pemissionAccess=" + pemissionAccess +
                ", users_id=" + users_id +
                ", library_id=" + library_id +
                ", permissionUpdate=" + permissionUpdate +
                '}';
    }
}
