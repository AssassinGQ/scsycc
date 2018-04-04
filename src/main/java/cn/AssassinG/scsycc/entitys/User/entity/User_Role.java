package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class User_Role extends BaseEntity {
    private Long user_id;
    private Long role_id;

    public User_Role() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
