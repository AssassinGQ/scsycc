package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.entity.User;

public interface UserService {
    long create(User user);
    User getById(Long userId);
    void deleteUserById(long userId);
    User findUserByUname(String username);
}
