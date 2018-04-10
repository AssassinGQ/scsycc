package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.dao.UserDao;
import cn.AssassinG.scsycc.entitys.User.entity.User;

public class UserServices {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public long create(User user) {
        return userDao.insert(user);
    }

    public User getById(Long userId) {
        User user = userDao.getById(userId);
        if(user.isDeleted())
            return null;
        else
            return user;
    }

    public void deleteUserById(long userId) {
        User user = userDao.getById(userId);
        if (user != null) {
            userDao.deleteById(user.getId());
        }
    }

    public User findUserByUname(String username){
        return userDao.findByUserName(username);
    }
}
