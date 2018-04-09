package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class UserGroup_Role extends BaseEntity {
    private Long UserGroupId;
    private Long RoleId;

    public UserGroup_Role() {
    }

    public Long getUserGroupId() {
        return UserGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        UserGroupId = userGroupId;
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }
}
