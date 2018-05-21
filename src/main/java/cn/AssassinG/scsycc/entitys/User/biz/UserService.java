package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.entity.User;

public interface UserService {
    long create(User user);
    void deleteUserById(long userId);
    User findUserById(Long userId);
    User findUserByUname(String username);
}
