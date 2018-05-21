package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.dao.UserDao;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public long create(User user) {
        System.out.println("In UserService :"+user);
        return userDao.insert(user);
    }

    public User findUserById(Long userId) {
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
