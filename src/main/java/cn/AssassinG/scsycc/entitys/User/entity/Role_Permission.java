package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class Role_Permission extends BaseEntity {
    private Long RoleId;
    private Long PermissionId;

    public Role_Permission() {
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public Long getPermissionId() {
        return PermissionId;
    }

    public void setPermissionId(Long permissionId) {
        PermissionId = permissionId;
    }
}
