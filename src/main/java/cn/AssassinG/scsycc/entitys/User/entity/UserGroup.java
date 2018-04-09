package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class UserGroup extends BaseEntity {
    private String UserGroupName;
    private Long FatherGroupId;

    public UserGroup() {
    }

    public String getUserGroupName() {
        return UserGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        UserGroupName = userGroupName;
    }

    public Long getFatherGroupId() {
        return FatherGroupId;
    }

    public void setFatherGroupId(Long fatherGroupId) {
        FatherGroupId = fatherGroupId;
    }
}
