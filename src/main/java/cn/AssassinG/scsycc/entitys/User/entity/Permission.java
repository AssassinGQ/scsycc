package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class Permission extends BaseEntity {
    private String PermissionName;
    private String PermissionDesc;

    public Permission() {
    }

    public String getPermissionName() {
        return PermissionName;
    }

    public void setPermissionName(String permissionName) {
        PermissionName = permissionName;
    }

    public String getPermissionDesc() {
        return PermissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        PermissionDesc = permissionDesc;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "PermissionName='" + PermissionName + '\'' +
                ", PermissionDesc='" + PermissionDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (PermissionName != null ? !PermissionName.equals(that.PermissionName) : that.PermissionName != null)
            return false;
        return PermissionDesc != null ? PermissionDesc.equals(that.PermissionDesc) : that.PermissionDesc == null;
    }

    @Override
    public int hashCode() {
        int result = PermissionName != null ? PermissionName.hashCode() : 0;
        result = 31 * result + (PermissionDesc != null ? PermissionDesc.hashCode() : 0);
        return result;
    }
}
