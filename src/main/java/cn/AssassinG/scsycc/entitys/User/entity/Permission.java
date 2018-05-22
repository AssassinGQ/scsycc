package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

import java.util.Objects;

public class Permission extends BaseEntity {
    private String PermissionName;

    public Permission() {
    }

    public String getPermissionName() {
        return PermissionName;
    }

    public void setPermissionName(String permissionName) {
        PermissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "PermissionName='" + PermissionName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        return PermissionName != null ? PermissionName.equals(that.PermissionName) : that.PermissionName == null;
    }

    @Override
    public int hashCode() {
        return PermissionName != null ? PermissionName.hashCode() : 0;
    }
}
