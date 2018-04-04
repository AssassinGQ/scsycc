package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class UserGroup_Role extends BaseEntity {
    private Long usergroup_id;
    private Long role_id;

    public UserGroup_Role() {
    }

    public Long getUsergroup_id() {
        return usergroup_id;
    }

    public void setUsergroup_id(Long usergroup_id) {
        this.usergroup_id = usergroup_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
