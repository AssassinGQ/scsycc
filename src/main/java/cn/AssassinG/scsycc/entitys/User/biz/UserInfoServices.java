package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.dao.UserInfoDao;
import cn.AssassinG.scsycc.entitys.User.entity.UserInfo;

public class UserInfoServices {
    private UserInfoDao userInfoDao;

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public long create(UserInfo userinfo) {
        return userInfoDao.insert(userinfo);
    }

    public UserInfo getById(Long userId) {
        return userInfoDao.getById(userId);
    }

    public void deleteUserById(long userId) {
        UserInfo userinfo = userInfoDao.getById(userId);
        if (userinfo != null) {
            userInfoDao.deleteById(userinfo.getId());
        }
    }
}
