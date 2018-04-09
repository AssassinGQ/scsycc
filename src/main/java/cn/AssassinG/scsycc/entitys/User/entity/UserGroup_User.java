package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class UserGroup_User extends BaseEntity {
    private Long UserGroupId;
    private Long UserId;

    public UserGroup_User() {
    }

    public Long getUserGroupId() {
        return UserGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        UserGroupId = userGroupId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
}
