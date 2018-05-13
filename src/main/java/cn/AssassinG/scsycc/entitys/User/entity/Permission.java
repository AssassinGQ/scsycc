package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

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
}
