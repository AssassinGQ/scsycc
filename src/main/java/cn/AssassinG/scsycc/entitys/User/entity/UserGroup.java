package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class UserGroup extends BaseEntity {
    private String UserGroupName;
    private String UserGroupDesc;
    private String FatherGroupName;

    public UserGroup() {
    }

    public String getUserGroupName() {
        return UserGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        UserGroupName = userGroupName;
    }

    public String getUserGroupDesc() {
        return UserGroupDesc;
    }

    public void setUserGroupDesc(String userGroupDesc) {
        UserGroupDesc = userGroupDesc;
    }

    public String getFatherGroupName() {
        return FatherGroupName;
    }

    public void setFatherGroupName(String fatherGroupName) {
        FatherGroupName = fatherGroupName;
    }
}
