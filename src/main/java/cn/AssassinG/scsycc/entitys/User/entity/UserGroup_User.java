package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class UserGroup_User extends BaseEntity {
    private Long usergroup_id;
    private Long user_id;

    public UserGroup_User() {
    }

    public Long getUsergroup_id() {
        return usergroup_id;
    }

    public void setUsergroup_id(Long usergroup_id) {
        this.usergroup_id = usergroup_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
