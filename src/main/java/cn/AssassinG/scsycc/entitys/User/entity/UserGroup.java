package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class UserGroup extends BaseEntity {
    private String usergroup_name;
    private Long father_group_id;

    public UserGroup() {
    }

    public String getUsergroup_name() {
        return usergroup_name;
    }

    public void setUsergroup_name(String usergroup_name) {
        this.usergroup_name = usergroup_name;
    }

    public Long getFather_group_id() {
        return father_group_id;
    }

    public void setFather_group_id(Long father_group_id) {
        this.father_group_id = father_group_id;
    }
}
